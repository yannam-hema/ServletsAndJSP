<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>Checkout - EcommerceApp</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <main>
    <h2>Checkout</h2>
    <p style="color:green;">${requestScope.message}</p>
    <a href="categories.jsp" class="btn">Continue Shopping</a>
  </main>
  <%@ include file="footer.jsp" %>
</body>
</html>
