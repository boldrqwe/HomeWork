package homework4.services.impl;

import homework4.entity.Cart;
import homework4.entity.CartEntry;
import homework4.entity.Product;
import homework4.repositories.CartEntryRepository;
import homework4.services.CartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service("cartEntryService")
public class CartEntryServiceImpl implements CartEntryService {

    private CartEntryRepository cartEntryRepository;


    @Autowired
    public void setCartEntryRepository(CartEntryRepository cartEntryRepository) {
        this.cartEntryRepository = cartEntryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CartEntry get(Long id) {
        return cartEntryRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartEntry> getAll() {
        return cartEntryRepository.findAll();
    }

    @Override
    @Transactional
    public void save(CartEntry cartEntry) {
        cartEntryRepository.save(cartEntry);
    }

    @Override
    @Transactional
    public void remove(CartEntry cartEntry) {
        cartEntryRepository.delete(cartEntry);
    }

    @Override
    @Transactional
    public CartEntry addProduct(Cart cart, Product product, Integer quantity){
        CartEntry cartEntry = new CartEntry();
        cartEntry.setCart(cart);
        cartEntry.setPrice(product.getPrice());
        cartEntry.setProduct(product);
        cartEntry.setQuantity(quantity);
        return cartEntryRepository.save(cartEntry);
    }

  
}
