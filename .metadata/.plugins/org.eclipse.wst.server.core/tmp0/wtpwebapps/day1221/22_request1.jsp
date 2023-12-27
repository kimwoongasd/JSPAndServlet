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
		// 프로토콜(통신규약)을 읽어온다
		String protocol = request.getProtocol();
		// 서버의 이름을 읽어온다
		String serverNmae = request.getServerName();
		// 포트번호를 읽어온다
		int serverPort = request.getServerPort();
		// 요청한 클라이언트의 ip주소를 가져온다
		String remoteAddr = request.getRemoteAddr();
		// 서버 컴퓨터의 이름을 읽어온다
		String remoteHost = request.getRemoteHost();
		// 서비스 요청방식을 읽어온다
		String method = request.getMethod();
		// 클라이언트가 웹브라우저에 입력한 주소표시줄의 내용을 HTTP부터 모두 읽어온다
		StringBuffer requestURL = request.getRequestURL();
		// 클라이언트가 웹브라우저의 입력한 주소표시줄의 내용중에 컨텍스트명부터 읽어온다
		String requestURI = request.getRequestURI();
		// 클라이언트의 접속한 웹브라우저의 정보를 읽어온다
		String userBrowser = request.getHeader("User-Agent");
		// 클라이언트가 접속한 웹브라우저가 지원가능한 파일타입을 모두 읽어온다
		String fileType = request.getHeader("Accept");
	%>
	
	<h1>Request Exam2</h1>
	프로토콜 : <%=protocol %><br>
	서버의 이름 : <%=serverNmae %><br>
	서버의 포트 번호 : <%=serverPort %><br>
	사용자의 컴퓨터의 주소 : <%=remoteAddr %><br>
	사용자 컴퓨터의 이름 : <%=remoteHost %><br>
	요청 방식 : <%=method %><br>
	요청 경로(URL) : <%=requestURL %><br>
	요청 경로(URI) : <%=requestURI %><br>
	요청한 클라이언트의 브라우저 : <%=userBrowser %><br>
	브라우저가 지원하는 파일 형식 : <%=fileType %><br>
</body>
</html>