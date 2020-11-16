package ProductShop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartService {


    private List<Product> shopBasket = new ArrayList<Product>();

    public int totalCost() {
        int totalPrice = 0;
        for (Product price : shopBasket) {
            totalPrice += price.getPrice();
        }
        return totalPrice;
    }

    public void add(Product product) {
        shopBasket.add(product);
    }

    public void findAll() {
        System.out.println("в корзине");
        int count = 0;
        for (Product product : shopBasket) {
            System.out.println(++count + ": " + product.toString());
        }
    }

    public Product remove(int id) {
        Product findP;
        for (Product product : shopBasket) {
            if (product.getId() == id) {
                findP = product;
                shopBasket.remove(product);
                return findP;
            }
        }
        return null;
    }
}
