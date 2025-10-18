<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>EcommerceApp - Home</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <main>
    <h2>Welcome to EcommerceApp</h2>
    <div class="category-container">
      <div class="category">
        <a href="register.jsp">
          <h3>Register / Start Shopping</h3>
        </a>
      </div>
      <div class="category">
        <a href="categories.jsp">
          <h3>Browse Categories</h3>
        </a>
      </div>
    </div>
  </main>

</body>
</html>
