package com.store.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.store.bean.UserInfo;


@Repository
public class LoginDaoImpl implements LoginDao{

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	
	public DataSource getDataSource() {
		return dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static class UserInfoRowMapper implements RowMapper<UserInfo>{

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			String username = rs.getString("username");
			String password = rs.getString("password");
			
			UserInfo user =  new UserInfo();
			user.setPassword(password);
			user.setUsername(username);
			
			return user;
		}
		
	}

	
	public UserInfo findUserInfo(String username) {
		
		String query = " select * from medicine_users where username = ?";
		
		
		try {
			UserInfo userInfo = jdbcTemplate.queryForObject(query, new Object[]{username},new UserInfoRowMapper());
			
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			System.out.println("ERROR" +e.getMessage());
			return null;
		}
	}

	public List<String> getUserRoles(String username) {
		
		String query = "select medicine_user_role from medicine_user_roles  where username = ?";

		try {
			List<String> roles = jdbcTemplate.queryForList(query, new Object[]{username}, String.class);

			return roles;
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	public boolean registeruser(String username, String password) {
		
		String query = " select count(*) from medicine_users where username = ?";
		int count = jdbcTemplate.queryForObject(query, new Object[]{username},Integer.class);
			
			if (count != 0) {
				return false;
			} else {

				String insertQuery = "insert into medicine_users (username,password) values (?,?)";
				int status = jdbcTemplate.update(insertQuery, new Object[] { username, password });

				if (1 == status) {
					return true;
				} else {
					return false;
				}
			}
		
	}
}
