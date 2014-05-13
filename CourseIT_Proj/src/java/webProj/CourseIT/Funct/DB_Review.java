/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.List;
import webProj.CourseIT.Beans.Review;

/**
 *
 * @author Talal Saleem
 */
public class DB_Review {
    
    public void AddReview(int userid, int courseid, String review){
        //Bean class main nayay review kay UV automatically 0 set ho jatay hain, dont need to do it here
        
        
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
