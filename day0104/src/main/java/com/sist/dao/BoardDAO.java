package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BoardVO;

public class BoardDAO {
	int pageSize = 10; // 한 화면에 보여줄 레코드의 수
	int totalRecord = 0; // 전체 레코드의 수
	public int totalPage = 0; // 전체 페이지의 수
	
	// 전체 레코드르 수를 반환하는 메소드
	public int getTotalRecord() {
		int cnt = 0;
		String sql = "select count(*) from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("레코드 수 구하기 " + e.getMessage());
		}
		
		return cnt;
	}
	
	// 이미 달려있는 답글들의 b_step을 1씩 증가하는 메소드
	public int updateStep(int b_ref, int b_step) {
		int re = -1;
		String sql = "update board set b_step = b_step + 1 "
				+ "where b_ref=? and b_step > ?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);	
		} catch (Exception e) {
			System.out.println("step update 에러 " + e.getMessage());
		}
		
		return re;
	}
	
	
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
						res.getString(9),
						res.getInt(10),
						res.getInt(11),
						res.getInt(12)
						);
			}
			
			ConnectionProvider.close(conn, pstmt, res);
		} catch (Exception e) {
			System.out.println("detail " + e.getMessage());
		}
		
		
		return b;
	}
	
	public int insert(BoardVO b) {
		String sql = "insert into board values(?, ?, ?, ?, ?, sysdate, 1, ?, ?, ?, ?, ?)";
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
			pstmt.setInt(8, b.getB_ref());
			pstmt.setInt(9, b.getB_level());
			pstmt.setInt(10, b.getB_step());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("추가 " + e.getMessage());
		}
		
		return re;
	}
	
	
	public ArrayList<BoardVO> listBoard(int pageNUM) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		totalRecord = getTotalRecord();
		totalPage = totalRecord / pageSize  +1 ;
		
		int start = (pageNUM - 1) * 10 + 1;
		int end = (pageNUM * 10);
		
		String sql = "select * "
				+ "from "
				+ "(select b.*, rownum rm "
				+ "from (select * "
				+ "from board order by b_ref desc, b_step) b) "
				+ "where rm between "+start+" and "+end+"";

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
						res.getString(9),
						res.getInt(10),
						res.getInt(11),
						res.getInt(12)
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
