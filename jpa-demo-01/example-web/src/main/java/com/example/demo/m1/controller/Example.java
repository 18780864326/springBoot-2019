package com.example.demo.m1.controller;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.m1.service.TestUserService;

@RestController
@EnableAutoConfiguration
public class Example {
	@Resource
	private TestUserService testUserService;
	@RequestMapping("/")
		String home() {
			return "Hello World!";
		}
	@RequestMapping(path="/testUser" ,method=RequestMethod.GET)
	String testUser() {
		return testUserService.findUser().toJSONString();
	}

}
