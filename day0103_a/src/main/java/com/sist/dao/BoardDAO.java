package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BoardVO;

public class BoardDAO {
	
	public int delete(BoardVO b) {
		int re = -1;
		String sql = "delete from board where no=? and pwd=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getPwd());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("삭제 : " + e.getMessage());
		}
		
		return re;
	}
	
	public int update(BoardVO b) {
		int re = -1;
		String sql = 
				"update board set title=?,content=?,fname=? where no=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getFname());
			pstmt.setInt(4, b.getNo());
			pstmt.setString(5, b.getPwd());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("수정 : " + e.getMessage());
		}
		System.out.println(re + "update");
		return re;
	}
	
	public BoardVO detail(int no) {
		BoardVO b = null;
		String sql = "select * from board where no=?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				b = new BoardVO(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getDate(6),
						res.getInt(7),
						res.getString(8),
						res.getString(9)
						);
			}
			
			ConnectionProvider.close(conn, pstmt, res);
		} catch (Exception e) {
			System.out.println("detail " + e.getMessage());
		}
		
		
		return b;
	}
	
	public int insert(BoardVO b) {
		String sql = "insert into board values(?, ?, ?, ?, ?, sysdate, 1, ?, ?)";
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setString(6, b.getFname());
			pstmt.setString(7, b.getIp());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return re;
	}
	
	
	public ArrayList<BoardVO> listBoard() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from board";
		
		try {
			ConnectionProvider cp = new ConnectionProvider();
			Connection conn = cp.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				list.add(new BoardVO(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getDate(6),
						res.getInt(7),
						res.getString(8),
						res.getString(9)
						));
			}
			
			cp.close(conn, stmt, res);
			
		} catch (Exception e) {
			System.out.println("board 목록 에러 : " + e.getMessage());
		}
		
		return list;
	}


	public int getNextNo() {
		int no = -1;
		String sql = "select nvl(max(no),0) + 1 from board";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			if(res.next()) {
				no = res.getInt(1);
			}
			
			ConnectionProvider.close(conn, stmt, res);
			
		} catch (Exception e) {
			System.out.println("get no : " + e.getMessage());
		}
		
		return no;
	}
}
