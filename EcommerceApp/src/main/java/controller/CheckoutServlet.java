package controller;

import model.OrderDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import entity.Product;

@WebServlet(name="CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession();
        Object uid = session.getAttribute("userId");
        if (uid == null) {
            req.setAttribute("message", "Please register/login before placing an order.");
            req.getRequestDispatcher("checkout.jsp").forward(req, resp);
            return;
        }
        int customerId = (int) uid;

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        int total = 0;
        if (cart != null) {
            for (Product p : cart) {
                String digits = p.getPrice().replaceAll("[^0-9]", "");
                if (!digits.isEmpty()) total += Integer.parseInt(digits);
            }
        }

        boolean saved = OrderDAO.saveOrder(customerId, total);

        if (saved) {
            session.removeAttribute("cart");
            req.setAttribute("message", "Order placed successfully! Total: ₹" + total);
        } else {
            req.setAttribute("message", "Order failed. Try again.");
        }

        req.getRequestDispatcher("checkout.jsp").forward(req, resp);
    }
}
