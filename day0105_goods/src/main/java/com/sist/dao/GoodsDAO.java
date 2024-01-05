package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.db.ConnectionProvider;
import com.sist.vo.GoodsVO;

public class GoodsDAO {
	int totalRecord = 0;
	int paging = 3;
	public static int totalPage = 0;
	
	public int getTotalRecord(String search) {
		String sql = "select count(*) from goods";
		
		if (search != null) {
			sql += " where name like '%"+search+"%'";
		}
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalRecord = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("토탈 레코드 : " + e.getMessage());
		}
		
		return totalRecord;
	}
	
	// connection pool로 등록을 했기때문에 따로 driver설정 x
	public int updateGoods(GoodsVO g) {
	      int re = -1;
	      String sql = "update goods set name=?, price=?, qty=?, fname=?  where no=?";
	      try {
	         Context context = new InitialContext();
	         DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
	         Connection conn = ds.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(5,g.getNo());
	         pstmt.setString(1, g.getName());
	         pstmt.setInt(2,g.getPrice());
	         pstmt.setInt(3,g.getQty());
	         pstmt.setString(4, g.getFname());
	         re = pstmt.executeUpdate();
	         
	         pstmt.close();
	         conn.close();
	      } catch (Exception e) {
	         System.out.println("예외발생 : "+e.getMessage());
	      }
	      return re;
	   }
	
	public int deleteGoods(int no) {
		int re = -1;
		String sql = "delete from goods where no = ?";
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("삭제 : " + e.getMessage());
		}
		return re;
	}
	
	public GoodsVO findByNo(int no) {
		GoodsVO g = null;
		String sql = "select * from goods where no=?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				g = new GoodsVO(
						res.getInt(1),
						res.getString(2),
						res.getInt(3),
						res.getInt(4),
						res.getString(5)
						);
			}
			
			res.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("findByNo 에러 : " + e.getMessage());
		}
		
		return g;
	}
	
	public int insertGoods(GoodsVO g) {
		int re = -1;
		String sql = "insert into goods values(?, ?, ?, ?, ?)";
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("insert 에러 : " + e.getMessage());
		}
		
		return re;
	}
	
	public ArrayList<GoodsVO> findAll(int pageNum, String search){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		totalRecord = getTotalRecord(search);
		
		totalPage = totalRecord / paging + 1;
		
		if (totalRecord % paging == 0) {
			totalPage = totalRecord / paging;
		}
		

		int start = (pageNum-1) * 3 + 1;
		int end = pageNum * 3;
		
		String sql = "select g.* "
				+ "from "
				+ "(select a.*, rownum rm "
				+ "from "
				+ "(select * from goods ";
		
		if (search != null) {
			sql += " where name like '%"+search+"%'";
		}
		
		sql += "order by no desc) a) g "
				+ "where g.rm between "+start+" and "+end+"";
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				list.add(new GoodsVO(
						res.getInt(1),
						res.getString(2),
						res.getInt(3),
						res.getInt(4),
						res.getString(5)
						));
			}
			
			res.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("goods 목록 에러 : " + e.getMessage());
		}
		
		return list;
	}
}
