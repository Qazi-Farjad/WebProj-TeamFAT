<%-- 
    Document   : CourseLanding
    Created on : May 12, 2014, 2:00:22 PM
    Author     : Farjad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="Dependencies\bootstrap\css\bootstrap.min.css" rel="stylesheet">
        <%@ page import="webProj.CourseIT.Beans.Useraccinfo, java.util.List"%>
        <%@ page import="webProj.CourseIT.Beans.Courses,webProj.CourseIT.Funct.DB_Courses"%>
        <%@ page import="webProj.CourseIT.Beans.Review,webProj.CourseIT.Funct.DB_Review"%>
        <%
        String user = null;
        if(session.getAttribute("user") == null){
            response.sendRedirect("login.html");
        }
            
        Useraccinfo uai = (Useraccinfo)session.getAttribute("user");
        String name = uai.getName();
        int userID = uai.getUserId();
        DB_Courses db = new DB_Courses();
        
        int iter = 0;

        Courses c = (Courses)session.getAttribute("ViewCourse");
        DB_Review rev = new DB_Review();
        List<Review> reviews = rev.getReviews(1);
        %>        
        
        
        <title><%=c.getCourseName() %></title>
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
        
        
        
        
        <!-- Begin Body -->
<div class="container">
	<div class="row">
  			<div class="col-md-3" id="leftCol">
              	
				<div class="well"> 
              	<ul class="nav nav-stacked" id="sidebar">
                  <li><a href="#sec1">Section 1</a></li>
                  <li><a href="#sec2">Section 2</a></li>
                  <li><a href="#sec3">Section 3</a></li>
                  <li><a href="#sec4">Section 4</a></li>
              	</ul>
  				</div>

      		</div>  
      		<div class="col-md-9">
              	<h2 id="sec0"><%=c.getCourseName() %></h2>
                <%=c.getInstructor() %><br/>
              	
            
           
              	<hr class="col-md-12">
                <%=c.getCourseDesc() %><br>
                <%=c.getSourceCompany() %><br>
                <%=c.getSourceLink()%>
              
              
              	<h2 id="sec1">Instructor info:</h2>
              	
                <h5 id="in1">Instructor: <%=c.getInstructor() %></h5>


              	<div class="row">
                  <div class="col-md-6">
                    <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #1</h3></div>
                      <div class="panel-body">
                          <%=reviews.get(iter).getReviews()%>
                          <br>
                          BY: <%=reviews.get(iter).getUserId().getName()%>
                          <% iter++; %>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                      <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #2</h3></div>
                      <div class="panel-body">
                          <%=reviews.get(iter).getReviews()%>
                          <br>
                          BY: <%=reviews.get(iter).getUserId().getName()%>
                          <% iter++; %>
                      </div>
                    </div>
                  </div>  
              	</div>
                
                <div class="row">
                  <div class="col-md-6">
                    <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #3</h3></div>
                      <div class="panel-body">
                          <%=reviews.get(iter).getReviews()%>
                          <br>
                          BY: <%=reviews.get(iter).getUserId().getName()%>
                          <% iter++; %>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                      <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #4</h3></div>
                      <div class="panel-body">
                          <%=reviews.get(iter).getReviews()%>
                          <br>
                          BY: <%=reviews.get(iter).getUserId().getName()%>
                          <% iter++; %>
                      </div>
                    </div>
                  </div>  
              	</div>
         
              	
            </div>
        </div>
</div>



        
        <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>


        <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script>
        <script type='text/javascript'>
        
        $(document).ready(function() {
        
            

        
        });
        
        </script>
        
    </body>
</html>
