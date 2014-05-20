<%-- 
    Document   : ProfileLanding
    Created on : May 20, 2014, 8:35:29 PM
    Author     : Farjad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="webProj.CourseIT.Beans.Useraccinfo"%>
        <%
        String user = null;
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.html");
        }
            
        Useraccinfo uai = (Useraccinfo)session.getAttribute("user");
        String name = uai.getName();     
        int userID = uai.getUserId();
        String sessionID = session.getId();
        Cookie[] cookies = request.getCookies();

        %>
    <header class="navbar navbar-default navbar-static-top" role="banner">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="/" class="navbar-brand">CourseIT</a>
        </div>
        <nav class="collapse navbar-collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li>
              <a href="#">Courses</a>
            </li>
            <li>
              <a href="#">Explore</a>
            </li>
            <li>
              <a href="EditProfile.jsp">Edit Profile</a>
            </li>
            <li>
              <a href="#">Groups</a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
    
    <h1> Welcome to CourseIT <%= name%> </h1>
    
        
    
    
    <!-- ______________________________ -->
    </body>
</html>
