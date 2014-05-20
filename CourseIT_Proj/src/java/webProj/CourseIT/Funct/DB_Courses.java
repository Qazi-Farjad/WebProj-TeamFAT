/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import webProj.CourseIT.Beans.Courses;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 */
public class DB_Courses {

    
      public static void main(String []args){
       DB_Courses d =  new DB_Courses();
       Date date = new Date();
       //d.addCourse("Web", "Qaisar", "Chutiya Co.", "Q@l.com",date, date);
       Courses c = d.getCourse(1);
          System.out.println(c.getCourseName());
        //System.out.println( d.getDuration("Web"));
    }

    public void addCourse(String cname, String instructor, String sourceComp,
                         String sourceLink, Date expiryDate, Date startingDate){
              Session session=getSession();
              session.beginTransaction();
        
               Courses course = new Courses( cname,  instructor,  sourceComp,
                          sourceLink,  expiryDate,  startingDate);
               session.saveOrUpdate(course);
               
              
              session.getTransaction().commit();  
              session.close();
    }
    
    
    //Using cname as identifier for now. If you have an easily implementable way of using
    //course_id, do tell.
    public Courses getCourse(String cname){
        Courses c = null;
        Session session=getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Courses.findByCourseName");
        query.setParameter("courseName", cname);
        List<Courses> results = query.list(); 
               if(!results.isEmpty()){
                    for(Courses result : results)  
                    {  
                         Courses u = new Courses(result.getCourseName(),result.getInstructor(),result.getSourceCompany()
                                 ,result.getSourceLink(),result.getExpiryDate(),result.getStartingDate());
                         session.getTransaction().commit();  
                         session.close();
                         return u;
                    }  

               }
               session.getTransaction().commit();  
              session.close();
               //return null when no result is found
              return null;
    }
    
    //getCourse by courseID (Overloaded Funct)
    public Courses getCourse(int cid){
        Courses c = null;
        Session session=getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Courses.findByCourseID");
        query.setParameter("courseID", cid);
        List<Courses> results = query.list(); 
               if(!results.isEmpty()){
                    for(Courses result : results)  
                    {  
                         Courses u = new Courses(result.getCourseName(),result.getInstructor(),result.getSourceCompany()
                                 ,result.getSourceLink(),result.getExpiryDate(),result.getStartingDate());
                         session.getTransaction().commit();  
                         session.close();
                         return u;
                    }  

               }
               session.getTransaction().commit();  
              session.close();
               //return null when no result is found
              return null;
    }
    
    
    public int getDuration(String cname){
        Date d = null;
        Session session=getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Courses.findByCourseName");
        query.setParameter("courseName", cname);
       List<Courses> results = query.list(); 
               if(!results.isEmpty()){
                    for(Courses result : results)  
                    {  
                         Courses u = new Courses(result.getCourseName(),result.getInstructor(),result.getSourceCompany()
                                 ,result.getSourceLink(),result.getExpiryDate(),result.getStartingDate());
                         
                         long a = u.getExpiryDate().getTime() - u.getStartingDate().getTime();
                         int diffinday = (int) a / (1000 * 60 * 60 * 24);
                         session.getTransaction().commit();  
                         session.close();
                         return diffinday;
                    }  

               }
               session.getTransaction().commit();  
              session.close();
               //return null when no result is found
              return 0;
    }
    //------------------------------------------------------------------
    //Below this will be needed once we start adding additional functionalities.
    
    public List<Courses> getCoursesByInstructor(String instructor){
       List<Courses> ints = null;
        Session session=getSession();
        session.beginTransaction();
        
         Query query = session.getNamedQuery("Courses.findByInstructor");
           query.setParameter("instructor", instructor);
            ints =  query.list();
            if(!ints.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ints;
            }
        
        
        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return ints;
    }
    
    public List<Courses> getAllCourses(){
       List<Courses> ints = null;
        Session session=getSession();
        session.beginTransaction();
        
         Query query = session.getNamedQuery("Courses.findAll");
            ints =  query.list();
            if(!ints.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ints;
            }
        
        
        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return ints;
    }
    
    

    public List<Courses> getCoursesBySourceComp(String sourceComp){
              List<Courses> ints = null;
        Session session=getSession();
        session.beginTransaction();
        
         Query query = session.getNamedQuery("Courses.findBySourceCompany");
           query.setParameter("sourceCompany", sourceComp);
            ints =  query.list();
            if(!ints.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ints;
            }
        
        
        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return ints;
    }
    
    
    
}
