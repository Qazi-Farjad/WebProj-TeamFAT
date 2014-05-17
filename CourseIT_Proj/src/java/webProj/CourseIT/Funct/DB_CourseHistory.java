/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import webProj.CourseIT.Beans.Courseenroll;
import webProj.CourseIT.Beans.Coursehistory;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 */
public class DB_CourseHistory {
    
    public List<Coursehistory> getCourseHistory(int userid){
          List<Coursehistory> ce = null;
        Session session=getSession();
        session.beginTransaction();
        
        Useraccinfo u = new Useraccinfo();
        u.setUserId(userid);
         
        Query query = session.getNamedQuery("Coursehistory.findByUserid");
        query.setParameter("userid", u);
            
              ce =  query.list();
            if(!ce.isEmpty()){
            session.getTransaction().commit();  
            session.close(); 
            return ce;
            }

        session.getTransaction().commit();  
         session.close(); 
          //return null when no result is found
        return null;
    }
    
    //I assume we are setting CourseHistory through triggers?
    //We should resolve data setting functions for this later.
    
}
