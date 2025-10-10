package Controller;
import java.io.IOException;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Balance")
public class Balance extends HttpServlet {
    private HttpSession session;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        int accno = (int) session.getAttribute("accno");
        
        Model m = new Model();
        m.setAccno(accno);

        boolean b = m.fetchBalance();
        if (b) {
            session.setAttribute("balance", m.getBalance());
            resp.sendRedirect(req.getContextPath() + "/CheckBalance.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/CheckBalanceFail.html");
        }
    }
}

