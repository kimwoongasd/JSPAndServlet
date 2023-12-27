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
		//한글 데이터도 받아오도록 인코딩 설정
		request.setCharacterEncoding("UTF-8");
	
		/*
		사용자가 입력한 이름을 받아와서 변수에 저장
		html태그에서 사용자가 입력한 값을 받아오기 위하여 request하는 jsp 내장 객체의
		getParameter메소드를 이용
		이때 매개변수로 html태그의 이름을 쓴다
		getParameter메소드는 읽어온 데이터를 문자열으로 반환
		*/
		String name = request.getParameter("name");
		String studentNum = request.getParameter("studentNum");
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		
		if (gender.equals("man")) {
			gender = "남자";
		} else {
			gender = "여자";
		}
	%>
	
	<h1>Request Exam1</h1>
	성명 : <%=name %><br>
	학번 : <%=studentNum %><br>
	성별 : <%=gender %><br>
	전공 : <%=major %><br>
</body>
</html>