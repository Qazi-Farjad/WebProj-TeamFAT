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
        <%@ page import="webProj.CourseIT.Beans.Useraccinfo,webProj.CourseIT.Beans.Courses"%>
        <%@ page import="webProj.CourseIT.Funct.DB_CourseEnroll"%>
        <%@ page import="webProj.CourseIT.Funct.DB_Internships, webProj.CourseIT.Beans.Internships"%>
        <%@ page import="webProj.CourseIT.Beans.Useracademicinfo"%>
        <%@ page import="java.util.List"%>        
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
        <link rel="stylesheet" href="Dependencies\bootstrap\css\bootstrap.css" media="screen">
        <link href="Dependencies\signin.css" rel="stylesheet">
        
        <style>
        .coursesContInt{
          float:left;
          height: 40%; /* or whatever you want */
          position:relative;
          width: 100%; /* or whatever you want */
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
          <a href="index.html" class="navbar-brand">CourseIT</a>
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
    
    <center><h2 style = "color:#7D7D7D; text-shadow: 1px 1px #2953CF;"> Welcome, <%= name%> </h2></center>
     <hr class="featurette-divider">
    <div class="container">
    <div class="row">
        
        <!-- Edit Profile -->
        
        <%
            Useracademicinfo acad = uai.getUseracademicinfo();
        %>
        
        <div class="col-md-3" >
            <h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Your Profile Tag</h3>
            
            <div class="thumbnail" style="cursor: pointer;">
               <!-- Get Profile Pic Image.-->      
              <img src="
                      <% if(uai.getUserPic() != null){
                       out.print(uai.getUserPic());
                        }
                       else{
                           out.print("Images\\def-ava.png");
                       }
                       %>" height = "250" width = "175" alt="No image">
              <div class="caption">
                  <center>
                   <h3><%=uai.getName()%></h3>
                   <p>University : 
                       <% if(acad != null){
                       out.print(acad.getUni());
                        }
                       else{
                           out.print("N/A");
                       }
                       %>
                   </p>
                   <p>School : 
                   <% if(acad != null){
                       out.print(acad.getSchool());
                        }
                       else{
                           out.print("N/A");
                       }
                       %></p>
                   <p>Degree : 
                   <% if(acad != null){
                       out.print(acad.getDegree());
                        }
                       else{
                           out.print("N/A");
                       }
                       %></p>     
                  </center>                     
              </div>
            </div>
        </div>
        
        <!-- __________________________ User's Courses __________________________________-->
        <%
            DB_CourseEnroll ce = new DB_CourseEnroll();
            List<Courses> curse = ce.getEnrollmentbyUser(userID);
        %>
        
        <div class="col-md-6" style="padding-right:20px; border-right: 1px solid #ccc;border-left: 1px solid #ccc;">
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">Your Courses</h3></center>
        <div class="coursesCont">
        <%
            for(Courses course: curse){           
            %>
                
          <div class="thumbnail crse" id="<%=course.getCourseID()%>" style="cursor: pointer;">
               <!-- Get Course Image.-->      
              <img src="<%=course.getCoursepic()%>" height = "250" width = "175" alt="No image">
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
        

            
            
        </div>
        
        <!--_____________________ Recommended courses and internship______________________ -->
        

        
        <div class="col-md-3">
            <center><h3 style="color:#7D7D7D; text-shadow: 1px 1px #2953CF;">RECOMMENDED</h3></center>
    
            <%
            DB_Internships ints = new DB_Internships();
            List<Internships> internships = ints.getInternshipsByField("CS");
            %>
            
        <div class="coursesContInt">
            <%
                for(Internships i: internships){
                    
                
            %>
                
         <div class="pull-right" style="padding-left:20px;padding-top: 20px;">
         <div class="thumbnail" id="target" style="cursor: pointer;" >
            
         <div class="caption">
           <h3>Internship by: <%=i.getSubmitter()%></h3>
           <hr class="featurette-divider">
           <p><%=i.getInfo()%></p>
            <!-- get Company University Name-->      
          
           <a href="mailto:<%=i.getEmail()%>">Send Email</a>
             <p><b><%=i.getDuration()%></b></p>
             <hr class="featurette-divider">
             <p><b>Last day to submit: <%=i.getStartingDate()%></b></p>
          
         </div>
          </div>
             
         </div>
         <%
                }
                    %>
        </div>
        <!--__________Internships_____________ -->
        </div>
      </div>
        </div>
    
        
    
    
    <!-- ______________________________ -->
            

    
    
    
    <script type='text/javascript' src="Dependencies\jquery-2.1.1.js"></script>


        <script type='text/javascript' src="Dependencies\bootstrap\js\bootstrap.min.js"></script>
        <script type='text/javascript'>
        
        $(document).ready(function() {
            
        $('.crse').click(ajaxCall);
        
        function ajaxCall(){
         $.post("CourseLandingServlet",
              {
                ids:"1"

              },
              function(data,status){
              });
           
              }
              
        $( "#target" ).click(function() {
         alert( "Send an Email to the given Link to apply for Internship" );
        });
        
        
        
        });
        
        
        
        </script>
        </body>
</html>
