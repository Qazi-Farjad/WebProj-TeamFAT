/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import webProj.CourseIT.Beans.Courses;
import webProj.CourseIT.Beans.Review;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 */
public class DB_Review {
    
      public static void main(String []args){
       DB_Review d =  new DB_Review();
       
       d.getReviews(1);
    }
    
    public void AddReview(Integer userid , Integer courseid, String review){
        //Bean class main nayay review kay UV automatically 0 set ho jatay hain, dont need to do it here
        Session session=getSession();
        session.beginTransaction();
        
        Review r = new Review(review);
        Query query = session.getNamedQuery("Useraccinfo.findByUserId");
        query.setParameter("userId", userid);
        List<Useraccinfo> result = query.list();
        if(!result.isEmpty()){
              for(Useraccinfo resul : result)  
                {  
                  r.setUserId(resul);
                }  
               }
        Query query1 = session.getNamedQuery("Courses.findByCourseID");
        query1.setParameter("courseID", courseid);
        List<Courses> result1 = query1.list();
        if(!result.isEmpty()){
              for(Courses resul : result1)  
                {  
                  r.setCourseID(resul);
                }  
               }
        
        
        session.saveOrUpdate(r);
        session.getTransaction().commit();  
        session.close();
        
        
        
    }
    
    //rid has to come in. how we would be referencing to the particular review
    public void IncrementUV(Integer rid){
        //no return types, nothing comes in.
        //POSSIBLE PROBLEM: We are not tracking which user has upvoted which review.
        //Yani aik banda beth kar million upvotes mar sakta hai... 
        Session session=getSession();
              session.beginTransaction();
             
              Query query = session.getNamedQuery("Review.findByRid");
              query.setParameter("rid", rid);
               List<Review> results = query.list(); 
               if(!results.isEmpty()){
                    for(Review result : results)  
                    {  
                        int  increment = result.getReviewUV();
                        increment++;
                        result.setReviewUV(increment);
                         session.getTransaction().commit();  
                         session.close();
                     return;
                    }  

               }
               session.getTransaction().commit();  
              session.close();
               //return null when no result is found
            return;
    }
    
    
    //Get all reviews for a given course. Agar number of UV kay hisab say sort kar do List main hi, to 
    //aagay thori asaani hogi.
    //Prbolem: reflection wala error
    public List<Review> getReviews(int courseid){
        List<Review> revs = null;
        Session session=getSession();
        session.beginTransaction();
        
        Courses c = new Courses();
        c.setCourseID(courseid);
         
        Query query = session.getNamedQuery("Review.findByCourseid");
        query.setParameter("courseid", c);
            
        revs =  query.list();
            if(!revs.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return revs;
            }

        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return revs;
    }
    
}
