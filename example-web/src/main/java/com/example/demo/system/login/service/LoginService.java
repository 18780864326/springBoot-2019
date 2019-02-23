package com.example.demo.system.login.service;

import com.example.demo.entity.SystemUser;
import com.example.demo.system.login.dto.LoginDto;

import java.util.Map;

public interface LoginService {

	/**
	 *  查询用户是否存在
	 * @param loginDto
	 * @return
	 */
	SystemUser findUserInfoByDto(LoginDto loginDto);

	/**
	 *退出登录
	 * @return
	 */
	int logOut();

	/**
	 *  加载登录页面环境配置
	 * @return
	 */
	 Map<String,String> loadPageContext();

}
