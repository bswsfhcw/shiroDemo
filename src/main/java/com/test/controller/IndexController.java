package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class IndexController {

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		String msg = "";
		model.addObject("message", msg);
		System.out.println("�����¼ҳ��");
		return model;
	}

	/**
	 * ʵ�ʵĵ�¼���� �����¼�ɹ�����ת����ҳ����¼ʧ�ܣ���ʧ����Ϣ�������û�
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/dologin")
	public ModelAndView doLogin(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("index");
		String msg = "";
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			System.out.println("subject.login:" + subject.isAuthenticated());
			if (subject.isAuthenticated()) {
				msg ="��¼�ɹ�,������ҳ";
				model.setViewName("home");
			} else {

			}
		} catch (IncorrectCredentialsException e) {
			msg = "��¼�������. Password for account " + token.getPrincipal() + " was incorrect.";
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "��¼ʧ�ܴ�������";
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "�ʺ��ѱ�����. The account for username " + token.getPrincipal() + " was locked.";
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "�ʺ��ѱ�����. The account for username " + token.getPrincipal() + " was disabled.";
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "�ʺ��ѹ���. the account for username " + token.getPrincipal() + "  was expired.";
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "�ʺŲ�����. There is no user with username of " + token.getPrincipal();
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "��û�еõ���Ӧ����Ȩ��" + e.getMessage();
			System.out.println(msg);
		}
		model.addObject("message", msg);
		return model;
	}
}