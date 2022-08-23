package com.hexaware.hibernateexampleusingjavaconfig.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hexaware.hibernateexampleusingjavaconfig.entity.Student;

public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
            	
            	Configuration cfg = new Configuration();
            	
            	//hibernate setting equivalent to hibernate.cfg.xml file
            	Properties dbSettings = new Properties();
            	dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            	dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/sample?useSSL=false");
            	dbSettings.put(Environment.USER,"root");
            	dbSettings.put(Environment.PASS,"Password123");
            	dbSettings.put(Environment.SHOW_SQL,"true");
            	dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
            	dbSettings.put(Environment.HBM2DDL_AUTO,"create");
            	cfg.setProperties(dbSettings);
            	cfg.addAnnotatedClass(Student.class);
            	ServiceRegistry registry = new StandardServiceRegistryBuilder()
            								.applySettings(cfg.getProperties()).build();
            	sessionFactory = cfg.buildSessionFactory(registry);
               

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}
