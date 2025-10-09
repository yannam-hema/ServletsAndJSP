package Controller;

import java.io.IOException;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("mail");
		String password = req.getParameter("pwd");
		
		Model m = new Model();
		m.setEmail(email);
		m.setPassword(password);
		
		boolean b =m.userLogin();
		if (b == true) {
		    resp.sendRedirect(req.getContextPath()+"/Home.html");
		} else {
		    resp.sendRedirect(req.getContextPath()+"/LoginFail.html");
		}

}
}