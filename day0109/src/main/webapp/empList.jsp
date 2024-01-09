<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#j_list, #d_list{
		display: none;
	}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#cname").change(function(){
			var v = $(this).val();
			
			if (v == "job") {
				$("#search").css("display", "none");
				$("#search").attr("name", null);
				$("#j_list").css("display", "inline-block");
				$("#j_list").attr("name", "keyword");
				$("#d_list").css("display", "none");
				$("#d_list").attr("name", null);
				
			} else if (v == "dno") {
				$("#search").css("display", "none");
				$("#search").attr("name", null);
				$("#j_list").css("display", "none");
				$("#j_list").attr("name", null);
				$("#d_list").css("display", "inline-block");
				$("#d_list").attr("name", "keyword");
				
				
			} else {
				$("#search").css("display", "inline-block");
				$("#search").attr("name", "keyword");
				$("#j_list").css("display", "none");
				$("#j_list").attr("name", null);
				$("#d_list").css("display", "none");
				$("#d_list").attr("name", null);
			}
		});
		
		$.ajax({
			url:"jobList.do",
			success: function(data){
				$.each(data, function(){
					var option = $("<option></option>").html(this);
					$(option).attr("value", this);
					$("#j_list").append(option);
				})
			}
		});
		
		$.ajax({
			url:"listDno.do",
			success: function(data){
				$.each(data, function(){
					var option = $("<option></option>").html(this);
					$(option).attr("value", this);
					$("#d_list").append(option);
				})
			}
		})
	})
</script>
</head>
<body>
<h2>사원목록</h2>
<hr>
<form method="post" action="empList.do">
	<select id="cname" name="cname">
		<option value="jumin">생년월일</option>
		<option value="email">이메일</option>
		<option value="job" id="job" name="job">직책</option>
		<option value="dno" id="job" name="dno">부서</option>
	</select>
	<input type="search" name="keyw
	ord" id="search">
	<select id="j_list">
	</select>
	<select id="d_list">
	</select>
	<input type="submit" value="검색"> 
</form>
<table border="3">
	<tr>
		<td>사원번호</td>
		<td>사원이름</td>
		<td>직책</td>
		<td>입사일</td>
		<td>급여</td>
		<td>부서번호</td>
		<td>주민번호</td>
		<td>이메일번호</td>
	</tr>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.eno }</td>
			<td>${e.ename }</td>
			<td>${e.job }</td>
			<td>${e.hiredate }</td>
			<td>${e.salary }</td>
			<td>${e.dno }</td>
			<td>${e.jumin }</td>
			<td>${e.email }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>