package com.dao.Impl;

import com.entity.ManagerInfo;

public interface ManagerDaoImp {
	public boolean login(ManagerInfo manager); 
	public ManagerInfo find(String managerId);
}
