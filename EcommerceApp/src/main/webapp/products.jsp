<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>Products - ${requestScope.category}</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <main>
    <h2>Category: ${requestScope.category}</h2>
    <div class="category-container">
      <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null) {
          for (Product p : products) {
      %>
        <div class="category">
          <h3><%= p.getName() %></h3>
          <p><strong>Price:</strong> <%= p.getPrice() %></p>
          <p><%= p.getDescription() %></p>
          <form action="CartServlet" method="post">
            <input type="hidden" name="id" value="<%= p.getId() %>">
            <input type="hidden" name="name" value="<%= p.getName() %>">
            <input type="hidden" name="price" value="<%= p.getPrice() %>">
            <input type="hidden" name="description" value="<%= p.getDescription() %>">
            <input type="hidden" name="category" value="<%= p.getCategory() %>">
            <button type="submit">Add to Cart</button>
          </form>
        </div>
      <%
          }
        }
      %>
    </div>
    <p><a href="categories.jsp" class="btn">Back to Categories</a></p>
  </main>
  <%@ include file="footer.jsp" %>
</body>
</html>
