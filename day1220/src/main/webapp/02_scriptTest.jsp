<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
   String title = "쌍용강북교육센터";
   int age = 20;
   /*
   if(age == 20){
      title = "OK";
   }
   if는 여기 못 옴. 메소드는 올 수 있음
   */
   public int addData(int data){
      return data +1;
   }
   
%>

<%
   String result = "hello";
   int year = 2023;
   if(year == 2023){
      result = "hello 2023";
   }
%>

result : <%= result %> <br>
year : <%= year %> <br>
title : <%= title %> <br>
age : <%= age %> <br>
<hr>
addData
<%= addData(age) %> <br>
<%= addData(year) %> <br>
</body>
</html>