package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Details")
public class Details extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Yannam@300323");
            System.out.println("Driver loaded and connected");

            String sql = "SELECT * FROM employeetable WHERE name = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            res = pstmt.executeQuery();

            boolean found = false;
            writer.println("<h2>Employee Details</h2>");
            while (res.next()) {
                found = true;
                writer.println("<p>ID: " + res.getInt("id") + "</p>");
                writer.println("<p>Name: " + res.getString("name") + "</p>");
                writer.println("<p>Phone: " + res.getString("Phone") + "</p>");
                writer.println("<p>Age: " + res.getString("age") + "</p>");
                writer.println("<p>Salary: " + res.getInt("salary") + "</p>");
                writer.println("<p>Company: " + res.getString("company") + "</p>");
                writer.println("<hr>");
            }

            if (!found) {
                writer.println("<p>No employee found with name: " + name + "</p>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            writer.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            try {
                if (res != null) res.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
