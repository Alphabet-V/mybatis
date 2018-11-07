package com.lch.it.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * <p>Title: JdbcTest</p>
 * <p>Description:通过单独的jdbc程序，�?�结其中的问�? </p>
 * @author	传智.燕青
 * @date	2015-4-22上午9:16:05
 * @version 1.0
 */
public class JdbcTest {
	
	public static void main(String[] args) {
		
		//数据库连�?
		Connection connection = null;
		//预编译的Statement，使用预编译的Statement提高数据库�?�能
		PreparedStatement preparedStatement = null;
		//结果 �?
		ResultSet resultSet = null;
		
		try {
			//加载数据库驱�?
			Class.forName("com.mysql.jdbc.Driver");
			
			//通过驱动管理类获取数据库链接
			connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?characterEncoding=utf-8", "root", "123456");
			//定义sql语句 ?表示占位�?
			String sql = "select * from user where id = ?";
			//获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			//设置参数，第�?个参数为sql语句中参数的序号（从1�?始），第二个参数为设置的参数�?
//			preparedStatement.setString(1, null);
			preparedStatement.setNull(1, Types.VARCHAR);
//			Integer i = null;
//			preparedStatement.setInt(1, i);
//			Double d = null;
//			preparedStatement.setDouble(2, d);
			System.err.println(preparedStatement.toString());
			//向数据库发出sql执行查询，查询出结果�?
			resultSet =  preparedStatement.executeQuery();
			//遍历查询结果�?
			while(resultSet.next()){
				System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}