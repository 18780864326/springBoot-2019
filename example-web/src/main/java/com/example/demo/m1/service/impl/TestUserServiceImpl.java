package com.example.demo.m1.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.m1.service.TestUserService;
import com.example.demo.repository.TestUserDao;

@Service
public class TestUserServiceImpl implements TestUserService {

	@Resource
	private TestUserDao userDao;
	
	@Override
	public 	JSONObject findUser() {
		String sql = "select t.id as id, t.user_name userName, t.password from TEST_USER t";
		List<Map<String,Object>> map = userDao.listBySqlToMap(sql);
		return (JSONObject) JSONObject.toJSON(map);
	}

}
