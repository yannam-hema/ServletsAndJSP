<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Balance</title>
</head>
<body>
<h3>Balance fetched Successfully</h3>
<h3><%
out.println(session.getAttribute("balance"));
%></h3>
</body>
</html>