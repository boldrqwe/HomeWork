package homework4.repositories;

import homework4.entity.Cart;
import homework4.entity.Product;
import homework4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByCode(String code);

    @Query("SELECT c FROM Cart c WHERE c.user =: user")
    Cart findCartByUser(@Param("user") User user);

    @Query("SELECT c FROM Cart c JOIN c.cartEntryList ce WHERE ce.product = :product ")
    List<Cart> findAllCartsByProduct(@Param("product")Product product);
}
