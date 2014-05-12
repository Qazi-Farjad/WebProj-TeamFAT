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
/**
 *
 * @author Talal Saleem
 */
public class DB_UserAccInfo {
       private static SessionFactory factory;
       
       
          /* Method to CREATE an employee in the database */
   public Integer CheckUser(String email, String password){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer userID = null;
      try{
         tx = session.beginTransaction();
      Useraccinfo u =  new Useraccinfo();
      Query query = session.getNamedQuery("Useraccinfo.findByEmail");
              query.setParameter("email", email);
              int id = query
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return userID;
   }
    
}
