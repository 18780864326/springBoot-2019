package com.example.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.StartUpApplication;
import com.example.demo.entity.TestUser;
import com.example.demo.repository.TestUserDao;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartUpApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserRepo {

	@Resource
	private TestUserDao dao ;
	
	@Test
	public void  testDao() {
//		TestUser  user  = new TestUser();
//         List<TestUser>	userList  =	dao.findAll();
//         for (TestUser testUser : userList) {
//		System.out.println(testUser);
//		}
         String sql =  "select * from TEST_USER t " ;
 	    List<TestUser>list =	dao.listBySqlToListEntity(sql,TestUser.class);
	 	   for (TestUser testUser : list) {
			System.out.println(testUser);
	 	   } 
	}
	@Test
	public void  listBySqlToOneColumn() {
		List<String> list = dao.listBySqlAndOneColumnToListStr("select user_name from TEST_USER t ");
		for (String str : list) {
			System.out.println(str);
		}
	}
	@Test
	public void  delectByUser() {
			Long id =  61L;
			dao.deleteById(id);
	}

	@Test
	public void listBySqlToTwoColumn() {
		 List<Map<String,Object>> list=	dao.listBySqlToMap("select * from TEST_USER t");
		JSONArray array = (JSONArray) JSONArray.toJSON(list);
	}
	@Test
	public void  testDaoSave() {
			Long id = dao.getTableSequencesToLong("SEQ_TEST_USER");
			System.out.println(id);
			TestUser  user  = new TestUser(id, "测试", "1234");
			dao.save(user);
		}
}
