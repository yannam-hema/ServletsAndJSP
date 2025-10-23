package Controller;

import java.io.IOException;

import Model.HibernateManager;
import Utils.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int id =Integer.parseInt(req.getParameter("delId"));
UserDetails ud = new UserDetails();
HibernateManager hbm = new HibernateManager();
boolean b = hbm.deleteUser(ud,id);
if(b) {
	resp.sendRedirect(req.getContextPath() +"/DeleteSuccess.html");
}
else {
	resp.sendRedirect(req.getContextPath() +"/DeleteFail.html");
}
}
}
