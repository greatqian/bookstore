package com.bookstore.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.message.ResponseMes;
import com.bookstore.service.UserService;
import com.bookstore.utils.BaseJUnit;

public class UserServiceTest extends BaseJUnit{
	@Autowired
	private UserService userService;

	@Test
	public void testInsetUser() {
		ResponseMes responseMes = userService.insertUser("xiaoxiong", "123456", "18880191929", "张三", "湘潭大学琴湖18栋");
		assertTrue(responseMes.getMessage().equals("注册成功"));
	}

	/**
	 * 测试不存在的用户
	 */
	@Test
	public void testGetUser1() {
		ResponseMes responseMes = userService.getUser("testGetUser1");
		assertEquals("fail", responseMes.getStatus());
	}

	/**
	 * 测试存在的用户
	 */
	@Test
	public void testGetUser2() {
		testInsetUser();
		ResponseMes responseMes = userService.getUser("xiaoxiong");
		assertEquals("success", responseMes.getStatus());
	}
	
	@Test
	public void testUpdateUserInfo() {
		testInsetUser();
		ResponseMes responseMes = userService.updateUserInfo("xiaoxiong", "123456","654321", "12345644564", "你好", "湘潭大学琴湖18栋");
		System.out.println(responseMes.getMessage());
		assertEquals("success", responseMes.getStatus());
	}
}
