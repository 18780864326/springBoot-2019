package com.example.demo.system.login.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.dto.MessageInfo;
import com.example.demo.entity.TestUser;
import com.example.demo.system.login.dto.LoginDto;
import com.example.demo.system.login.service.LoginService;

@RestController
@RequestMapping("/system")
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginSystem(LoginDto loginDto) {
			TestUser user  =	loginService.findUserInfoByDto(loginDto);
			MessageInfo msg = new MessageInfo();
			if(user != null) {
				msg.setStatus(1);
				msg.setMsg("登录成功");
			}else {
				msg.setStatus(0);
				msg.setMsg("登录失败，账户或者密码错误");
			}
			String str = JSONObject.toJSONString(msg).toString();
		return str;	
	}
}
