package com.interceptor;

import java.util.Map;

import org.junit.Test;

import com.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	@Test
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("��¼������");
		ActionContext actionContext=ActionContext.getContext();
		System.out.println(actionContext);
		Map<String, Object> session=actionContext.getSession();
		System.out.println(session);
		UserInfo loginUser=(UserInfo) session.get("loginUser");
		if(loginUser.getName()!=null)
		{
			System.out.println(loginUser.getName()+"��½�ɹ�");
			return "login_success";
		}
		else return "notLogin";
	}
}
