package Controller;

import java.io.IOException;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Delete")
public class Delete  extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 3635980731730650175L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	
	Model m = new Model();
	m.setName(name);
	boolean b =m.deleteUser();
	if(b==true) {
		 resp.sendRedirect(req.getContextPath()+"/DeleteSuccess.html");
	}
	else {
		 resp.sendRedirect(req.getContextPath()+"/DeleteFail.html");
	}
	
}
}
