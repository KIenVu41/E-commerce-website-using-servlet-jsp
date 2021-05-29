package com.trungtamjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillProduct {
	private int id;
	private int quantity;
	private long price;
	private Bill bill;
	private Product product;
}
