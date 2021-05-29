package com.trungtamjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
	private int id;
	private String code;
	private int percent;
	private User user;
	private Bill bill;
	private String status;
}
