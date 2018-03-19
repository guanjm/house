package gjm.house.common.account.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gjm.house.common.pojo.ResultInfo;

@Controller
@RequestMapping(value = "/account/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 跳转到登录界面
	 * @author guanjm
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginIndex() {
		return "/account/login/index";
	}
	
	/**
	 * 登录
	 * @author guanjm
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		ResultInfo result;
		try {
			//登录信息
			String userName = request.getParameter("a");
			String userPassword = request.getParameter("b");
			UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword, true);
//			String userName = request.getParameter("userName");
//			String userPassword = request.getParameter("userPassword");
//			boolean rememberMe = request.getParameter("rememberMe") != null;
			//登录令牌
//			UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword, rememberMe);
			//登录
			SecurityUtils.getSubject().login(token);
		} catch (AccountException e) {
			logger.info("login failed :{} ", e);
			result = new ResultInfo(1, "登录失败", e.getMessage());
		} catch (AuthenticationException e) {
			logger.info("login failed :{} ", e);
			result = new ResultInfo(1, "登录失败", "登录失败，请确认账号和密码");
		}
		//跳转到登录前页面
		SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		if(savedRequest != null) {
			result = new ResultInfo(1, "登录成功", savedRequest.getRequestUrl());
		}
		//跳转到默认首页
		result = new ResultInfo(1, "登录成功", "index");
		return result.toJsonString();
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request) {
		ResultInfo result;
		String methodName = request.getParameter("a");
		String b = request.getParameter("b");
		switch(methodName) {
			case "isPermitted" : {
				Object principal = SecurityUtils.getSubject().getPrincipal();
				boolean permitted = SecurityUtils.getSubject().isPermitted(b);
				System.out.println(permitted);
			}
		}
		result = new ResultInfo(1, "登录成功", "index");
		return result.toJsonString();
	}

}
