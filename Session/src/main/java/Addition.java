import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Addition")
public class Addition extends HttpServlet {
private static final long serialVersionUID = 1L;
private HttpSession session;
private RequestDispatcher rd;

@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int num1=Integer.parseInt(req.getParameter("num1"));
	int num2=Integer.parseInt(req.getParameter("num2"));
	int sum=num1+num2;
	session = req.getSession(true);
	session.setAttribute("sum", sum);
	rd = req.getRequestDispatcher("/Multiplication");
	rd.forward(req, res);
	
}
}
