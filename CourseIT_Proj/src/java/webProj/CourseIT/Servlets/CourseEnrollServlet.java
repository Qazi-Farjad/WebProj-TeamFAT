/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webProj.CourseIT.Beans.Courses;
import webProj.CourseIT.Funct.DB_CourseEnroll;
import webProj.CourseIT.Funct.DB_Courses;

/**
 *
 * @author Farjad
 */
@WebServlet(name = "CourseEnrollServlet", urlPatterns = {"/CourseEnrollServlet"})
public class CourseEnrollServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String cid = request.getParameter("cid");
        String uid = request.getParameter("uid");
        
        int userid = Integer.parseInt(uid);
        int courseid = Integer.parseInt(cid);
        
        
        DB_CourseEnroll ce = new DB_CourseEnroll();

        ce.setEnrollment(userid, courseid);
        
        
        DB_Courses course = new DB_Courses();
        Courses c = course.getCourse(courseid);
        //course.incrementUV(courseid);
        
        try{
        HttpSession session = request.getSession();
            
        session.setAttribute("ViewCourse", c);
        
        String encodedURL = response.encodeRedirectURL("CourseLanding.jsp");
        response.sendRedirect(encodedURL);
        
        
        }catch(Exception e){
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
