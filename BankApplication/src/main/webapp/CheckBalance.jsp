<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Balance</title>
<link rel="stylesheet" href="RegistrationSuccess.css">
</head>
<body>
<h1 id="heading">Balance fetched Successfully</h1>
<h2 id="heading"><%
out.println(session.getAttribute("balance"));
%></h2>
</body>
</html>