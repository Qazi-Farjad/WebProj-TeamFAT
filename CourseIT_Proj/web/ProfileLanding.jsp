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
        <%@ page import="webProj.CourseIT.Beans.Useraccinfo,webProj.CourseIT.Beans.Courses,"%>
        <%@ page import="webProj.CourseIT.Funct.DB_CourseEnroll"%>
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
        <title>Profile: <%= name %></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Dependencies\bootstrap\css\bootstrap.min.css" media="screen">
        <link href="Dependencies\signin.css" rel="stylesheet">
    </head>
    <body>

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
              <a href="Courses.jsp">Courses</a>
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
    
    <br><br>
    Your Courses:
    <%
        DB_CourseEnroll ce = new DB_CourseEnroll();
        ce.getEnrollmentbyUser(userID);
    %>
    
        
    
    
    <!-- ______________________________ -->
            
    <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>
    <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script> 
    </body>
</html>
