package Controller;

import java.io.IOException;

import Model.HibernateManager;
import Utils.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class Register extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("username");
	String password=req.getParameter("password");
	String email=req.getParameter("email");
	UserDetails ud = new UserDetails();
	ud.setUsername(name);
	ud.setEmail(email);
	ud.setPassword(password);
	HibernateManager hbm = new HibernateManager();
	boolean b = hbm.insertData(ud);
	if(b) {
	resp.sendRedirect(req.getContextPath() +"/RegisterSuccess.html");	
	}
	else {
		resp.sendRedirect(req.getContextPath() +"/RegisterFail.html");
	}
}
}
