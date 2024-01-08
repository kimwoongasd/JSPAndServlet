package com.sist.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvier {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				conn.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.out.println("닫기 오류 " + e.getMessage());
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("닫기 오류 " + e.getMessage());
		}
	}
}
