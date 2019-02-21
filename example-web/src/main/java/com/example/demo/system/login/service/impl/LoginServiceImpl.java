package com.example.demo.system.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.entity.SystemUser;
import com.example.demo.entity.TestUser;
import com.example.demo.repository.SystemUserRepository;
import com.example.demo.repository.TestUserDao;
import com.example.demo.system.login.dto.LoginDto;
import com.example.demo.system.login.service.LoginService;

@Service
public class LoginServiceImpl  implements LoginService{

	@Resource
	private SystemUserRepository  systemUserRepository;
	
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
}
