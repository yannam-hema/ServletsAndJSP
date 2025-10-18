<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>Your Cart - EcommerceApp</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <%@ include file="header.jsp" %>
  <main>
    <h2>Your Cart</h2>
    <%
      List<Product> cart = (List<Product>) session.getAttribute("cart");
      if (cart == null || cart.isEmpty()) {
    %>
      <p>Your cart is empty.</p>
    <%
      } else {
    %>
      <table class="styled-table">
        <tr><th>Name</th><th>Price</th></tr>
        <%
          int total = 0;
          for (Product p : cart) {
            String digits = p.getPrice().replaceAll("[^0-9]", "");
            if (!digits.isEmpty()) total += Integer.parseInt(digits);
        %>
          <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
          </tr>
        <% } %>
      </table>
      <h3>Total: ₹<%= total %></h3>
      <form action="CheckoutServlet" method="post">
        <button type="submit">Place Order</button>
      </form>
    <% } %>
    <p><a href="categories.jsp" class="btn">Continue Shopping</a></p>
  </main>
  <%@ include file="footer.jsp" %>
</body>
</html>
