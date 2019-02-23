package com.example.demo.system.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.SystemUser;
import com.example.demo.entity.TestUser;
import com.example.demo.m2.dto.MonitorInfoDto;
import com.example.demo.system.login.dto.LoginDto;
import com.example.demo.system.login.service.LoginService;
import com.example.demo.vo.MessageInfo;

@RestController
@RequestMapping("/system")
public class LoginController {
		@Resource
		private LoginService loginService;

	/**
	 * 登录处理
	 * @param loginDto
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSystem(LoginDto loginDto,HttpSession session) {
			SystemUser user  =	loginService.findUserInfoByDto(loginDto);
			MessageInfo msg = new MessageInfo();
			msg.setStatus(1);
			msg.setMsg("登录成功");
			if(user != null) {
				session.setAttribute("userName", user.getUserName());
				msg.setStatus(1);
				msg.setMsg("登录成功");
			}else {
				msg.setStatus(0);
				msg.setMsg("登录失败，账户或者密码错误");
			}
			String str = JSONObject.toJSONString(msg).toString();
		return str;	
	}
	
	/**
	 * 退出 系统 
	 * @param loginDto
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logOut")
	public ModelAndView  logOut(LoginDto loginDto, ModelAndView  mv,HttpSession session) { 
		int status = loginService.logOut();
		session.setAttribute("userName", null); //销毁session 标识
			if(status ==1) {
			}
		mv.setViewName("redirect:/loginSystem.html");
		return mv;
	}
	
	/**
	 * 处理 未登录的 同步HTTP请求
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/notLogin")
	public ModelAndView  notLogin(ModelAndView mv) { 
		mv.setViewName("redirect:/static/html/conmmon/503.html");
		return mv;
	}
	
	/**
	 * 处理 未登录的 异步HTTP请求
	 * @param monitorInfoDto
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("longin_ajaxFilter")
	public String queryMonitorInfo(MonitorInfoDto monitorInfoDto, int pageSize, int pageIndex) {
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setStatus(400);
		messageInfo.setMsg("你尚未登录或长时间未操作，请重新登录");
		JSONObject object = (JSONObject) JSONObject.toJSON(messageInfo);
		return JSONObject.toJSONString(object);
	}
}
