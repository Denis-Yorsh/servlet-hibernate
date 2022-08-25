package com.servlet.hibernate.HibernateTest;

import org.hibernate.Session;

public class ConfigurationTest {

    public static void main(String[] args) {

        Session session = ConfigurationHibernate.getSessionFactory().openSession();
        session.close();
        ConfigurationHibernate.shutdown();
    }
}
