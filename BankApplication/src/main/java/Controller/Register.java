package Controller;

import java.io.IOException;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uname = req.getParameter("uname");
	String email = req.getParameter("mail");
	int accno= Integer.parseInt(req.getParameter("accno"));
	long phone = Long.parseLong(req.getParameter("phone"));
	int balance = Integer.parseInt(req.getParameter("bal"));
	String password = req.getParameter("pwd");
	Model m = new Model();
	m.setName(uname);
	m.setEmail(email);
	m.setAccno(accno);
	m.setPhone(phone);
	m.setBalance(balance);
	m.setPassword(password);
	
	boolean b =m.userRegistration();
	if (b == true) {
	    resp.sendRedirect(req.getContextPath()+"/RegistrationSuccess.html");
	} else {
	    resp.sendRedirect(req.getContextPath()+"/RegistrationFail.html");
	}

	
	
}
}
