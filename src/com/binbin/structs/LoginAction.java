package com.binbin.structs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

public class LoginAction extends Action {
	public ActionForward excute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginActionForm laf = (LoginActionForm) form;
		String username = laf.getUsername();
		String password = laf.getPassword();

		UserManager userManager = new UserManager();

		// 传递用户名和密码
		try {
			userManager.login(username, password);
			request.setAttribute("username", username);
			return mapping.findForward("success");
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("msg", "用户不能找到，用户名称=[" + username + "+]");
		} catch (PasswordErrorException e) {
			e.printStackTrace();
			request.setAttribute("msg", "密码错误");
		}
		return mapping.findForward("error");
	}
}
