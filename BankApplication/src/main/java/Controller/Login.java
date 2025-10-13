package Controller;

import java.io.IOException;
import java.io.Writer;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private HttpSession session;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("mail");
		String password = req.getParameter("pwd");
		session=req.getSession(true);
		Model m = new Model();
		m.setEmail(email);
		m.setPassword(password);
		
		boolean b =m.userLogin();
		if (b == true) {
			session.setAttribute("accno",m.getAccno());
			
		    resp.sendRedirect(req.getContextPath()+"/Home.html");
		} else {
		    resp.sendRedirect(req.getContextPath()+"/LoginFail.html");
		}

}
}