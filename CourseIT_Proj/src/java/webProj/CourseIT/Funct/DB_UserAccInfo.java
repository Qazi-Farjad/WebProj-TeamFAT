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
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSessionA;

/**
 *
 * @author Talal Saleem
 */
public class DB_UserAccInfo {
       private static SessionFactory factory;
       
       public static void main(String []args){
       DB_UserAccInfo d =  new DB_UserAccInfo();
       d.CheckUser("t@h.com", "a1");
       }
       
          /* Method to CREATE an employee in the database */
   public Integer CheckUser(String email, String password){
       int id =0;
      Session session=getSessionA();
      session.beginTransaction();
      Query query = session.getNamedQuery("Useraccinfo.findByPassword");
              query.setParameter("password", password);
            List<Useraccinfo> results = query.list(); 
            System.out.println("hello");
              System.out.println(results.get(0));
              for(Useraccinfo result : results)  
                {  
                     System.out.println(result.getName());  
                }  
        
      
        session.getTransaction().commit();  
        session.close(); 
      
      return id;
   }
    
}
