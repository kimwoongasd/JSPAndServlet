package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvier;
import com.sist.vo.EmpVO;

public class EmpDAO {
	public static EmpDAO dao;
	private EmpDAO() {}
	
	public static EmpDAO getInstance() {
		if (dao == null) {
			dao = new EmpDAO();
		}
		
		return dao;
	}
	
	
	public ArrayList<String> getDnoList() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct dno from emp";
		
		try {
			Connection conn = ConnectionProvier.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
			ConnectionProvier.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public ArrayList<String> getJobList() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct job from emp";
		
		try {
			Connection conn = ConnectionProvier.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
			ConnectionProvier.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	public ArrayList<EmpVO> findAll(String keyword, String cname, String j_list) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "select eno, ename, job, hiredate, salary, dno, mgr, comm, rpad(substr(jumin, 1, 7), 14, '*'), email from emp";
		if(keyword != null && !keyword.equals("")) {
			if (cname.equals("job")) {
				sql += " where job = '"+keyword+"'";
			} else {
				sql += " where "+cname+" like '%"+keyword+"%'";
			}
		}

		try {
			Connection conn = ConnectionProvier.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				list.add(new EmpVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getString(10)
						));
			}
			
			
			ConnectionProvier.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("목록 " + e.getMessage());
		}
		
		return list;
	}
}
