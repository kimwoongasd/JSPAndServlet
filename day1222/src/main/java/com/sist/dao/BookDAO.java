package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##som";
	String password = "1234";
	
	public ArrayList<BookVO> listBook(){
		String sql = "select * from book order by bookid";
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Statement stmt = conn.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				int bookid = res.getInt(1);
				String bookname = res.getString(2);
				int price = res.getInt(3);
				String publisher = res.getString(4);
				
				list.add(new BookVO(bookid, bookname, price, publisher));
			}
			
			res.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("책 리스트 오류 : " + e.getMessage());
		}
		
		return list;
	}
	
//	public int insertBook(int bookid, String bookname, int price, String publisher) {
//		int re = -1;
//		String sql = "insert into book values("+
//				bookid + ",'" +
//				bookname + "'," +
//				price  + ",'" +
//				publisher
//				+"')";
//		
//		try {
//			Class.forName(driver);
//			Connection conn = DriverManager.getConnection(url, username, password);
//			Statement stmt = conn.createStatement();
//			
//			re = stmt.executeUpdate(sql);
//			
//			stmt.close();
//			conn.close();
//			
//		} catch (Exception e) {
//			System.out.println("책 insert 오류 " + e.getMessage());
//		}
//		
//		return re;
//	}
	
	
	public int insertBook(BookVO b) {
		int re = -1;
		String sql = "insert into book values(?, ?, ?, ?)";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b.getBookid());
			pstmt.setString(2, b.getBookname());
			pstmt.setInt(3, b.getPrice());
			pstmt.setString(4, b.getPublisher());
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("책 insert 오류 " + e.getMessage());
		}
		
		return re;
	}
	
	public int updateBook(int bookid, String bookname, int price, String publisher) {
		int re = -1;
		
		String sql = "update book set bookname='"+bookname
				+"', price="+price
				+", publisher='"+publisher+"' "
						+ "where bookid = "+bookid+"";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			
			re = stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("책수정 오류 " + e.getMessage());
		}
		
		return re;
	}
	
	public int updateBook(BookVO b) {
		int re = -1;
		String sql = "update book set bookname=?, price=?, publisher=? where bookid=?";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBookname());
			pstmt.setInt(2, b.getPrice());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getBookid());
			
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return re;
	}
	
	
	public int deleteBook(BookVO b) {
		int re = -1;
		String sql = "delete from book where bookid = ?";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b.getBookid());
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("책 삭제 오류 " + e.getMessage());
		}
		
		return re;
	}
}
