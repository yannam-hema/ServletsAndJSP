package Controller;

import java.io.IOException;

import Model.HibernateManager;
import Utils.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String newname=req.getParameter("newname");
	UserDetails ud = new UserDetails();
    HibernateManager hbm = new HibernateManager();
    boolean b = hbm.updateData(ud, id,newname);
    if(b) {
    	resp.sendRedirect(req.getContextPath() +"/UpdateSuccess.html");
    }
    else {
    	resp.sendRedirect(req.getContextPath() +"/UpdateFail.html");
    }
}
}
