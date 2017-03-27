package com.dcs.pojo;

import java.util.Date;

public class User {
	private Integer id;

	private String email;

	private String loginName;

	private String realName;

	private String password;

	private String level;

	private Integer creator;

	private Date createTime;

	private Integer reviser;

	private Date reviserTime;

	private String dataStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level == null ? null : level.trim();
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getReviser() {
		return reviser;
	}

	public void setReviser(Integer reviser) {
		this.reviser = reviser;
	}

	public Date getReviserTime() {
		return reviserTime;
	}

	public void setReviserTime(Date reviserTime) {
		this.reviserTime = reviserTime;
	}

	public String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", loginName=" + loginName + ", realName=" + realName
				+ ", password=" + password + ", level=" + level + ", creator=" + creator + ", createTime=" + createTime
				+ ", reviser=" + reviser + ", reviserTime=" + reviserTime + ", dataStatus=" + dataStatus + "]";
	}

}