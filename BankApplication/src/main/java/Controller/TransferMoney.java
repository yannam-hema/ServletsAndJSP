package Controller;

import java.io.IOException;

import Model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/TransferMoney")
public class TransferMoney extends HttpServlet {


	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
        HttpSession session = req.getSession();
        int senderAccno = (int)session.getAttribute("accno");

        int targetAccno = Integer.parseInt(req.getParameter("transferAccno"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        Model sender = new Model();
        sender.setAccno(senderAccno);
        boolean senderFound = sender.fetchBalance();
        if (!senderFound || sender.getBalance() < amount) {
            res.sendRedirect("InsufficientBalance.html");
            return;
        }

        Model receiver = new Model();
        receiver.setAccno(targetAccno);
        boolean receiverFound = receiver.fetchBalance();
        if (!receiverFound) {
            res.sendRedirect("NoAccount.html");
            return;
        }

 
        boolean senderUpdate = sender.updateBalance(senderAccno, sender.getBalance() - amount);
        boolean receiverUpdate = receiver.updateBalance(targetAccno, receiver.getBalance() + amount);

        if (senderUpdate && receiverUpdate) {
            res.sendRedirect("TransferSuccess.html");
        } else {
            res.sendRedirect("TransferFail.html");
        }
    }
}
