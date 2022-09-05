package com.servlet.hibernate.HibernateUtil;

import com.servlet.hibernate.Pojo.CarShopHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestConnection {

    public static void main(String[] args) {

        SessionFactory sessionFactory = GetConnection.getSessionFactory();
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.commit();
//        transaction.rollback();

        try {

            session.beginTransaction();
            CarShopHibernate carShop = new CarShopHibernate(
                    99574657,
                    "BMV",
                    "Green",
                    "Full",
                    9400);
//            carShop.setDelete(false);

            session.save(carShop);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
