package com.example.demo.system.login.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.entity.SystemUser;
import com.example.demo.entity.TestUser;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.repository.TestUserDao;
import com.example.demo.system.login.dto.LoginDto;
import com.example.demo.system.login.service.LoginService;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl  implements LoginService{

	@Resource
	private SystemUserRepository  systemUserRepository;


	@Value("${context.login-title}")
	private String loginTitle;
	@Value("${context.project-directory}")
	private String rootDefault;

	@Override
	public SystemUser findUserInfoByDto(LoginDto loginDto) {
		String userName = loginDto.getUserName();
		String password = loginDto.getPassword();
		SystemUser   user=   systemUserRepository.findByUserNameAndUserPassword(userName, password);
		return user;
	}

	@Override
	public int logOut() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Map<String,String> loadPageContext(){
		HashMap<String, String> map = new HashMap<>();
		map.put("loginTitle",loginTitle);
		map.put("rootDefault",rootDefault);
		return map;
	}
}
