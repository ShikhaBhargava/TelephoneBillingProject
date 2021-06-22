package com.action;

import com.DAO.AdminManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminController extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
      
        String adminuname = request.getParameter("adminuname");
        String adminpwd = request.getParameter("adminpwd");
        
        AdminManager am = new AdminManager();
        
        if(am.Validate(adminuname, adminpwd))
        {
            request.getSession().setAttribute("username", adminuname);
            response.sendRedirect("/com.DAO/adminSuccess.jsp");
        }
        else
        {
              response.sendRedirect("/com.DAO/Failure.jsp");
        }
        
    }

}
