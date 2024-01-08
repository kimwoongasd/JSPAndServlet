package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import com.sist.db.ConnectionProvier;
import com.sist.vo.BookVO;

public class BookDAO {
	// 싱글톤 패턴
	public static BookDAO dao = null;
	
	private BookDAO() {
		
	}
	
	public static BookDAO getInstance() {
		if (dao == null) {
			dao = new BookDAO();
		}
		return dao;
	}
	
	public HashSet<String> listPublisher() {
		HashSet<String> set = new HashSet<String>();
		String sql = "select publisher from book";
		// distinct 중복 제거 ==> ArrayList로 바꿀 수 있음
//		String sql = "select distinct publisher from book";
		
		try {
			Connection conn = ConnectionProvier.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				set.add(rs.getString(1));
			}
			
		} catch (Exception e) {
			System.out.println("출판사 목록 " + e.getMessage());
		}		
		return set;
		
	}
	
	public ArrayList<BookVO> findAll(String cname, String search, String op, String order) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";	
		
		if (search != null) {
			if (cname.equals("price")) {
				sql += " where "+cname+" "+op+" "+search+"";
			} else {
				sql += " where "+cname+" like '%"+search+"%'";
			}
		}
		
		if (order != null) {
			sql += " order by "+order;
		}
		
		try {
			Connection conn = ConnectionProvier.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				list.add(new BookVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4)
						));
			}
		} catch (Exception e) {
			System.out.println("book 목록 " + e.getMessage());
		}
		
		return list;
	}
}
