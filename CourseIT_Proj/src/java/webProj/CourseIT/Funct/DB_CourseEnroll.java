/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import webProj.CourseIT.Beans.Courseenroll;
import webProj.CourseIT.Beans.Courses;
import webProj.CourseIT.Beans.Review;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 * @author Qazi Farjad
 */
public class DB_CourseEnroll {
    
    public static void main(String []args){
       DB_CourseEnroll d =  new DB_CourseEnroll();
       
      d.getEnrollmentbyUser(1);
    }
    
    public void setEnrollment(int userid, int courseid){
         Session session=getSession();
        session.beginTransaction();
        
        Courseenroll c = new Courseenroll();
        Query query = session.getNamedQuery("Useraccinfo.findByUserId");
        query.setParameter("userId", userid);
        List<Useraccinfo> result = query.list();
        if(!result.isEmpty()){
              for(Useraccinfo resul : result)  
                {  
                  c.setUserId(resul);
                }  
               }
        Query query1 = session.getNamedQuery("Courses.findByCourseID");
        query1.setParameter("courseID", courseid);
        List<Courses> result1 = query1.list();
        if(!result.isEmpty()){
              for(Courses resul : result1)  
                {  
                  c.setCourseID(resul);
                }  
               }
        
        
        session.saveOrUpdate(c);
        session.getTransaction().commit();  
        session.close();
        
        
        
        
        
    }    
    
    //------------------------------
    
    public List<Courseenroll> getEnrollmentbyUser(int userid){
          List<Courseenroll> ce = null;
        Session session=getSession();
        session.beginTransaction();
        
        Useraccinfo u = new Useraccinfo();
        u.setUserId(userid);
         
        Query query = session.getNamedQuery("Courseenroll.findByUserid");
        query.setParameter("userid", u);
            
        ce =  query.list();
            if(!ce.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ce;
            }

        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return null;
    }
    
    public List<Courseenroll> getEnrollmentbyCourse(int courseid){
        List<Courseenroll> ce = null;
        Session session=getSession();
        session.beginTransaction();
        
        Courses c = new Courses();
        c.setCourseID(courseid);
         
        Query query = session.getNamedQuery("Courseenroll.findByCourseid");
        query.setParameter("courseid", c);
            
        ce =  query.list();
            if(!ce.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ce;
            }

        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return null;
        
       
    }
    
    
}
