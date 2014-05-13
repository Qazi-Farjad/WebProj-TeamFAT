/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package webProj.CourseIT.Funct;


import java.util.Date;
import java.util.Iterator; 
import java.util.List; 
import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import webProj.CourseIT.Beans.Useracademicinfo;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 */
public class DB_UserAccInfo {
       private static SessionFactory factory;
       
       public static void main(String []args){
       DB_UserAccInfo d =  new DB_UserAccInfo();
       d.CheckUser("a@h.com", "b1");
       d.AddNewUser("talalwtf", "b2wtfcomxx", "c1wtfxx");
       }
       
          /* Method to verify User Email and Password*/
          
          //-------------------------------------------
          //Please make this Method return user_id from the db, Mujhay servlet main yeh chahiye hoga
          //--------------------------------------------
     public Integer CheckUser(String email, String password){
      Session session=getSession();
      session.beginTransaction();
      Query query = session.getNamedQuery("Useraccinfo.findByPasswordAndEmail");
              query.setParameter("password", password);
              query.setParameter("email", email);
            List<Useraccinfo> results = query.list(); 
            
               if(!results.isEmpty()){
              for(Useraccinfo result : results)  
                {  
                     session.getTransaction().commit();  
                      session.close();
                     return result.getUserId();
                }  
               }
       session.getTransaction().commit();  
        session.close();
      //return null when no result is found
      return null;
   }
   
    //Add a New User to the database
   public void AddNewUser (String name, String email,String password){
       Session session=getSession();
        session.beginTransaction();
        
        Useraccinfo user = new Useraccinfo(name,email,password);      
        session.saveOrUpdate(user);
          
        session.getTransaction().commit();  
        session.close(); 
       
   }
    


//We need functionality to add user pictures, magar upload wala scene dekhna paray ga.
//Abhi to this function takes only String picPosition

//Most probably servlet say pic store karwain gay aur phir is funct ko call karkay picture ki filesystem main path
//database main dalain gay.

//Is path ko database main add karnay ki functionality daal do
     public void AddUserPic (int userid, String picPath){
        Session session=getSession();
        session.beginTransaction();
             
             Query query = session.getNamedQuery("Useraccinfo.UpdateUserPic");
              query.setParameter("picPath", picPath);
              query.setParameter("userid", userid);
              query.executeUpdate();
                
        session.getTransaction().commit();  
        session.close(); 
        }
        
        
//Funct: GetUserData
//Need this function to get the users data for profile and other stuff.

   public Useraccinfo getUserData(int userid){
             
              Session session=getSession();
              session.beginTransaction();
             
              Query query = session.getNamedQuery("Useraccinfo.findByUserId");
              query.setParameter("userId", userid);
               List<Useraccinfo> results = query.list(); 
               if(!results.isEmpty()){
                    for(Useraccinfo result : results)  
                    {  
                         System.out.println(result.getName());  
                         System.out.println(result.getEmail());
                         Useraccinfo u = new Useraccinfo(result.getName(),result.getEmail(),result.getPassword());
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
}
        
