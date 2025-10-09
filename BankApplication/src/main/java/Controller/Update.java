package Controller;

import java.io.IOException;
import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String email = req.getParameter("uNewEmail");

        Model m = new Model();
        m.setName(uname);
        m.setEmail(email);

        boolean b = m.emailUpdate();
        if (b) {
            resp.sendRedirect(req.getContextPath() + "/EmailUpdate.html");
        } else {
            resp.sendRedirect(req.getContextPath() + "/UpdationFail.html");
        }
    }
}
