package com.spring.homework.repository;

import com.spring.homework.entity.ProductData;
import com.spring.homework.entity_manager.Factory;
import com.spring.homework.model.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    EntityManagerFactory factory;


    @PostConstruct
    public void init() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT p FROM ProductData p";
        TypedQuery<ProductData> typedQuery = em.createQuery(queryString, ProductData.class);
        List<ProductData> productData = typedQuery.getResultList();
        this.products = new ArrayList<>();
        for (int i = 0; i < productData.size(); i++) {
            products.add(new Product(productData.get(i).getId(),
                    productData.get(i).getTitle(),
                    productData.get(i).getDescription(),
                    productData.get(i).getBrand(),
                    productData.get(i).getPrice()));
        }
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product saveOrUpdate(Product product) {
        if (product.getId() == null) {
            Factory factory = new Factory();
            factory.save(product);
            this.init();
            return product;
        } else {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(product.getId())) {
                    products.set(i, product);

                    return product;
                }
            }
        }
        throw new RuntimeException("Error save or update customer");
    }

    public Product findByID(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }

}
