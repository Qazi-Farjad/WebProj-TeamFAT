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
          width: 50%; /* or whatever you want */
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

            background: #eee;
            color: #000;
            padding: 20px;    
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
              <a href="Internship.jsp">Internship</a>
            </li>
                        
            <li>
              <a href="ProfileLanding.jsp"><%= name%></a>
            </li>
          </ul>
        </nav>
      </div>
    </header>
        
    <!-- _____Navbar ____-->
    
    
        <h1 style="text-align:center;">Courses</h1>
        <!-- Search courses by title and generate cards + starting ma kuch card ho for the user to choose.-->
        <div class="container">
            <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search Courses!">
      <span class="input-group-btn">
        <button class="btn btn-primary" type="button" >Go!</button>
      </span>
        </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
        </div><!-- /.row -->
        </br></br>
        <div class="container">
             <div class="row">
         <div class="col-xs-6">
          <div class="thumbnail" id="target_5" style="cursor: pointer;">
               <!-- Get Course Image.-->      
              <img data-src="holder.js/300x200" alt="No image">
              <div class="caption">
           <h3>Get Course Title</h3>
           <p>Intructor : Get intructor</p>
           <p>Description : Courses Desc</p>
            <!-- get Company University Name-->      
           <p>University/Institute : get uni Name</p>
           <p>Starting Date</p>
           <a href="">get Company link</a></br>
            <p style="text-align: center;"><img src="star.png" style="width:20px;height:20px;"> <b>Get UV</b></img></p>
            
         
         </div>
            </div>
             
         </div>
            
           <div class="col-xs-6">
          <div class="thumbnail"id="target_4" style="cursor: pointer;">
               <!-- Get Course Image.-->      
              <img data-src="holder.js/300x200" alt="No image">
              <div class="caption">
           <h3>Get Course Title</h3>
           <p>Intructor : Get intructor</p>
           <p>Description : Courses Desc</p>
            <!-- get Company University Name-->      
           <p>University/Institute : get uni Name</p>
           <p>Starting Date</p>
           <a href="">get Company link</a></br>
            <p style="text-align: center;"><img src="star.png" style="width:20px;height:20px;"> <b>Get UV</b></img></p>
          
         </div>
            </div>
             
         </div>
        </div>
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
