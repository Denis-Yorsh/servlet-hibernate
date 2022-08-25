package Servlets;

import Pojo.CarShopHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String stringSerialNumber = request.getParameter("serialNumber");
        int serialNumber = Integer.parseInt(stringSerialNumber);
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String equipment = request.getParameter("equipment");
        String stringPrice = request.getParameter("price");
        int price = Integer.parseInt(stringPrice);

        CarShopHibernate carShop = new CarShopHibernate(
                serialNumber,
                brand,
                color,
                equipment,
                price);

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(CarShopHibernate.class);
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
        Session sessionCreate = sessionFactory.openSession();
        Transaction transactionCreat = sessionCreate.beginTransaction();

        sessionCreate.save(carShop);

        transactionCreat.commit();
        sessionCreate.close();

        out.close();
    }
}
