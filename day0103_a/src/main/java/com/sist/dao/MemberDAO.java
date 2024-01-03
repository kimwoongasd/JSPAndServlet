package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVO;

public class MemberDAO {
	
	public boolean login(String id, String pwd) {
		boolean re = false;
		String sql = "select * from member where id=? and pwd=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				re = true;
			}
			
			ConnectionProvider.close(conn, pstmt, res);
			
		} catch (Exception e) {
			System.out.println("로그인 " + e.getMessage());
		}
		
		
		return re;
	}
	
	/*
	public MemberVO login(String id, String pwd) {
		MemberVO m = new MemberVO();
		String sql = "select * from member where id=? and pwd=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				m.setId(res.getString(1));
				m.setPwd(res.getString(2));
				m.setName(res.getString(3));
				m.setEmail(res.getString(4));
				m.setPhone(res.getString(5));
			}
			
			ConnectionProvider.close(conn, pstmt, res);
			
		} catch (Exception e) {
			System.out.println("로그인 " + e.getMessage());
		}
		
		
		return m;
	}
	*/
	
	public int insertSignUp(MemberVO s) {
		int re = -1;
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getId());
			pstmt.setString(2, s.getPwd());
			pstmt.setString(3, s.getName());
			pstmt.setString(4, s.getEmail());
			pstmt.setString(5, s.getPhone());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("회원가입 sql " + e.getMessage());
		}
		
		return re;
	}
}
