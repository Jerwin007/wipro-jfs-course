package example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainProgram {

    public static void main(String[] args) {

        System.out.println("Program started...");

        SessionFactory sessionFactory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();

        System.out.println("Hibernate connected successfully!");

        ProductDAO dao = new ProductDAO(sessionFactory);

        Product product = new Product(
                101,
                "Laptop",
                "Electronics",
                55000.00,
                10
        );

        dao.addProduct(product);
        dao.viewProducts();

        sessionFactory.close();
        System.out.println("URK23CS1067");
        
        System.out.println("Program completed successfully!");
    }
}