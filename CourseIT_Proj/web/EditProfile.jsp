

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
        
        
        <title>Profile: <%=name%></title>
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

        <div class ="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form role="form" action="EditProfileServlet">
                  <div class="form-group">
                    <label for="university">University</label>
                    <input class="form-control" type = "text" name="university" placeholder="Enter University Name">
                  </div>
                  <div class="form-group">
                    <label for="school">School</label>
                    <input class="form-control" type = "text" name="school" placeholder="Enter School Name">
                  </div>
                    
                  <div class="form-group">
                    <label for="degree">Degree</label>
                    <input class="form-control" type = "text" name="degree" placeholder="Choose your degree">
                  </div>
                
                    <label for="profiePic">File input (Image)</label>
                    <input type="file" id="profiePic">
                    <p class="help-block">Upload a Profile Pic</p>
                  
                  <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>    
        </div>    

        
        
        
        
        <!-- Begin Body -->
        
        <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>


        <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script>
        <script type='text/javascript'>
        
        $(document).ready(function() {
        
            

        
        });
        
        </script>
        
    </body>
</html>
