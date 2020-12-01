package homework4.repositories;

import homework4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaginationRepository extends JpaRepository<User, Long> {

}
