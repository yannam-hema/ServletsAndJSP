package controller;

import model.CustomerDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name="RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends jakarta.servlet.http.HttpServlet {
    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
        throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");

        int id = CustomerDAO.saveCustomer(name, email, contact);

        if (id > 0) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", id);
            session.setAttribute("userName", name);
            resp.sendRedirect(req.getContextPath() + "/categories.jsp");
        } else {
            req.setAttribute("error", "Registration failed. Try again.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
        throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/register.jsp");
    }
}
