package ProductShop;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
        return productRepository.findAll();
    }
    public void display(){
        String str = String.valueOf(getProductList());

        System.out.println(str);
    }
    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

    public Product intoBasket(int id){
        return productRepository.removeProduct(id);

    }
}
