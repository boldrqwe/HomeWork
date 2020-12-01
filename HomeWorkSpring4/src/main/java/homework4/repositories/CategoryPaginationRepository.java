package homework4.repositories;

import homework4.entity.Article;
import homework4.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryPaginationRepository extends PagingAndSortingRepository<Category, Long> {
}
