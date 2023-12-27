<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Context context = new InitialContext();
	
		DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
		
		Connection conn = ds.getConnection();
		
		String sql = "select * from goods";
		
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		
	%>
	
	<h2>상품목록</h2>
	<hr>
	<table width="60%" border="1">
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
		</tr>
		<%
			while(res.next()) {
				%>
					<tr>
						<td><%=res.getInt(1) %></td>
						<td><%=res.getString(2) %></td>
					</tr>
				<%
			}
		
		res.close();
		stmt.close();
		conn.close();
		%>
	</table>
</body>
</html>