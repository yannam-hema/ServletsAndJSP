<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="RegistrationSuccess.css">
</head>
<body>
<%
Random random = new Random();
int min = 630;
int max = 760;
int cibil = random.nextInt((max - min) + 1) + min;
out.println("<h1 id='heading'>Your CIBIL Score : " + cibil + "</h1>");
%>
</body>
</html>