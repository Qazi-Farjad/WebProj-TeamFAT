/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Farjad
 */
public class Servlet_Login {
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        
        response.setContentType("text/html");
        PrintWriter out=null;
    
        try{
            String email=request.getParameter("Email");
            String passw=request.getParameter("password");

            System.out.println("Debug Point 1");
            DB_CommUserAcc user = new DB_CommUserAcc();
            
            if(user.checkIfUserExists(email, passw)){
                HttpSession session = request.getSession(true);
                //Session ka ID set karna hai, so we can see to whom it belongs.
                //session.setAttribute("id", ID);
    //            RequestDispatcher rd = request.getRequestDispatcher ("http://localhost:8084/");
    //            rd.forward (request, response);
            }
            else{
                    out.println("<h2><center>Error: Login Information is Incorrect</center></h2>");
            }

        }catch (Exception ex){
            System.out.println("Exception..."+ex.getMessage());
        }
    }
}
