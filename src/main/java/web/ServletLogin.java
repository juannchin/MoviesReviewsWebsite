/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.LoginDao;
import datos.LoginBean;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

/**
 *
 * @author juan
 */

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet{ 
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("username");  
    String p=request.getParameter("password");  
    
    LoginBean loginBean = new LoginBean();
     
    loginBean.setUserName(n);
    loginBean.setPassword(p);
    
    LoginDao loginDao = new LoginDao();
    
    if(LoginDao.validate(n, p)){  
        
         String userValidate = loginDao.authenticateUser(loginBean);
 
        if(userValidate.equals("Admin_Role"))
        {
 
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("Admin", true); //setting session attribute
            request.setAttribute("userName", n);
 
            request.getRequestDispatcher("/ServletTipoUsuario").forward(request, response);
        }
        else if(userValidate.equals("User_Role"))
        {
 
            HttpSession session = request.getSession();
            session.setAttribute("User", n);
            request.setAttribute("userName", n);
 
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
        /*RequestDispatcher rd=request.getRequestDispatcher("/ServletTipoUsuario");  
        rd.forward(request,response); */ 
    }  
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  