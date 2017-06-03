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

		// �����û���������
		try {
			userManager.login(username, password);
			request.setAttribute("username", username);
			return mapping.findForward("success");
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("msg", "�û������ҵ����û�����=[" + username + "+]");
		} catch (PasswordErrorException e) {
			e.printStackTrace();
			request.setAttribute("msg", "�������");
		}
		return mapping.findForward("error");
	}
}