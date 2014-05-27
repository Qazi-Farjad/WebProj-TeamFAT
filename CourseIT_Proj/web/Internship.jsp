<%-- 
    Document   : Forums
    Created on : May 28, 2014, 2:21:49 AM
    Author     : Talal Saleem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .modal-dialog {
  width: 100%;
  height: 100%;
  padding: 0;
}

.modal-content {
  height: 100%;
  border-radius: 0;
}
        </style>
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
        <h1 style="text-align:center;">Internships</h1>
        <!-- Search courses by title and generate cards + starting ma kuch card ho for the user to choose.-->
        <div class="container">
            <div class="col-lg-6">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Search Internship!">
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
      
         <div class="thumbnail" id="target_1" style="cursor: pointer;" >
            
              <div class="caption">
           <h3>Get Internship Title</h3>
           <p>Over Here get Internship Info</p>
            <!-- get Company University Name-->      
          
           <a href="">get email</a>
             <p><b>get Ending Date</b></p>
             </p><b>Get starting Date as Last day to submit</b></p>
          
         </div>
            </div>
             
         
             
         </div>
            
           <div class="col-xs-6">
               <div data-toggle="modal" data-target="#GSCCModal">
          <div class="thumbnail" id="target_1" style="cursor: pointer;" >
            
              <div class="caption">
           <h3>Get Internship Title</h3>
           <p>Over Here get Internship Info</p>
            <!-- get Company University Name-->      
          
           <a href="">get email</a>
             <p><b>get Ending Date</b></p>
             </p><b>Get starting Date as Last day to submit</b></p>
          
         </div>
            </div>
               </div>
               <div id="GSCCModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;  </button>
        <h4 class="modal-title" id="myModalLabel">Form </h4>
      </div>
      <div class="modal-body">
       
      <iframe src="https://docs.google.com/a/seecs.edu.pk/forms/d/11wII_WoCygdhL8BdImfRgdCB9C3K9qdrmKZPTPNvGoM/viewform" width="90%" height="90%">
		<p>Your browser does not support iframes.</p>
		</iframe>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
         </div>
        </div>
            </div>
     
        
        
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
