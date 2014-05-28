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
    
    <h1> Welcome to CourseIT <%= name%> </h1>
     <hr class="featurette-divider">
    <div class="container">
    <div class="row">
        
        <!-- Edit Profile -->
        <div class="col-md-3" >
            <h3 style="color:#E80C3F;">Edit Profile</h3>
             <p>Get University Name : <a href="#" class="btn btn-default" data-toggle="modal" data-target="#basicModal">Edit</a></p>
             <div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
            <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title" id="myModalLabel">Edit University Name</h4>
            </div>
            <div class="modal-body">
                <h3><input class="form-control" type = "text" name="university" placeholder="Enter University Name"></h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
                
                
                
             </div>
         </div>
        </div>
        </div>
              <hr class="featurette-divider">
              <p>Get school Name   : <a href="#" class="btn btn-default" data-toggle="modal" data-target="#basicModal_1">Edit </a></p>
             <div class="modal fade" id="basicModal_1" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
            <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title" id="myModalLabel">Edit school Name</h4>
            </div>
            <div class="modal-body">
                <h3> <input class="form-control" type = "text" name="school" placeholder="Enter School Name"></h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
                
                
                
             </div>
         </div>
        </div>
        </div>
               <hr class="featurette-divider">
               <p>Get degree       : <a href="#" class="btn btn-default" data-toggle="modal" data-target="#basicModal_2">Edit</a></p>
             <div class="modal fade" id="basicModal_2" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
            <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title" id="myModalLabel">Edit degree</h4>
            </div>
            <div class="modal-body">
                <h3><input class="form-control" type = "text" name="degree" placeholder="Choose your degree"></h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
                
                
                
             </div>
         </div>
        </div>
        </div>
                <hr class="featurette-divider">
                <div>
                  <label for="profiePic">File input (Image)</label>
                    <input type="file" id="profiePic">
                    <p class="help-block">Upload a Profile Pic</p>
                    </div>
                </div>
        
        <!-- Student's Courses -->
        <div class="col-md-6" style="padding-right:20px; border-right: 1px solid #ccc;border-left: 1px solid #ccc;">hi
        <h3 style="color:#E80C3F;">{GET student name}'s Courses</h3>
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
            
            
              <div class="row">
         <div class="col-xs-6">
          <div class="thumbnail" id="target_3" style="cursor: pointer;">
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
          <div class="thumbnail" id="target_2" style="cursor: pointer;">
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
        
        <!-- Recommended courses and internship -->
        <div class="col-md-3">
            <h3 style="color:#E80C3F;">RECOMMENDED</h3>
           <div class="row">
         <div class="pull-right" style="padding-left:20px;padding-top: 20px;">
          <div class="thumbnail" id="target_1" style="cursor: pointer;" >
            
              <div class="caption">
           <h3>Get Internship Title</h3>
           <p>Over Here get Internship Info</p>
            <!-- get Company University Name-->      
          
           <a href="">get email</a>
             <p><b>get Ending Date</b></p>
             <p><b>Get starting Date as Last day to submit</b></p>
          
         </div>
            </div>
             
         </div>
          </div>
                 <div class="row" >
         <div class="pull-right" style="padding-left:20px;padding-top: 20px;">
             <div id="target" class="thumbnail" style="cursor: pointer;" >
            
              <div class="caption">
           <h3>Get Internship Title</h3>
           <p>Over Here get Internship Info</p>
            <!-- get Company University Name-->      
          
           <a href="">get email</a>
             <p><b>get Ending Date</b></p>
             <p><b>Get starting Date as Last day to submit</b></p>
         
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
        <script type='text/javascript'>
        
        $(document).ready(function() {
        $( "#target" ).click(function() {
         alert( "id=target" );
        });
        
         $( "#target_1" ).click(function() {
         alert( "id=target_1" );
        });
         $( "#target_2" ).click(function() {
         alert( "id=target_2" );
        });
         $( "#target_3" ).click(function() {
         alert( "id=target_3" );
        });
         $( "#target_4" ).click(function() {
         alert( "id=target_4" );
        });
        
         $( "#target_5" ).click(function() {
         alert( "id=target_5" );
        });
        
        });
        
        </script>
        </body>
</html>
