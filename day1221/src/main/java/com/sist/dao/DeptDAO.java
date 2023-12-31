package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.DeptVO;

public class DeptDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##som";
	String password = "1234";
	
	public DeptVO findByDno(int dno) {
		DeptVO d = null;
		String sql = "select * from dept where dno = ?";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dno);
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				d = new DeptVO(
						res.getInt(1),
						res.getString(2),
						res.getString(3));
			}
			
			res.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("findByDno 에러 " + e.getMessage());
		}
		
		return d;
	}
	
	public ArrayList<DeptVO> deptList(){
		String sql = "select * from dept order by dno";
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Statement stmt = conn.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				list.add(new DeptVO(
						res.getInt(1),
						res.getString(2),
						res.getString(3)));
			}
			
		} catch (Exception e) {
			System.out.println("부서목록 오류 : " + e.getMessage());
		}
		
		return list;
	}
}
