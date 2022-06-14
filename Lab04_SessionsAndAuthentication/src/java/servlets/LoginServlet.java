package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Create a session object
        HttpSession session = request.getSession();

        String operation = request.getParameter("operation");
        // if the operation parameter exists and equals "reset" 
        //we should reset the form

        //Linked to the hidden logout operation on the home page.
        if (operation != null && operation.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        }
        //Redirects to home if user is logged in, but types in /login 
        if (session.getAttribute("username") != null) {
            response.sendRedirect("home");
            return;
        }

        //load up the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return; //Stops the code call. VERY IMPORTANT.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //capture username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //check for empty input boxes
        if (username == null || password == null || username.equals("") || password.equals("")) {
            String message = "Please enter a username or password.";
            request.setAttribute("message", message);
            
        } else {
            // create AccountService and User objects.
            AccountService account = new AccountService();
            User user = account.login(username, password);

            if (user != null) {
                request.getSession().setAttribute("username", username);
                response.sendRedirect("home");
                return;
            } else {
                request.setAttribute("username", username);
                String message = "Invalid username or password";
                request.setAttribute("message", message);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
