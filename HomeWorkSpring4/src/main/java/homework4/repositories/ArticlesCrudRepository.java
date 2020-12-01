package homework4.repositories;

import homework4.entity.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesCrudRepository extends CrudRepository<Article, Long> {

}
