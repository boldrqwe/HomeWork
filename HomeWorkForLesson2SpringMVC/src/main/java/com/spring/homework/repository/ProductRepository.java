package com.spring.homework.repository;

import com.spring.homework.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "apple", "green apple, tasty", "AppleHouse", 10));
        this.products.add(new Product(2L, "orange", " orange, tasty", "OrangeHouse", 12));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product saveOrUpdate(Product product) {
        if (product.getId() == null) {
            product.setId(products.size() + 1L);
            products.add(product);
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

    public Product findByID(Long id){
        for (Product product: products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }

}
