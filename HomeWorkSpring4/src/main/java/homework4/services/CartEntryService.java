package homework4.services;

import homework4.entity.Cart;
import homework4.entity.CartEntry;
import homework4.entity.Product;

import java.util.List;

public interface CartEntryService {

    CartEntry get(Long id);
    List<CartEntry> getAll();
    void save(CartEntry cartEntry);
    void remove(CartEntry cartEntry);
    CartEntry addProduct(Cart cart, Product product, Integer quantity);
}
