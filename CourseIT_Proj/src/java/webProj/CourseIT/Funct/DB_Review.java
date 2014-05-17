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
       
       d.AddReview(1, 1, "Hello World");
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
    
    public void IncrementUV(){
        //no return types, nothing comes in.
        //POSSIBLE PROBLEM: We are not tracking which user has upvoted which review.
        //Yani aik banda beth kar million upvotes mar sakta hai... 
    }
    
    
    //Get all reviews for a given course. Agar number of UV kay hisab say sort kar do List main hi, to 
    //aagay thori asaani hogi.
    public List<Review> getReviews(int courseid){
        List<Review> revs = null;
        
        return revs;
    }
    
}
