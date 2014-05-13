/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webProj.CourseIT.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Talal Saleem
 */
public class HibernateUtil {
	private static final SessionFactory concreteSessionFactory;
	    static {
	        try {
	            concreteSessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    public static Session getSession()
	            throws HibernateException {
	        return concreteSessionFactory.openSession();
	    }
}