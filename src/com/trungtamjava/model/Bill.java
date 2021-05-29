package com.trungtamjava.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	private int id;
	private User user;
	private Date buyDate;
	private double totalPrice;
}
