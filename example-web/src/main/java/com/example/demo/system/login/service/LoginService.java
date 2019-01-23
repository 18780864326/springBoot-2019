package com.example.demo.system.login.service;

import com.example.demo.entity.TestUser;
import com.example.demo.system.login.dto.LoginDto;

public interface LoginService {
	
	/**
	 *  查询用户是否存在
	 * @param loginDto
	 * @return
	 */
	TestUser findUserInfoByDto(LoginDto loginDto);

	int logOut();
}
