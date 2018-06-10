package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bookstore.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/add_user.do", produces = "text/plain;charset=utf-8")
	public String insertUser(@RequestParam("user_name") String userName, String password, String phone,
			@RequestParam("real_name") String realName, String address) {
		return JSON.toJSONString(userService.insertUser(userName, password, phone, realName, address));
	}

	@ResponseBody
	@RequestMapping(value = "/user/get_user.do", produces = "text/plain;charset=utf-8")
	public String getUser(@RequestParam("user_name") String userName) {
		return JSON.toJSONString(userService.getUser(userName));
	}
}
