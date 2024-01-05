<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#header{
		width: 100%;
		height: 5%;
		background-color: pink;
		padding-top: 10px;
		padding-left: 10px;
	}
	
	#footer{
		text-align:center;
		width: 100%;
		height: 10%;
		background-color: pink;
		padding-top: 10px;
	}
	
	#content{
		width: 100%;
		height: 85%;
		overflow: scroll;
		padding: 15px;
	}
	
	#wrap{
		width: 100%;
		height: 1000px;
	}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<jsp:include page="header.jsp"/>
		</div>
		
		<div id="content">
			<jsp:include page="${viewPage }"/>
		</div>
		
		<div id="footer">
			<jsp:include page="footer.jsp"/>
		</div>
	</div>
</body>
</html>