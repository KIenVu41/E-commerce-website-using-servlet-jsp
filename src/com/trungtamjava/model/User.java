package com.trungtamjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String address;
	private String role;
}
