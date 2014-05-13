/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.Funct;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import webProj.CourseIT.Beans.Useracademicinfo;
import webProj.CourseIT.Beans.Useraccinfo;
import static webProj.CourseIT.util.HibernateUtil.getSession;

/**
 *
 * @author Talal Saleem
 */
public class DB_UserAcademicinfo {
    
    //Single function, ez pz
    public void AddAcadInfo(int userid, String uni, String school, String degree){
        Session session=getSession();
        session.beginTransaction();
        
        Useracademicinfo user = new Useracademicinfo(userid,uni,school,degree);      

        
        Query query = session.getNamedQuery("Useraccinfo.findByUserId");
        query.setParameter("userId", userid);
        List<Useraccinfo> result = query.list();
        
        if(!result.isEmpty()){
              for(Useraccinfo resul : result)  
                {  
                    user.setUseraccinfo(resul);
                }  
               }
        session.saveOrUpdate(user);
        
        
        
        session.getTransaction().commit();  
        session.close();
        
        
    }
    
    
    //--------------------------------
    public static void main(String []args){
       DB_UserAcademicinfo d =  new DB_UserAcademicinfo();
       
       d.AddAcadInfo(4, "talalwtf", "b2wtfcomxx", "c1wtfxx");
    }
    
    
    
}
