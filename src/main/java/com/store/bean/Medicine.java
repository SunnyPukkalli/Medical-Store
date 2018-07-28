package com.store.bean;

import java.sql.Date;

public class Medicine {

	private String medicineName;
	private String description;
	private String companyName;
	private String type;
	private Long mrp;
	private Date mfgDate;
	private Date expiryDate;
	private boolean status;
	
	public Medicine() {
	
	}

	public Medicine(String medicineName, String description, String companyName, String type, Long mrp, Date mfgDate,
			Date expiryDate, boolean status) {
		this.medicineName = medicineName;
		this.description = description;
		this.companyName = companyName;
		this.type = type;
		this.mrp = mrp;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getMrp() {
		return mrp;
	}

	public void setMrp(Long mrp) {
		this.mrp = mrp;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
