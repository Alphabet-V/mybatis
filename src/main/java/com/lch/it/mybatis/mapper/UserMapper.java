package com.lch.it.mybatis.mapper;

import java.util.List;

import com.lch.it.mybatis.po.User;
import com.lch.it.mybatis.po.UserCustom;
import com.lch.it.mybatis.po.UserQueryVo;

/**
 * <p>Title: UserMapper</p>
 * <p>Description: mapper接口，相当于dao接口，用户管�?</p>
 * @author	传智.燕青
 * @date	2015-4-22下午2:45:12
 * @version 1.0
 */
public interface UserMapper {
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	
	//根据用户名列查询用户列表
	public List<User> findUserByName(String name)throws Exception;
	
	//插入用户
	public void insertUser(User user)throws Exception;
	
	//删除用户
	public void deleteUser(int id)throws Exception;
}