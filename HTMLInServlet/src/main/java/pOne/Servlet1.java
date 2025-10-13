package pOne;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.setContentType("text/html");
   PrintWriter writer = resp.getWriter();
   writer.print("<html>");
   writer.print("<html>");
   writer.print("<head>");
   writer.print("<title>HTML in Servlet");
   writer.print("</title>");
   writer.print("</head>");
   writer.print("<body>");
   writer.print("<h1> hello from Servlet File");
   writer.print("</h2> </body> </html>");
}
}
