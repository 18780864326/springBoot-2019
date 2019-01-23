package com.example.demo.system.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TestUser;
import com.example.demo.repository.TestUserDao;
import com.example.demo.system.login.dto.LoginDto;
import com.example.demo.system.login.service.LoginService;

@Service
public class LoginServiceImpl  implements LoginService{

	@Resource
	private TestUserDao testUserDao;
	
	@Override
	public TestUser findUserInfoByDto(LoginDto loginDto) {
		String userName = loginDto.getUserName();
		String password = loginDto.getPassword();
		TestUser  testUser =   testUserDao.findByUserNameAndPassword(userName, password);
		return testUser;
	}

	@Override
	public int logOut() {
		// TODO Auto-generated method stub
		return 1;
	}
}
