package example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDAO {

    private SessionFactory sessionFactory;

    // Constructor
    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ADD PRODUCT
    public void addProduct(Product product) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            session.persist(product);

            transaction.commit();

            System.out.println("Product added successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // VIEW PRODUCTS
    public void viewProducts() {

        try (Session session = sessionFactory.openSession()) {

            List<Product> products =
                    session.createQuery(
                            "FROM Product",
                            Product.class
                    ).getResultList();

            System.out.println();
            System.out.println("----- PRODUCT INVENTORY -----");

            for (Product product : products) {
                System.out.println(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE PRODUCT
    public void updateProduct(Product product) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            session.merge(product);

            transaction.commit();

            System.out.println("Product updated successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE PRODUCT
    public void deleteProduct(int id) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            Product product = session.get(Product.class, id);

            if (product != null) {

                session.remove(product);

                System.out.println("Product deleted successfully!");

            } else {

                System.out.println("Product not found!");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}