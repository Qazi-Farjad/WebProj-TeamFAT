/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.List;
import java.util.Vector;
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
       List<Courses> course = d.getEnrollmentbyUser(7);

    }
    
    public void setEnrollment(int userid, int courseid){
         Session session=getSession();
        session.beginTransaction();
        
      Query q = session.getNamedQuery("Courseenroll.findByfollow");
      q.setParameter("userid",userid);
      q.setParameter("courseID", courseid);
      List<Courseenroll> res = q.list();
      if(!res.isEmpty()){
          session.getTransaction().commit();  
            session.close();
      }
      
      else{
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
        
        
        
    }    
    
    //------------------------------
    
       public List<Courses> getEnrollmentbyUser(int userid){
         List<Courses> UserCourse = new  Vector<Courses>();
        Session session=getSession();
        session.beginTransaction();
        
        Useraccinfo u = new Useraccinfo();
        u.setUserId(userid);
         
        Query query = session.getNamedQuery("Courseenroll.findByUserid");
        query.setParameter("userid", u);
         List<Courseenroll> results = query.list(); 
            if(!results.isEmpty()){
                  for(Courseenroll result : results)  {  
                     
                    Courses j = result.getCourseID();
                    int x = j.getCourseID();
                     query = session.getNamedQuery("Courses.findByCourseID");
                     query.setParameter("courseID", x );
                    List<Courses> Course = query.list();
                    
                       if(!Course.isEmpty()){
                         Courses c = Course.get(0);
                        UserCourse.add(c);
                  
                       }
                       else
                       {
                           session.getTransaction().commit();  
                           session.close();
                           return UserCourse;
                       }
                  }      
            }

        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return UserCourse;
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
        return ce;
        
       
    }
    
    
}
