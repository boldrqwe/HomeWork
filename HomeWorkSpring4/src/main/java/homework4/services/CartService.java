package homework4.services;

import homework4.entity.Cart;
import homework4.entity.Product;
import homework4.entity.User;

import java.util.List;

public interface CartService{
    Cart get(Long id);
    Cart getByCode(String code);
    List<Cart> getAll();
    void save(Cart cart);
    void remove(Cart cart);

    Cart findCartByUser(User user);
    List<Cart> findAllCartsByProduct(Product product);
}
