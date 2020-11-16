package ProductShop;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class ProductRepository {
   private List<Product> productList =  new ArrayList<Product>();


    public ProductRepository() {

    }
    @PostConstruct
    public void init(){
        addProduct(new Product(1,"apple",50));
        addProduct(new Product(2,"orange",60));
        addProduct(new Product(3,"banana",40));
        addProduct(new Product(4,"mango",140));
        addProduct(new Product(5,"avocado",150));
    }

    public List<Product> findAll(){
       return Collections.unmodifiableList(productList);
   }

   public Product findProduct(int id){
       for (Product product: productList)
            if(product.getId() == id) {
           return product;
       }
       return null;
   }
   public void addProduct(Product product){
       productList.add(product);
   }
   public Product removeProduct(int id){
        Product findP;
       for (Product product: productList)
           if(product.getId() == id) {
               findP= product;
               productList.remove(product);
               return findP;
           }
       return null;
   }
}
