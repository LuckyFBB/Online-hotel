package com.entity;

import java.io.Serializable;

public class ManagerInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String managerId;//����Ա���
	private String managerName;//����Ա����
	private String password;//����
	public ManagerInfo(){}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
