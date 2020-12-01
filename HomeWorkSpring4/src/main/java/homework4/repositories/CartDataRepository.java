package homework4.repositories;

import homework4.data.CartData;
import homework4.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDataRepository extends JpaRepository<Cart, Long> {

    @Query("select new homework4.data.CartData(c) from Cart c JOIN c.user u where  c.code = :code")
    CartData findByCode(@Param("code") String code);
}
