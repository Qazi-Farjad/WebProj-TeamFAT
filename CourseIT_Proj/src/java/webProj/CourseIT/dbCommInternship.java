/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT;

//import java.awt.print.Book; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import webProj.CourseIT.Beans.InternshipsBean;

/**
 *
 * @author Farjad
 */
public class dbCommInternship {
    private static SessionFactory factory;
    
    public Integer addInternshipListing(String submitter, String info){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer bkID = null;
      try{
         tx = session.beginTransaction();
         //Constructor not yet Implemented. Mapping Ni hui abhi Tak.
         InternshipsBean ib = new InternshipsBean(submitter, info);
         bkID = (Integer) session.save(ib); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return bkID;
   }
    
    public void deleteInternshipListing(Integer bkID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         InternshipsBean ib = (InternshipsBean)session.get(InternshipsBean.class, bkID); 
         session.delete(ib); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
    }
}

