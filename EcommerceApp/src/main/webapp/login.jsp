<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - EcommerceApp</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <%@ include file="header.jsp" %>

    <main class="main-content">
        <div class="form-card">
            <h2>Customer Login</h2>
            <form action="LoginServlet" method="post" class="form-container">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required placeholder="Enter your registered email">

                <input type="submit" value="Login" class="btn primary-btn">
            </form>

            <p class="error">${requestScope.error}</p>
            <p class="text-center mt-20">
                New customer? 
                <a href="register.jsp" class="btn secondary-btn" style="margin-top: 10px;">Register Here</a>
            </p>
            <p class="text-center">
                <a href="index.jsp" class="btn secondary-btn">Back to Home</a>
            </p>
        </div>
    </main>

    <%@ include file="footer.jsp" %>
</body>
</html>