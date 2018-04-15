package com.dao.Impl;

import java.util.List;

import com.entity.UserInfo;

public interface UserDaoImp {
	public boolean check(UserInfo user);
	public boolean register(UserInfo user);
	public UserInfo showUser(String email);
	public boolean updateUser(UserInfo updateUser);
	public List<UserInfo> allUser();
}
