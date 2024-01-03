package com.sist.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			/*새로운 프로젝트를 만들고 서버로 가동시키면
			서버 프로젝트의 server.xml에서 위의 프로젝트 이름으로 새로운 context를 만드는데
			그 context에 미리 resource를 설정해서 드라이버 명령어를 안적고 드라이버 불러오는 방법 */
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection 에러 : " + e.getMessage());
		}
		
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("close 에러 : " + e.getMessage());
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet res) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
			if(res != null) {
				res.close();
			}
		} catch (Exception e) {
			System.out.println("close 에러 : " + e.getMessage());
		}
	}
}
