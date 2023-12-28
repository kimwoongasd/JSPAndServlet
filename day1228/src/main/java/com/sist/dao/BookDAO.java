package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	
	// 모든 도서 조회
	public ArrayList<BookVO> findAll(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book100";
		
		try {
			Connection conn = ConnectionProvider.getConnetction();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				list.add(new BookVO(
						res.getInt(1),
						res.getString(2),
						res.getInt(3),
						res.getString(4)
						));
			}
			
			ConnectionProvider.close(conn, stmt, res);
			
		} catch (Exception e) {
			System.out.println("목록 : " + e.getMessage());
		}
		
		return list;
	}
	
	// 등록
	public int insert(BookVO b) {
		int re = -1;
		String sql = "insert into book100 values(?,?,?,?)";
		
		try {
			Connection conn = ConnectionProvider.getConnetction();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setInt(3, b.getPrice());
			pstmt.setString(4, b.getPublisher());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("등록 : " + e.getMessage());
		}
		
		return re;
	}
	
	// 수정
	public int update(BookVO b) {
		int re = -1;
		String sql = "update book100 set bookname=?, price=?, publisher=? where bookid=?";
		
		try {
			Connection conn = ConnectionProvider.getConnetction();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookname());
			pstmt.setInt(2, b.getPrice());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getBookid());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("수정 : " + e.getMessage());
		}
		
		return re;
	}
	
	// 삭제
	public int delete(int bookid) {
		int re = -1;
		String sql = "delete from book100 where bookid=?";
		
		try {
			Connection conn = ConnectionProvider.getConnetction();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("삭제 : " + e.getMessage());
		}
		
		return re;
	}
	
	// 도서 상세보기
	// 도서번호를 매개변수로 전달받아 도서의 정보 반환
	public BookVO detail(int bookid) {
		BookVO g = new BookVO();
		String sql = "select * from book100 where bookid=?";
		
		try {
			Connection conn = ConnectionProvider.getConnetction();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			ResultSet res = pstmt.executeQuery();
			
			if (res.next()) {
				g.setBookid(res.getInt(1));
				g.setBookname(res.getString(2));
				g.setPrice(res.getInt(3));
				g.setPublisher(res.getString(4));
			}
			
			ConnectionProvider.close(conn, pstmt, res);
			
		} catch (Exception e) {
			System.out.println("조회 : " + e.getMessage());
		}
		
		return g;
	}
}
