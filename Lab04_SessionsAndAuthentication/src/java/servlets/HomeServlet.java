package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //set up the session
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        
//If trying to access /home without logging in, redirect to /login
        if (username == null || username.equals("")) {
            response.sendRedirect("login");
            return;
        }

        //retrieve the parameter from the logout form
        String operation = request.getParameter("operation");
        // if the operation parameter exists and equals "logout" 
        //we should logout
        if (operation != null && operation.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        }


        //load the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        return; //Stops the code call. VERY IMPORTANT.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
