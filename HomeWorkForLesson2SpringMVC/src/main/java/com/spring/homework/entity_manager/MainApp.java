package com.spring.homework.entity_manager;

import com.spring.homework.entity.Customer;
import com.spring.homework.entity.ProductData;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        EntityManager em = factory.createEntityManager();
        try {


            em.getTransaction().begin();
           ProductData productData = new ProductData("orange", "orange","OrangeHouse", 100 );
            em.persist(productData);
            em.getTransaction().commit();

           //Customer customerFromDb = em.find(Customer.class, newCustomer.getId());
           //System.out.println(customerFromDb);
            String queryString = "SELECT p FROM ProductData p";
            TypedQuery<ProductData> typedQuery = em.createQuery(queryString, ProductData.class);
            List<ProductData> productDataList = typedQuery.getResultList();
            System.out.println(productDataList);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
