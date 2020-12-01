package homework4.repositories;

import homework4.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlePaginationRepository extends PagingAndSortingRepository<Article, Long> {
}
