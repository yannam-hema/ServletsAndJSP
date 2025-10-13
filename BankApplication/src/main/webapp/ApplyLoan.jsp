<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random Loan Amount</title>
<link rel="stylesheet" href="RegistrationSuccess.css">
</head>
<body>
<%
Random random = new Random();
int min = 50000;
int max = 500000;
int LoanAmount = random.nextInt((max - min) + 1) + min;
out.println("<h1 id='heading'>You are Eligible for: ₹ " + LoanAmount + " Loan</h1>");
%>
</body>
</html>
