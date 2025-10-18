package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Customer;
import model.CustomerDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String email = request.getParameter("email");

        // Basic validation
        if (email == null || email.trim().isEmpty()) {
            request.setAttribute("error", "Email is required!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Find customer by email
        Customer customer = CustomerDAO.getCustomerByEmail(email);
        
        if (customer != null) {
            // Set session attributes
            HttpSession session = request.getSession();
            session.setAttribute("customerId", customer.getCustomerId());
            session.setAttribute("userName", customer.getName());
            session.setAttribute("email", customer.getEmail());
            
            // Redirect to categories page
            response.sendRedirect("categories.jsp");
        } else {
            request.setAttribute("error", "Email not found! Please register first.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}