package controller;

import entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        HttpSession session = req.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description") == null ? "" : req.getParameter("description");
        String category = req.getParameter("category") == null ? "" : req.getParameter("category");

        cart.add(new Product(id, name, price, description, category));
        session.setAttribute("cart", cart);

        resp.sendRedirect(req.getContextPath() + "/CartServlet");
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
        throws ServletException, IOException {
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }
}
