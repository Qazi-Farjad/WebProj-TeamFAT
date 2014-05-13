/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.Date;
import java.util.List;
import webProj.CourseIT.Beans.Courses;

/**
 *
 * @author Talal Saleem
 */
public class DB_Courses {


    public void addCourse(String cname, String instructor, String sourceComp,
                         String sourceLink, Date expiryDate, Date startingDate){
        
    
    }
    
    
    //Using cname as identifier for now. If you have an easily implementable way of using
    //course_id, do tell.
    public Courses getCourse(String cname){
        Courses c = null;
        
        return c;
    }
    
    public Date getDuration(String cname){
        Date d = null;
        
        
        
        return d;
    }
    //------------------------------------------------------------------
    //Below this will be needed once we start adding additional functionalities.
    
    public List<Courses> getCoursesByInstructor(String instructor){
        List<Courses> courses = null;
        
        return courses;
    }
    
    

    public List<Courses> getCoursesBySourceComp(String sourceComp){
        List<Courses> courses = null;
        
        return courses;
    }
    
    
    
}
