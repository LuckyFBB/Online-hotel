package com.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.entity.ManagerInfo;
import com.opensymphony.xwork2.ActionContext;
import com.service.ManagerService;

@Controller
public class ManagerAction {
	@Resource 
	ManagerService managerService;
	private ManagerInfo manager;
	public ManagerInfo getManager() {
		return manager;
	}
	public void setManager(ManagerInfo manager) {
		this.manager = manager;
	}
	public String login()
	{
		managerService.login(manager);
		return "success";
	}
	public String findManager()
	{
		ManagerInfo findManager=managerService.findManager(manager.getManagerId());
		ActionContext.getContext().getSession().put("findManager", findManager);
		return "findManager";
	}
}
