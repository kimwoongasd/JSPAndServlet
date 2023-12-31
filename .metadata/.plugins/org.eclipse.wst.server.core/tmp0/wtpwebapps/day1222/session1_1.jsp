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
		request.setCharacterEncoding("UTF-8");
		String seasion = request.getParameter("seasion");
		String fruit = request.getParameter("fruit");
		
		// 세션에 저장된 값을 읽어와서 변수에 저장
		// object를 반환
		String id = (String)session.getAttribute("idKey");
		
		// 클라이언트가 연결하면 클라이언트를 구별하기 위한 논리전인 연결이 이루어지는디
		// 그것을 세션이라한다
		// 세션아이디가 할당이 되는 그 세션아이드를 읽어와서 변수에 저장
		String sessionId = session.getId();
		
		// 세션의 유효시간을 읽어와서 변수에 저장
		int intervalTime = session.getMaxInactiveInterval();
		
		if (id != null) {
		%>
			<h1>Session Exam1</h1>
			<b><%=id %></b>님이 좋아하는 계절과 과일은<br>
			<b><%=seasion %></b>와/과 <b><%=fruit %></b>입니다.<br>
			세션 ID : <%=sessionId %>
			세션 유지 시간 : <%=intervalTime %>
		<%
		} else {
			out.print("세션의 시간이 경과를 하였거나 다른 이유로 연결을 할 수 없습니다");
		}
	%>
</body>
</html>