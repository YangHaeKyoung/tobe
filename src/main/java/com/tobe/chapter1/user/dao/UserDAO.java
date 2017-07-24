package com.tobe.chapter1.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tobe.chapter1.user.domain.User;

public class UserDAO {

	public void add(User user) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

		PreparedStatement ps = c.prepareStatement("INSERT INTO user(id, nm, pw) VALUES (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa",
				"");

		PreparedStatement ps = c.prepareStatement("SELECT * FROM user WHERE id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();

		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("nm"));
		user.setPassword(rs.getString("pw"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDAO dao = new UserDAO();

		User user = new User();
		user.setName("양혜경");
		user.setId("hkyang1");
		user.setPassword("1234");

		dao.add(user);
		System.out.println("[" + user.getId() + "] 등록!");
		
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println("[" + user2.getId() + "] 조회!");
	}
}