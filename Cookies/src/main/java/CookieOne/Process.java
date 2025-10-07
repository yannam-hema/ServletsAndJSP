package CookieOne;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Process")
public class Process extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String uname = req.getParameter("uname");
        String umail = req.getParameter("umail");
        String uphone = req.getParameter("uphone");
        String upwd = req.getParameter("upwd"); // fixed name

        Cookie c1 = new Cookie("user_name", uname);
        Cookie c2 = new Cookie("user_mail", umail);
        Cookie c3 = new Cookie("user_phone", uphone);
        Cookie c4 = new Cookie("user_pwd", upwd);

        res.addCookie(c1);
        res.addCookie(c2);
        res.addCookie(c3);
        res.addCookie(c4);

 
        PrintWriter out = res.getWriter();
        out.println("Cookies stored");
        
    }
}
