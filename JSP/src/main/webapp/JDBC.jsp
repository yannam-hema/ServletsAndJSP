<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
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
String sql="select * from bankapp where accno=?";
%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/serv_project1","root","Yannam@300323");
PreparedStatement ps = con.prepareStatement(sql);
ps.setInt(1,Integer.parseInt(request.getParameter("accno")));
ResultSet rs =ps.executeQuery();
while(rs.next()){
	out.println("<h1>"+rs.getString("uname"));
}
%>
</body>
</html>