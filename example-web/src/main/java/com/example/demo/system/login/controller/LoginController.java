package com.example.demo.system.login.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
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
		String str = JSONObject.toJSONString(user).toString();
		return str;	
	}
}
