package homework4.main;

import homework4.config.AppConfig;
import homework4.entity.Cart;
import homework4.entity.Product;
import homework4.entity.User;
import homework4.services.CartEntryService;
import homework4.services.CartService;
import homework4.services.ProductService;
import homework4.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainCart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = applicationContext.getBean("cartService", CartService.class);
        CartEntryService cartEntryService = applicationContext.getBean("cartEntryService", CartEntryService.class);
        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);

        User user1 = new User("Alex");
        User user2 = new User("Alex1");

        userService.save(user1);
        userService.save(user2);

        Product product1 = new Product("Apple", 100l, 15.0);
        Product product2 = new Product("Apple2", 10l, 35.0);
        Product product3 = new Product("Apple3", 200l, 25.0);
        Product product4 = new Product("Lemon", 300l, 15.0);
        Product product5 = new Product("Apple5", 60l, 10.0);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);

        Cart cart1 =new Cart();
        cart1.setCode("0001");
        cart1.setUser(user1);
        cartService.save(cart1);

        Cart cart2 =new Cart();
        cart2.setCode("0002");
        cart2.setUser(user2);
        cartService.save(cart2);

        cartEntryService.addProduct(cart1, product1, 2);
        cartEntryService.addProduct(cart1, product2, 5);
        cartEntryService.addProduct(cart1, product3, 12);
        cartEntryService.addProduct(cart1, product4, 15);



        cartEntryService.addProduct(cart2, product4, 15);
        cartEntryService.addProduct(cart2, product5, 20);

        Cart cartAlex = cartService.getByCode("0001");
        System.out.println("cartAlex = "+cartAlex);

        List<Product> productList1 = productService.findAllByPriceGreaterThan(30.0);
        System.out.println(productList1);

        List<Product> productList2 = productService.findAllByPriceGreaterThanOrderByPriceDesc(25.0);
        System.out.println(productList2);

        Cart cartAlena = cartService.findCartByUser(user2);
        System.out.println("cart alena = " +cartAlena);

        Product product =productService.findByName("Lemon");

        List<Cart> carts = cartService.findAllCartsByProduct(product);
        System.out.println("carts = " +carts);
    }
}
