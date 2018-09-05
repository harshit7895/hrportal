


package com.iilm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	private static Connection conn = null;
	static  {
		try {
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getDBCon() {
		if(conn != null) return conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrportal", "root", "root");
		} catch(SQLException e) {
			System.out.println("Exception in creating connection: " + e.getMessage());
		}
		return conn;
	}
	
	public void testResult() throws SQLException {
		Connection conn = getDBCon();
		Statement stmt = conn.createStatement();
		String query = "SELECT * from test";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			System.out.println("\n");
		}
	}
	
	
	public Boolean validateUser(String userName, String password) {
		Boolean status = false;
		try {
			Connection conn = getDBCon();
			String query = "SELECT * from USERS where user_name = ? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}
		} catch(Exception e) {
			status = false;
		}
		return status;
	}
}
