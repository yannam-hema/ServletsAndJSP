import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Multiplication")
public class Multiplication extends HttpServlet {
private static final long serialVersionUID = 1L;
private HttpSession session;
private PrintWriter writer;
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
int num1=Integer.parseInt(req.getParameter("num1"));
int num2=Integer.parseInt(req.getParameter("num2"));
int prod=num1*num2;
session = req.getSession();
int sum= (int)session.getAttribute("sum");
writer = res.getWriter();
writer.println("the sum ="+sum);
writer.println("the prod="+prod);
session.invalidate();

}
}
