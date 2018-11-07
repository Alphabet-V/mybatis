package com.lch.it.mybatis.po;

import java.util.List;

/**
 * Alphabet-V
 * 2016-11-13
 * Description:封装查询的VO
 */
public class UserQueryVo {
	
	//传入多个id
	private List<Integer> ids;
	
	//在这里包装所�?要的查询条件
	
	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//可以包装其它的查询条件，订单、商�?
	//....
}
