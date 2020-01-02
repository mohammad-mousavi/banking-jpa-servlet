package banking.web;

import banking.controller.BankAccountController;
import banking.entity.BankAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int number = Integer.parseInt(request.getParameter("number"));
        long balance = Long.parseLong(request.getParameter("balance"));
        String owner = request.getParameter("owner");
        
        BankAccount ba = new BankAccount(number, owner, balance);

        BankAccountController service = new BankAccountController();
        service.createAccount(ba);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("Account Created!");
        out.println("</html>");
        out.close();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
