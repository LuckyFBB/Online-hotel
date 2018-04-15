package com.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.UserService;

public class UserAction{
	@Resource 
	UserService userService;
	private UserInfo loginUser;
	private UserInfo registerUser;
	private UserInfo updateUser;
	public UserInfo getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(UserInfo updateUser) {
		this.updateUser = updateUser;
	}
	public UserInfo getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(UserInfo loginUser) {
		this.loginUser = loginUser;
	}
	public UserInfo getRegisterUser() {
		return registerUser;
	}
	public void setRegisterUser(UserInfo registerUser) {
		this.registerUser = registerUser;
	}
	public String login()
	{
		if(userService.check(loginUser))
		{
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("user", loginUser);
			return "login_success";
		}
		return "login_fail";
	}
	public String register()
	{
		if(userService.register(registerUser))
			return "register_success";
		return "register_fail";
	}
	public String showUser()
	{
		UserInfo loginUser=(UserInfo) ActionContext.getContext().getSession().get("user");
		String email=loginUser.getEmail();
		UserInfo showUser=userService.showUser(email);
		if(showUser!=null)
		{
			ActionContext.getContext().getSession().put("showUser", showUser);
			return "showUser";
		}
		return "fail";
	}
	public String updateUser()
	{
		if(userService.updateUser(updateUser))
			return "update";
		return "fail";
	}
	public String allUser()
	{
		List<UserInfo> allUserList=userService.allUser();
		ActionContext.getContext().getSession().put("allUserList", allUserList);
		return "allUser";
	}
}
