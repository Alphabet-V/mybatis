package com.lch.it.mybatis.po;

import java.util.Date;

/**
 * Alphabet-V
 * 2016-11-13
 * Description:和表User对应的JavaBean
 */
public class User {
	
	private int id; 		 // 主键
	private String username; // 用户姓名
	private Date birthday;   // 生日
	private String sex;		 // 性别
	private String address;	 // 地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address + "]";
	}
}