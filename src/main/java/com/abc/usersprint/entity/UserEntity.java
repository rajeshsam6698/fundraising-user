package com.abc.usersprint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usertable")
public class UserEntity {
	@Id
	@Column(name="userid")
	
	private int userId;
	
	
	@Column(name="username")
	private String userName;
	
	
	@Column(name="fullname")
	private String userFullName;
	
	
	@Column(name="email")
	private String userEmail;
	
	
	@Column(name="mobile")
	private String userMobile;
	
	
	@Column(name="idProof")
	private String userIdProof;
	
	
	@Column(name="address")
	private String userAddress;
	
	
	@Column(name="categoryname")
	private String categoryName;
	
	
	@Column(name="description")
	private String userDescription;
	
	
	@Column(name="fundamount")
	private float userFundAmount;
	

	@Column(name="account")
	private float userAccountNumber;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserIdProof() {
		return userIdProof;
	}

	public void setUserIdProof(String userIdProof) {
		this.userIdProof = userIdProof;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public float getUserFundAmount() {
		return userFundAmount;
	}

	public void setUserFundAmount(float userFundAmount) {
		this.userFundAmount = userFundAmount;
	}

	public float getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(float userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	
	
	
	
}
