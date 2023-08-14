package com.demain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderInfo {

	private String orderNo;

	private String orderName;

	private String userId;

	private String name;

}
