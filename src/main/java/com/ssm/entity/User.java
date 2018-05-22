package com.ssm.entity;

import java.io.*;

/**
 * 实体bean
 *   DB中的一张表  ---> Java实体bean(pojo/JavaBean)
 * @author liyan
 *
 */
public class User implements Serializable  // 序列化接口
{
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;

	private String  phone;

	private String address;

	// alt + shift + s  自动生成构造器 public getter/setter方法   toString()
	public User() {
		super();
	}

	public User(Integer id, String username, String password, String phone,
				String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", phone=" + phone + ", address=" + address + "]";
	}

}
