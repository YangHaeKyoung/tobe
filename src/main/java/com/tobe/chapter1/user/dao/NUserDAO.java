package com.tobe.chapter1.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tobe.chapter1.user.domain.User;

public class NUserDAO extends UserDAO {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		return c;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NUserDAO dao = new NUserDAO();

		User user = new User();
		user.setName("양혜경");
		user.setId("hkyang2");
		user.setPassword("1234");

		dao.add(user);
		System.out.println("[" + user.getId() + "] 등록!");
		
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println("[" + user2.getId() + "] 조회!");
	}
}