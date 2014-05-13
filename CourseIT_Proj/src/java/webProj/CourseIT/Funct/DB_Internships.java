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
import org.hibernate.SessionFactory;
import webProj.CourseIT.Beans.Internships;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 */
public class DB_Internships {
    
     private static SessionFactory factory;
       
       public static void main(String []args){
       DB_Internships a = new DB_Internships();
      Date date = new Date();
      
           a.AddInternship("ammar", "EE", "12bee", "EECS",date, date);
       }
    public void AddInternship(String submitter, String info, String email,
                              String relatedField, Date duration, Date StartingDate){
        
        Session session=getSession();
        session.beginTransaction();
        
        Internships internship = new Internships(submitter,info,email,relatedField,duration,StartingDate);
        session.save(internship);
        
         session.getTransaction().commit();  
         session.close(); 
        
    
    }
    
    public List<Internships> getInternshipsByField(String relatedField){
        List<Internships> ints = null;
        Session session=getSession();
        session.beginTransaction();
        
         Query query = session.getNamedQuery("Useraccinfo.findByRelatedField");
           query.setParameter("relatedField", relatedField);
            ints =  query.list();
            if(!ints.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ints;
            }
        
        
        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return null;
    }
    
    
    public List<Internships> getInternshipsBySubmitter(String submitter){
        List<Internships> ints = null;
        Session session=getSession();
        session.beginTransaction();
        
         Query query = session.getNamedQuery("Useraccinfo.findBySubmitter");
           query.setParameter("submitter", submitter);
            ints =  query.list();
            if(!ints.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ints;
            }
        
        
        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return null;
    }
    
}
