package com.demain.controller;

import com.demain.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器
 *
 * @author demain_lee
 * @since 2023/8/14
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理")
public class UserController {

	/**
	 * 获取用户信息
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	@GetMapping("/getUserInfo/{userId}")
	@Operation(summary = "根据用户ID获取用户信息")
	@Parameters({ @Parameter(name = "id", description = "用户ID") })
	public User index(@PathVariable("userId") String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setName("张三");
		return user;
	}

	/**
	 * 用户列表
	 */
	@GetMapping("/list")
	public List<User> list() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setUserId("1");
		user.setName("张三");
		list.add(user);
		return list;

	}

}
