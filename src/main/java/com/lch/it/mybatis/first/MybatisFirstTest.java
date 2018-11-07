package com.lch.it.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lch.it.mybatis.po.User;

/**
 * Alphabet-V
 * 2016-11-13
 * Description:第一个Mybatis测试�?
 */
public class MybatisFirstTest {

	// 根据id查询用户信息，得到一条记录结�?
	@Test
	public void findUserByIdTest() throws IOException {

		// Mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 加载总配置文�? 得到配置文件�?
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入Mybatis的配置文件信�?
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/**
		 * 通过SqlSession操作数据�?
		 * 第一个参数：映射文件中statement的id，等于namespace+"."+statement的id
		 * 第二个参数：指定和映射文件中�?匹配的parameterType类型的参�?
		 * sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对�?
		 * selectOne查询出一条记�?
		 */
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
		// 释放资源
		sqlSession.close();
	}

	// 根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件�?
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信�?
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// list中的user和映射文件中resultType�?指定的类型一�?
		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		System.out.println(list);
		sqlSession.close();
	}

	// 添加用户信息
	@Test
	public void insertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件�?
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信�?
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 插入用户对象
		User user = new User();
		user.setUsername("王小�?");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");
		sqlSession.insert("test.insertUser", user);
		// 提交事务
		sqlSession.commit();
		// 获取用户信息主键
		System.out.println(user.getId());
		// 关闭会话
		sqlSession.close();
	}

	// 根据id删除 用户信息
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件�?
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信�?
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 传入id删除 用户
		sqlSession.delete("test.deleteUser", 39);
		// 提交事务
		sqlSession.commit();
		// 关闭会话
		sqlSession.close();
	}

	// 更新用户信息
	@Test
	public void updateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件�?
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信�?
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 更新用户信息
		User user = new User();
		//必须设置id
		user.setId(41);
		user.setUsername("王大�?");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("河南郑州");
		sqlSession.update("test.updateUser", user);
		// 提交事务
		sqlSession.commit();
		// 关闭会话
		sqlSession.close();
	}
}