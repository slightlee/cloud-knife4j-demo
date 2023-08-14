package com.demain.controller;

import com.demain.entity.Order;
import com.demain.entity.OrderInfo;
import com.demain.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单控制器
 *
 * @author demain_lee
 * @since 2023/8/14
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	/**
	 * 获取订单信息
	 * @param orderNo 订单号
	 * @return 订单信息
	 */
	@GetMapping("/getOrderInfo/{orderNo}")
	@Operation(summary = "根据订单Id获取订单信息")
	@Parameters({ @Parameter(name = "orderNo", description = "订单ID") })
	public Order index(@PathVariable("orderNo") String orderNo) {
		// 模拟假数据
		Order order = new Order();
		order.setOrderNo(orderNo);
		order.setOrderName("订单名称:" + orderNo);
		return order;
	}

	/**
	 * 订单列表
	 */
	@GetMapping("/list")
	public List<Order> list() {
		List<Order> list = new ArrayList<>();
		Order order1 = new Order();
		order1.setOrderNo("1");
		order1.setOrderName("订单名称:1");
		list.add(order1);
		return list;

	}

	/**
	 * 获取订单信息
	 * @param orderNo 订单号
	 * @return 订单信息
	 */
	@GetMapping("/getUserOrderInfo/{orderNo}")
	@Operation(summary = "根据订单Id获取订单信息")
	@Parameters({ @Parameter(name = "orderNo", description = "内容ID") })
	public OrderInfo getContentInfo(@PathVariable("orderNo") String orderNo) {
		// 用户信息
		RestTemplate restTemplate = new RestTemplate();
		String userId = "U0001";
		ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://127.0.0.1:8002/user/getUserInfo/{id}",
				User.class, userId);
		User user = responseEntity.getBody();
		assert user != null;
		// 订单信息
		return OrderInfo.builder().userId(user.getUserId()).name(user.getName()).orderNo(orderNo)
				.orderName("订单名称:" + orderNo).build();
	}

}
