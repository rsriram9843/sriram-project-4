package com.login.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.login.dao.*;
import com.login.dbutil.LoginDb;
public class LoginService implements UserDao {
	@Override
	public String loginUser(String username, String password) throws ClassNotFoundException{
	try {
		Connection con;
		con = LoginDb.getDBconnect();
		String sql = "select* from login";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			if(rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
				return "Welcome To The Page";
			}
		}
	}
	

catch(SQLException e) {
	System.out.println(e);
}
	return null;
	}
	
}
