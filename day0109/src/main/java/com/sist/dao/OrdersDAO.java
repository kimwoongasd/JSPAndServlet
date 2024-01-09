package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvier;

public class OrdersDAO {
	public static OrdersDAO dao;
	private OrdersDAO() {};
	
	public static OrdersDAO getInstance() {
		if (dao == null) {
			dao = new OrdersDAO();
		}
		
		return dao;
	}
	
	public ArrayList<HashMap<String, Object>> listOrders() {
		String sql = "select c.custid, name, bookname "
				+ "from customer c, orders o, book b "
				+ "where c.custid = o.custid and b.bookid = o.bookid";
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		try {
			Connection conn = ConnectionProvier.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("custid", rs.getInt(1));
				map.put("name", rs.getString(2));
				map.put("bookname", rs.getString(3));
				list.add(map);
			}
			
			ConnectionProvier.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
