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
        //int cid = (Integer)session.getAttribute("CourseID");
        DB_Review rev = new DB_Review();
        List<Review> reviews = rev.getReviews(6);
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
<div class="thumbnail" style="cursor: pointer;" id="sidebar">
                   <!-- Get Course Image.-->      
                  <img src="<% if(c.getCoursepic() != null){
                       out.print(c.getCoursepic());
                        }
                       else{
                           out.print("Images\\def-coursepic.jpg");
                       }
                       %>
                          " height = "250" width = "250" alt="No image">
                  <div class="caption">
                        <!-- get Company University Name-->      
                       <p>Offered by : <%=c.getSourceCompany()%></p>
                       <p>Starting Date: <%=c.getStartingDate()%></p>
                       <a href="<%=c.getSourceLink() %>">Go to Course >></a></br>
                       <p style="text-align: center;"><img src="Images\star.png" style="width:20px;height:20px;"> <b><%=c.getCourseUV()%></b></p>

                  </div>
              </div>
              	
  				</div>

      		</div>  
                <!-- Clicking the Star increasing the UV by one. -->
      		<div class="col-md-9">
              	<h2 id="sec0"><%=c.getCourseName() %>  <img src="Images\star.png" style="width:40px;height:40px;text-align: right;"> <%=c.getCourseUV() %></h2>
                <h4><%=c.getInstructor() %></h4>
              	<h5>Starting Date : <%=c.getStartingDate() %></h5>
            
           
              	<hr class="col-md-12">
                <p>Description : <%=c.getCourseDesc()%></p>
                
                <p>Link :<a href="<%=c.getSourceLink()%>"><%=c.getSourceLink()%></a></p>
                <p>Course Category : <%=c.getCourseCtg()%></p><br>
              
              <!--__________________________________________________-->
               <form action="CourseEnrollServlet">
                  <input type="hidden"  name="cid" value="6">
                  <input type="hidden"  name="uid" value="<%=userID%>">                  
                  <input type="submit" class ="btn btn-primary" value="Follow" id = "followBtn">
               </form>
              <!--__________________________________________________-->
              
              	<h2 id="sec1">Reviews</h2>
              	<div class="row">
                  <div class="col-md-6">
                    <div class="panel panel-primary">
                      <div class="panel-heading"><h3>Review #1</h3></div>
                      <div class="panel-body">
                            <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b><%=reviews.get(iter).getUserId().getName()%></b></br>
                                
                          <% iter++; %>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                      <div class="panel panel-primary">
                      <div class="panel-heading"><h3>Review #2</h3></div>
                      <div class="panel-body">
                           <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b>Amar Rasul</b></br>
                               
                          <% iter++; %>
                      </div>
                    </div>
                  </div>  
              	</div>
                
                <div class="row">
                  <div class="col-md-6">
                    <div class="panel panel-primary">
                      <div class="panel-heading"><h3>Review #3</h3></div>
                      <div class="panel-body">
                          <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b>AhmedBQ</b></br>
                               
                          <% iter++; %>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                      <div class="panel panel-primary">
                      <div class="panel-heading"><h3>Review #4</h3></div>
                      <div class="panel-body">
                          <p><%=reviews.get(iter).getReviews()%><p>
                          
                          BY: <b><%=reviews.get(iter).getUserId().getName()%></b></br>
                               
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
            
            
            $('#followBtn').click(function(){
                alert("Course now followed");
            });

        $('#FollowBtn').click(ajaxCall);
        
        
        function ajaxCall(){
         $.post("CourseEnrollServlet",
              {
                userid:"1",
                courseid:"1"
              },
              function(data,status){
              });
           
        }

        
        });
        
        </script>
        
    </body>
</html>
