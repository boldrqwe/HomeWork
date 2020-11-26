package com.spring.homework.service;

import com.spring.homework.model.Product;
import com.spring.homework.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
private ProductRepository productRepository;

public List<Product> getAllProducts(){
    return productRepository.findAll();
}
public Product saveOrUpdate(Product product){
    return productRepository.saveOrUpdate(product);
}
public Product findById(Long id){
    return productRepository.findByID(id);
}
@Autowired
    public void setProductRepository(ProductRepository productRepository){
    this.productRepository = productRepository;
}

}
