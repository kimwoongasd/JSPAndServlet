package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##som";
	String password = "1234";
	
	int pageSize = 5; // 한 화면에 보여줄 레코드의 수
	int totalRecord;  // 전체 레코드의 
	int totalPage;	// 전체 페이지의 수
	
	public int getTotalPage() {
		totalRecord = getTotalRecord();
		// Math.ceil 올림
		totalPage = (int)Math.ceil(totalRecord / (double)pageSize);
		
		return totalPage;
	}
	
	// 전체 레코드수를 반환하는 메소드를 완성
	public int getTotalRecord() {
		int cnt = 0;
		
		String sql = "select count(*) from goods";
		
		try {
			Class.forName(driver);
			Connection conn 
			= DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return cnt;
	}
	
	public ArrayList<GoodsVO> listGoods(int pageNum){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		getTotalPage();
		
		int start; // 현제페이지에 따른 시작 레코드의 위치
		int end;	// 현제페이지에 따른 마지막 레코드의 위치
		
		// 현제페이지에 따른 시작레코드의 위치와 마지막 레코드의 위치를 계산
		start = 1 + (pageNum-1) * pageSize;
		end = (pageNum-1) * pageSize + 5;
		
		
		try {
			Class.forName(driver);
			Connection conn 
			= DriverManager.getConnection(url, username, password);
			String sql = "select * "
					+ "from (select rownum as rn, goods.* from goods) a "
					+ "where a.rn between ? and ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO g = new GoodsVO();
				g.setNo(rs.getInt(2));
				g.setName(rs.getString(3));
				g.setPrice(rs.getInt(4));
				g.setQty(rs.getInt(5));
				g.setFname(rs.getString(6));
				list.add(g);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}