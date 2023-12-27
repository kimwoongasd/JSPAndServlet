<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Date date = new Date();
%>
include bottom부분입니다<br>
<%=date.toLocaleString() %>
</body>
</html>