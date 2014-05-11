/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT;


 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

//----------------------------- Local Import
import webProj.CourseIT.Beans.UserAccBean;

/**
 * Class used to connect to the database table: UserAccInfo
 * @author Farjad
 */
public class DB_CommUserAcc {
    private static SessionFactory factory;
 
    public DB_CommUserAcc(){}
    
    /**

    *   Gets userID, Users Name , email and Password, and inputs them in the database.
    *           
    *@author: Farjad
     * @param userid
     * @param username
     * @param email
     * @param pwd
     * @return String
    */
    public Integer addNewUser(String userid, String username , String email, String pwd){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer userID = null;
      try{
         tx = session.beginTransaction();
         //TODO: check if UserID exists, check if Username exists, Sterilize pwd before input
         //      check 'email' for validity.
         UserAccBean newUser = new UserAccBean(userid, username, email, pwd);
         userID = (Integer) session.save(newUser); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return userID;
    }
    
    /**
     * @param UserID
     * @param password
     * 
    *   Gets UserName and Password, and check against database to see if user exists.
    *           
    *@author: Farjad
     * @return boolean
    */    
    public boolean checkIfUserExists(String UserID, String password){
        Session session = factory.openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            /*Sasta kaam hai yahan, possible source of problems. 
            * UserID ki existence check ni ho rahi yahan par,
            * sirf password ki*/
            
            UserAccBean user = (UserAccBean)session.get(UserAccBean.class, UserID);
            if(!password.equals(user.getPwd())){
                session.close();
                return false;
            }
        }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
        }finally {
         session.close(); 
        }
        
        
        //----------------------------
        return true;
    }
}
