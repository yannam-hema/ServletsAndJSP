package pOne;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.setContentType("text/html");
   PrintWriter Writer = resp.getWriter();
   String email=req.getParameter("email");
   String pwd= req.getParameter("pwd");
  Model m = new Model(); 
   m.setEmail(email);
   m.setPassword(pwd);
   boolean b = m.login();
 if(b==true) {
	 resp.sendRedirect("/LoginSuccess.html");
 }
 else {
	 Cred.count--;
	 if(Cred.count>0) {
		Writer.println("<b> The available number of attempte = "+Cred.count+"</b>");
		RequestDispatcher reqd = req.getRequestDispatcher("/index.html");
		reqd.include(req, resp);
	 }
	 else {
		 resp.sendRedirect("/LoginFail.html"); 
	 }
 }

//   writer.print("<html>");
//   writer.print("<html>");
//   writer.print("<head>");
//   writer.print("<title>HTML in Servlet");
//   writer.print("</title>");
//   writer.print("</head>");
//   writer.print("<body>");
//   writer.print("<h1> hello from Servlet File");
//   writer.print("</h2> </body> </html>");
}
}
