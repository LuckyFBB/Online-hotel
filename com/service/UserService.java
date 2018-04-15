package com.service;

import java.util.List;

import javax.annotation.Resource;
import com.dao.UserDao;
import com.entity.UserInfo;

public class UserService {
	@Resource
	UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public boolean check(UserInfo user)
	{
		return userDao.check(user);
	}
	public boolean register(UserInfo user)
	{
		return userDao.register(user);
	}
	public UserInfo showUser(String email)
	{
		return userDao.showUser(email);
	}
	public boolean updateUser(UserInfo user)
	{
		return userDao.updateUser(user);
	}
	public List<UserInfo> allUser()
	{
		return userDao.allUser();
	}
}
