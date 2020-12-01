package homework4.services;

import homework4.entity.Product;

import java.util.List;

public interface ProductService {

    Product get(Long id);
    List<Product> getAll();
    void save(Product product);
    void remove(Product product);
    Product findByName(String name);
    List<Product> findAllByPriceGreaterThan(Double price);
    List<Product> findAllByPriceGreaterThanOrderByPriceDesc(Double price);

}
