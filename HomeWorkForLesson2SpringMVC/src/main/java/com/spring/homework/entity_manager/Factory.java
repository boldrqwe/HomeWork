package com.spring.homework.entity_manager;

import com.spring.homework.entity.Customer;
import com.spring.homework.entity.ProductData;
import com.spring.homework.model.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class Factory {




        public void save(Product product) {
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

    public static void main(String[] args) {
        EntityManager em = null;
        try {

            EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            em = factory.createEntityManager();

            ProductData newProduct = new ProductData("апельсин", "орнажевый", "апельсиновый дом", 100);
            em.getTransaction().begin();
            em.persist(newProduct);
            em.getTransaction().commit();
        }finally {
            if(em != null) {
                em.close();
            }
        }
    }
}
