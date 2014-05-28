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
        <link rel="stylesheet" href="Dependencies\bootstrap\css\bootstrap.css" media="screen">
        <link href="Dependencies\signin.css" rel="stylesheet">
        
        <style>
        .containerCont{
          float:left;
          position:relative;
        }
        .coursesCont{
          float:left;
          height: 50%; /* or whatever you want */
          position:relative;
          width: 80%; /* or whatever you want */
          margin-left: 10%;
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
              <a href="Internship.jsp">Internship</a>
            </li>
          </ul>
            <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="ProfileLanding.jsp"><%= name%></a>
            </li>
            <li>
              <a href="EditProfile.jsp">Edit Profile</a>
            </li>
            </ul>
        </nav>
      </div>
    </header>
    <!-- _____Navbar ____-->
    
    
        <h1 style="text-align:center;">Courses</h1>
        
        <div class="col-md-9 col-md-offset-3" style="padding-right:20px; border-right: 1px solid #ccc;border-left: 1px solid #ccc;">
        <h3 style="color:#E80C3F;">Your Courses</h3>
        <div class="coursesCont">
        <%
            for(Courses course: CourseList){
                
            
            %>
                
          <div class="thumbnail" id="target_5" style="cursor: pointer;">
               <!-- Get Course Image.-->      
              <img src="Images\def-ava.png" height = "250" width = "175" alt="No image">
              <div class="caption">
                   <h3><%=course.getCourseName()%></h3>
                   <p>Instructor : <%=course.getInstructor()%></p>
                   <p>Description :<%=course.getCourseDesc()%></p>
                    <!-- get Company University Name-->      
                   <p>Offered by : <%=course.getSourceCompany()%></p>
                   <p>Starting Date: <%=course.getStartingDate()%></p>
                   <a href="<%=course.getSourceLink() %>">Go to Course >></a></br>
                   <p style="text-align: center;"><img src="Images\star.png" style="width:20px;height:20px;"> <b><%=course.getCourseUV()%></b></p>
            
         
              </div>
          </div>
            <%
            }
            %>
          
        </div>
        <%

        for(Courses course: CourseList){
            %>
            
        <div class="coursesCont" id = "<%=course.getCourseID()%>">
                       
            <%
            out.print("<center>" +course.getCourseName() + "</center>");
            out.print("<center> By: " + course.getInstructor() + "</center><br><br>");
            %>
            
            <form action="CourseLandingServlet">
              <input type="hidden" name="id" value="<%=course.getCourseID()%>">
              <input type="submit" value="Go to Course">
            </form>
            
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
