package com.example.demo.repository;

import org.baseRepository.first.BaseRepository;

import com.example.demo.entity.TestUser;

//public interface TestUserDao  extends  JpaRepository<TestUser,Long>{
//
//}
public interface TestUserDao  extends  BaseRepository<TestUser,Long>{

	public TestUser findByUserNameAndPassword(String userName , String password);
}
