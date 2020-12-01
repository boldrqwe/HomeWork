package homework4.repositories;

import homework4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThanEqual(Double price);
    List<Product> findAllByPriceGreaterThanOrderByPriceDesc(Double price);
    Product findByName(String name);

}
