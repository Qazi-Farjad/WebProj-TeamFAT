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
       
       }
       
          /* Method to verify User Email and Password*/
          
          //-------------------------------------------
          //Please make this Method return user_id from the db, Mujhay servlet main yeh chahiye hoga
          //--------------------------------------------
   public Integer CheckUser(String email, String password){
       int id =0;
      Session session=getSession();
      session.beginTransaction();
      Query query = session.getNamedQuery("Useraccinfo.findByPasswordAndEmail");
              query.setParameter("password", password);
              query.setParameter("email", email);
            List<Useraccinfo> results = query.list(); 
            
            System.out.println("hello");
              System.out.println(query);
              for(Useraccinfo result : results)  
                {  
                     System.out.println(result.getName());  
                     System.out.println(result.getEmail()); 
                     return result.getUserId();
                }  
        
      
        session.getTransaction().commit();  
        session.close(); 
      
      return null;
   }
   
    //Add a New User to the database
   public void AddNewUser (String name, String email,String password){
       Session session=getSession();
        session.beginTransaction();
        
        Useraccinfo user = new Useraccinfo(name,email,password);
        session.save(user);
        
        
        
        
         session.getTransaction().commit();  
        session.close(); 
       
   }
    


//We need functionality to add user pictures, magar upload wala scene dekhna paray ga.
//Abhi to this function takes only String picPosition

//Most probably servlet say pic store karwain gay aur phir is funct ko call karkay picture ki filesystem main path
//database main dalain gay.

//Is path ko database main add karnay ki functionality daal do
    public void AddUserPic(int userid, String picPath){
               
    }
        
        
//Funct: GetUserData
//Need this function to get the users data for profile and other stuff.

    public Useraccinfo getUserData(int userid){
        Useraccinfo u = null;
              
              
        return u;
       }
        
}