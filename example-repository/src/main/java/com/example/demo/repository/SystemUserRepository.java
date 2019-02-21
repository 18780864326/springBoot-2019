package com.example.demo.repository;

import org.baseRepository.first.BaseRepository;

import com.example.demo.entity.SystemUser;

public interface SystemUserRepository  extends BaseRepository<SystemUser,Long>{

	SystemUser findByUserNameAndUserPassword(String userName, String UserPassword);
	

}
