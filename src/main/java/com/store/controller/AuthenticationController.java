package com.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.store.service.LoginService;


@Controller
public class AuthenticationController {

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value="/")
	public ModelAndView main(){
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		ModelAndView map = new ModelAndView("index");
		map.addObject("main", "Main Page");
		map.addObject("username", username);
		return map;
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public ModelAndView loginGET(){
		
		ModelAndView map = new ModelAndView("login");
		map.addObject("msg", "login Page");
		return map;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam(value="error",required=false) String error){
		
		ModelAndView model = new ModelAndView();
		
		if(error!=null){
			model.addObject("error", "wrong credentails");
		}
		model.setViewName("login");	
		return model;
	}
	
	@RequestMapping(value={"/logout"})
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping(value={"/signup"}, method=RequestMethod.POST)
	public ModelAndView signUp(@RequestParam String username, @RequestParam String password){
		
		boolean status = loginService.registeruser(username, password);
		
		if(status){
		ModelAndView map = new ModelAndView("index");
		map.addObject("status", "Sign Up Successfull");
		map.addObject("username",username);
		return map;
		}else{
			ModelAndView map = new ModelAndView("index");
			map.addObject("error", "user already present");
			return map;
		}
		
	}
}
