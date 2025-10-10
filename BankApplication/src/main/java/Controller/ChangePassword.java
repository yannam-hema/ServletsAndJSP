package Controller;

import java.io.IOException;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet{
	private HttpSession session;
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 	 session= req.getSession();
 	 int accno =(int) session.getAttribute("accno");
 	 
 	 String opwd = req.getParameter("opwd");
 	 String npwd = req.getParameter("npwd");
 	 String cnpwd = req.getParameter("cnpwd");
 	 
 	 if(npwd.equals(cnpwd)) {
 		 Model m = new Model();
 		 m.setAccno(accno);
 		 m.setPassword(opwd);
 		 m.setNpassword(npwd);
 		 
 		 boolean b = m.changePassword();
 		 if(b==true) {
 			 resp.sendRedirect(req.getContextPath()+"/passwordChangeSuccess.html");
 		 }
 		 else {
 			 resp.sendRedirect(req.getContextPath()+"/passwordChangeFail.html");
 		 }
 	 }
 	 else {
 		 resp.sendRedirect(req.getContextPath()+"/passwordMismatch.html");
 	 }
}
}
