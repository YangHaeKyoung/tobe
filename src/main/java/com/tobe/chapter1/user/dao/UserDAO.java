package com.tobe.chapter1.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tobe.chapter1.user.domain.User;

public abstract class UserDAO {

	abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("INSERT INTO user(id, nm, pw) VALUES (?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		c.close();
	}
	

	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();

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
}