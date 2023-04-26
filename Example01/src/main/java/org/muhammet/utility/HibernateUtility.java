
package org.muhammet.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.muhammet.entity.Post;
import org.muhammet.entity.User;


public class HibernateUtility {

    private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();



    private static SessionFactory sessionFactoryHibernate() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Post.class);

            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}

