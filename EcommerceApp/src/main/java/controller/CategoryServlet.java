package controller;

import entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CategoryServlet", urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends jakarta.servlet.http.HttpServlet {
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
        throws ServletException, IOException {

        String category = req.getParameter("category");
        if (category == null) category = "Electronics";

        List<Product> products = new ArrayList<>();

        // Hardcoded sample products (5 per category)
        switch (category) {
            case "Electronics":
                products.add(new Product(1, "iPhone 14", "Rs 80000", "Latest Apple smartphone", "Electronics"));
                products.add(new Product(2, "Samsung Galaxy S23", "Rs 70000", "Samsung flagship", "Electronics"));
                products.add(new Product(3, "OnePlus 11", "Rs 60000", "Smooth performance phone", "Electronics"));
                products.add(new Product(4, "Wireless Earbuds", "Rs 14900", "Noise cancelling", "Electronics"));
                products.add(new Product(5, "Smartwatch", "Rs 19900", "Heart-rate monitor", "Electronics"));
                break;
            case "Furniture":
                products.add(new Product(11, "Leather Sofa", "Rs 30000", "3 Seater leather sofa", "Furniture"));
                products.add(new Product(12, "Dining Table", "Rs 20000", "6 Seater dining table", "Furniture"));
                products.add(new Product(13, "Office Chair", "Rs 7000", "Ergonomic chair", "Furniture"));
                products.add(new Product(14, "Single Bed", "Rs 10000", "Wooden single bed", "Furniture"));
                products.add(new Product(15, "Coffee Table", "Rs 5000", "Small wooden table", "Furniture"));
                break;
            case "Clothing":
                products.add(new Product(21, "Saree", "Rs 2000", "Traditional Indian saree", "Clothing"));
                products.add(new Product(22, "Kurti", "Rs 800", "Cotton Kurti", "Clothing"));
                products.add(new Product(23, "Jeans", "Rs 1500", "Blue denim jeans", "Clothing"));
                products.add(new Product(24, "T-Shirt", "Rs 800", "Casual t-shirt", "Clothing"));
                products.add(new Product(25, "Dress", "Rs 2500", "Party wear dress", "Clothing"));
                break;
            case "Grocery":
                products.add(new Product(31, "Apple", "Rs 200", "Fresh apples", "Grocery"));
                products.add(new Product(32, "Banana", "Rs 50", "Yellow bananas", "Grocery"));
                products.add(new Product(33, "Milk", "Rs 50", "1 litre packet", "Grocery"));
                products.add(new Product(34, "Rice", "Rs 100", "Basmati rice", "Grocery"));
                products.add(new Product(35, "Chips", "Rs 20", "Potato chips", "Grocery"));
                break;
            default:
                // default to electronics
                products.add(new Product(1, "iPhone 14", "Rs 80000", "Latest Apple smartphone", "Electronics"));
                products.add(new Product(2, "Samsung Galaxy S23", "Rs 70000", "Samsung flagship", "Electronics"));
                products.add(new Product(3, "OnePlus 11", "Rs 60000", "Smooth performance phone", "Electronics"));
                products.add(new Product(4, "Wireless Earbuds", "Rs 14900", "Noise cancelling", "Electronics"));
                products.add(new Product(5, "Smartwatch", "Rs 19900", "Heart-rate monitor", "Electronics"));
        }

        req.setAttribute("products", products);
        req.setAttribute("category", category);
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }
}
