package com.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Impl.UserDaoImp;
import com.entity.UserInfo;

@Service @Transactional
public class UserDao implements UserDaoImp{
	@Resource
	SessionFactory sessionFactory;
	@Override
	public boolean check(UserInfo user) {
		// TODO Auto-generated method stub
		String email=user.getEmail();
		String pass=user.getPassword();
		String hql="from UserInfo as u where u.email=:email and u.password=:pass";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("email", email);
		query.setString("pass", pass);
		@SuppressWarnings("unchecked")
		List<UserInfo> result=query.list();
		Iterator<UserInfo> it=result.iterator();
		if(it.hasNext())
			return true;
		return false;
	}
	@Override
	public boolean register(UserInfo user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		return true;
	}
	@Override
	public UserInfo showUser(String email) {
		// TODO Auto-generated method stub
		UserInfo showUser=(UserInfo) sessionFactory.getCurrentSession().get(UserInfo.class, email);
		return showUser;
	}
	@Override
	public boolean updateUser(UserInfo updateUser) {
		// TODO Auto-generated method stub
		String hql="update UserInfo as user set user.name=:name,user.password=:pass,user.telphone=:phone,user.nickName=:nickName where user.email=:email";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("email", updateUser.getEmail());
		query.setString("name",updateUser.getName());
		query.setString("pass",updateUser.getPassword());
		query.setString("phone",updateUser.getTelphone());
		query.setString("nickName",updateUser.getNickName());
		if(query.executeUpdate()!=0)
			return true;
		return false;
	}
	@Override
	public List<UserInfo> allUser() {
		// TODO Auto-generated method stub
		String hql="from UserInfo as user";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserInfo> allUserList=query.list();
		return allUserList;
	}
}
