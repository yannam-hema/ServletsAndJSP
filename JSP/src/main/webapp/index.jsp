<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
<%! 
String str="hema";
Set<Integer> st = new HashSet<>();
%>
<%
st.add(34);
st.add(89);
out.println("The string is : "+str +"<br>");
out.println(st);
%>
</h2>
</body>
</html>