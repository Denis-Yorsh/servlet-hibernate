package com.servlet.hibernate.HibernateTest;

import com.servlet.hibernate.Pojo.CarShopHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SaveTest {

    public static void main(String[] args) {

        CarShopHibernate carShop = new CarShopHibernate(
                76574657,
                "BMV",
                "Blue",
                "Full",
                6400);

        Configuration configurationTest = new Configuration().configure();
        configurationTest.addAnnotatedClass(CarShopHibernate.class);
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configurationTest.getProperties());
        SessionFactory sessionFactory = configurationTest.buildSessionFactory(registryBuilder.build());
        Session sessionCreate = sessionFactory.openSession();
        Transaction transactionCreat = sessionCreate.beginTransaction();

        sessionCreate.save(carShop);

        transactionCreat.commit();
        sessionCreate.close();
    }
}
