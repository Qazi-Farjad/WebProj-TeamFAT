<%-- 
    Document   : Courses
    Created on : May 20, 2014, 10:00:08 PM
    Author     : Farjad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses</title>
        <%@ page import="webProj.CourseIT.Beans.Useraccinfo, java.util.List"%>
        <%@ page import="webProj.CourseIT.Beans.Courses,webProj.CourseIT.Funct.DB_Courses"%>
        <%
        String user = null;
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.html");
        }
            
        Useraccinfo uai = (Useraccinfo)session.getAttribute("user");
        String name = uai.getName();
        int userID = uai.getUserId();
        DB_Courses db = new DB_Courses();
        List<Courses> CourseList = db.getAllCourses();
        
        %>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Dependencies\bootstrap\css\bootstrap.min.css" media="screen">
        <link href="Dependencies\signin.css" rel="stylesheet">
        
        <style>
        .containerCont{
          float:left;
          position:relative;
        }
        .coursesCont{
          float:left;
          height: 250px; /* or whatever you want */
          position:relative;
          width: 550px; /* or whatever you want */
          border:10px solid red;
        }
          
        a.divLink{
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            text-decoration: none;
            /* Makes sure the link doesn't get underlined */
            z-index: 10;
            /* raises anchor tag above everything else in div */
            background-color: white;
            /*workaround to make clickable in IE */
            opacity: 0;
            /*workaround to make clickable in IE */
            filter: alpha(opacity=0);
            /*workaround to make clickable in IE */
        }
        div.coursesCont {
            position: relative;
            width: 200px;
            height: 200px;
            background: #eee;
            color: #000;
            padding: 20px;    
        }

        div.coursesCont:hover {
            cursor: hand;
            cursor: pointer;
            opacity: .5;
        }
        </style>
        
        
    </head>
    <body>
        
        
        <!-- _____Navbar ____-->
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
            
            <li>
              <a href="ProfileLanding.jsp"><%= name%></a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
        
    <!-- _____Navbar ____-->
        
        <div class="containerCont">
        
        Courses: <br>

        <%

        for(Courses course: CourseList){
            %>
            
            <div class="coursesCont" id = "<%=course.getCourseID()%>">
                       
            <%
            out.print("<center>" +course.getCourseName() + "</center>");
            out.print("<center> By: " + course.getInstructor() + "</center>");
            %>
            </div>
            <%
        }

        %>
        
        
        </div>
            
    <!-- ______________________________ -->
    

    
    <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>
    <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script>
    <script>
    $(document).ready(function() {
        $( ".coursesCont" ).click(function() {
            var id = $(this).id;
            $.post("CourseLandingServlet",
              {
                ids:id,
              },
              function(data,status){
              });
        }
            

        
        });
    </script>
        
    
    </body>
</html>
