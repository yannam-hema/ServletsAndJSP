package Controller;

import java.io.IOException;

import Model.HibernateManager;
import Utils.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("pwd");
	UserDetails ud = new UserDetails();
	ud.setEmail(email);
	ud.setPassword(password);
	HibernateManager hbm = new HibernateManager();
	boolean b = hbm.readData(ud);
	if(b) {
		resp.sendRedirect(req.getContextPath() +"/FetchSuccess.html");
	}
	else {
		resp.sendRedirect(req.getContextPath() +"/FetchFail.html");
	}
}
}
