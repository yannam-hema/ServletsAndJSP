<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>Register - EcommerceApp</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <%@ include file="header.jsp" %>

  <main class="main-content">
    <div class="form-card">
      <h2>Customer Registration</h2>
      <form action="RegisterServlet" method="post" class="form-container">
        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Contact:</label>
        <input type="text" name="contact" required>

        <input type="submit" value="Start Shopping" class="btn primary-btn">
      </form>

      <p class="error">${requestScope.error}</p>
      <p><a href="index.jsp" class="btn secondary-btn">Home</a></p>
    </div>
  </main>

  <%@ include file="footer.jsp" %>
</body>
</html>
