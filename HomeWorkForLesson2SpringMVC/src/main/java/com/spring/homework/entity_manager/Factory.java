package com.spring.homework.entity_manager;

import com.spring.homework.entity.ProductData;
import com.spring.homework.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class Factory {


    public void saveProduct(Product product) {
        EntityManager em = null;
        try {
            ProductData productData = new ProductData(product.getTitle(),
                    product.getDescription(),
                    product.getBrand(),
                    product.getPrice());
            EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            em = factory.createEntityManager();

            em.getTransaction().begin();
            em.persist(productData);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateProduct(Product product) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update ProductData set title=:t, description=:d, brand=:b, price=:p where id=:i");
        q.setParameter("t", product.getTitle());
        q.setParameter("d", product.getDescription());
        q.setParameter("b", product.getBrand());
        q.setParameter("p", product.getPrice());
        q.setParameter("i", product.getId());
        q.executeUpdate();
        tx.commit();
    }


    public static void main(String[] args) {
//
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//        Session session = factory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        Query q = session.createQuery("update ProductData set title=:t, description=:d, brand=:b, price=:p where id=:i");
//        q.setParameter("t", "Udit Kumar");
//        q.setParameter("i", 4L);
//        q.executeUpdate();
//        tx.commit();
    }
}

