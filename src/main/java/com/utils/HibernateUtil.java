
package com.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.models.User;
import com.properties.Constants;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
         if (sessionFactory == null) {
            try {
                 Configuration configuration = new Configuration();
                 Properties settings = new Properties();
                 settings.put(Environment.DRIVER, Constants.DB_DRIVER);
                 settings.put(Environment.URL,Constants.DB_URL);
                 settings.put(Environment.USER, Constants.DB_USER);
                 settings.put(Environment.PASS, Constants.DB_PASS);
                 settings.put(Environment.DIALECT, Constants.DB_DIALECT);

                 settings.put(Environment.SHOW_SQL, Constants.SHOW_SQL);

                 settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, Constants.CURRENT_SESSION_CONTEXT_CLASS);

                 settings.put(Environment.HBM2DDL_AUTO, Constants.HBM2DDL_AUTO);
                 configuration.setProperties(settings);
                 configuration.addAnnotatedClass(User.class);

                 ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                 .applySettings(configuration.getProperties()).build();
                 System.out.println("Hibernate Java Config serviceRegistry created");
                 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                 return sessionFactory;

              } catch (Exception e) {
                 e.printStackTrace();
              }
          }
        return sessionFactory;
    }

}
