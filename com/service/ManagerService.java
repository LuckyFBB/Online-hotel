package com.service;

import javax.annotation.Resource;

import com.dao.ManagerDao;
import com.entity.ManagerInfo;

public class ManagerService {
	@Resource
	ManagerDao managerDao;
	public ManagerDao getManagerDao() {
		return managerDao;
	}
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	public boolean login(ManagerInfo manager)
	{
		return managerDao.login(manager);
	}
	public ManagerInfo findManager(String managerId)
	{
		return managerDao.find(managerId);
	}
}
