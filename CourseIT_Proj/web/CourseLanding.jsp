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
        <link href="Dependencies\bootstrap\css\bootstrap.css" rel="stylesheet">
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
        
    <header class="navbar navbar-inverse navbar-static-top" role="banner">
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
        
        
        
        
        <!-- Begin Body -->
<div class="container">
	<div class="row">
  			<div class="col-md-3" id="leftCol">
              	
				<div class="well"> 
              	<ul class="nav nav-stacked" id="sidebar">
                  <li><a href="#sec1">Get Simlar Courses Link</a></li>
                  <li><a href="#sec2">Get Simlar Courses Link</a></li>
                  <li><a href="#sec3">Get Simlar Courses Link</a></li>
                  <li><a href="#sec4">Get Simlar Courses Link</a></li>
              	</ul>
  				</div>

      		</div>  
                <!-- Clicking the Star increasing the UV by one. -->
      		<div class="col-md-9">
              	<h2 id="sec0"><%=c.getCourseName() %>  <img src="star.png" style="width:40px;height:40px;text-align: right;"> <%=c.getCourseUV() %></img></h2>
                <h4><%=c.getInstructor() %></h4>
              	<h5>Starting Date : <%=c.getStartingDate() %></h5>
            
           
              	<hr class="col-md-12">
                 <p>University : <%=c.getSourceCompany() %></p>
                <p>Description : <%=c.getCourseDesc() %></p>
                
                <p>Link :<a href="<%=c.getSourceLink()%>"><%=c.getSourceLink()%></a></p>
              <p>Course Category : <%=c.getCourseCtg() %></p></br>
              
              	<h2 id="sec1">Reviews</h2>
              	
               


              	<div class="row">
                  <div class="col-md-6">
                    <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #1</h3></div>
                      <div class="panel-body">
                            <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b><%=reviews.get(iter).getUserId().getName()%></b></br>
                             From{University} : <b><%=reviews.get(iter).getUserId().getName()%></b>      
                          <% iter++; %>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                      <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #2</h3></div>
                      <div class="panel-body">
                           <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b><%=reviews.get(iter).getUserId().getName()%></b></br>
                             From{University} : <b><%=reviews.get(iter).getUserId().getName()%></b>      
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
                          <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b><%=reviews.get(iter).getUserId().getName()%></b></br>
                             From{University} : <b><%=reviews.get(iter).getUserId().getName()%></b>      
                          <% iter++; %>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                      <div class="panel panel-default">
                      <div class="panel-heading"><h3>Review #4</h3></div>
                      <div class="panel-body">
                          <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b><%=reviews.get(iter).getUserId().getName()%></b></br>
                             From{University} : <b><%=reviews.get(iter).getUserId().getName()%></b>      
                          <% iter++; %>
                      </div>
                    </div>
                  </div>  
              	</div>
         
              	
            </div>
        </div>
</div>

<hr class="featurette-divider">
	<div class="container marketing">
	 <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
		
        <p>&copy; 2014 #TeamFAT, Inc. &middot; 
		<a href="#">
		<img src="facebook.png" href="#" style="width:30px;height:30px;">
		</a> &middot; 
		<a href="#">
		<img src="linkedin.png" href="#" style="width:30px;height:30px;">
		</a> &middot; 
		<a href="#">
		<img src="twitter.png" href="#" style="width:30px;height:30px;">
		</a> &middot; 
		<a href="#">
		<img src="pinterest.png" href="#" style="width:30px;height:30px;">
		</a> &middot; 
		</p>
      </footer>
	  </div>

        
        <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>


        <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script>
        <script type='text/javascript'>
        
        $(document).ready(function() {
        
            

        
        });
        
        </script>
        
    </body>
</html>
