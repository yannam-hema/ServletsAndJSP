<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Categories - EcommerceApp</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <!-- Header -->
    <header>

        <h1>EcommerceApp</h1>
        <nav>
            <a class="btn" href="categories.jsp">Categories</a>
            <a class="btn" href="CartServlet">Cart</a>
            <a class="btn" href="LogoutServlet">Logout</a>
        </nav>
    </header>

    <!-- Main Section -->
    <main>
        <h2>Welcome, ${sessionScope.userName} 👋</h2>
        <p class="welcome-message">Select a category to explore:</p>

        <!-- Category Cards -->
        <div class="product-container">
            <div class="product-card">
                <a href="CategoryServlet?category=Electronics" class="btn">Electronics</a>
                <p>Latest gadgets and smart devices.</p>
            </div>

            <div class="product-card">
                <a href="CategoryServlet?category=Furniture" class="btn">Furniture</a>
                <p>Modern and comfortable furniture.</p>
            </div>

            <div class="product-card">
                <a href="CategoryServlet?category=Clothing" class="btn">Clothing</a>
                <p>Trendy fashion for everyone.</p>
            </div>

            <div class="product-card">
                <a href="CategoryServlet?category=Grocery" class="btn">Grocery</a>
                <p>Everyday essentials at great prices.</p>
            </div>

            <div class="product-card">
                <a href="CategoryServlet?category=Books" class="btn">Books</a>
                <p>Discover stories and knowledge.</p>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer>
        <p>© 2025 EcommerceApp — Made with 💛 and ☕</p>
    </footer>
</body>
</body>
</html>
