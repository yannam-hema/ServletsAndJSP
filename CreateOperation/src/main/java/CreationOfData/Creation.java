package CreationOfData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Creation")
public class Creation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        int age = Integer.parseInt(req.getParameter("age"));
        int salary = Integer.parseInt(req.getParameter("salary"));
        String company = req.getParameter("Company");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "Yannam@300323");

            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO employeetable (id, name, phone, age, salary, company) VALUES (?, ?, ?, ?, ?, ?)");

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setInt(4, age);
            pstmt.setInt(5, salary);
            pstmt.setString(6, company);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                writer.println("<h3>✅ Employee added successfully!</h3>");
            } else {
                writer.println("<h3>⚠️ Failed to add employee.</h3>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            writer.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

  
}
