package com.lch.it.mybatis.dao;

import java.util.List;

import com.lch.it.mybatis.po.User;

/**
 * <p>Title: UserDao</p>
 * <p>Description: DAO接口，用户管�?</p>
 * @author	传智.燕青
 * @date	2015-4-22下午2:45:12
 * @version 1.0
 */
public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据用户名列查询用户列表
	public List<User> findUserByName(String name) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUser(int id) throws Exception;
}