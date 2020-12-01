package homework4.repositories;

import homework4.data.ArticleData;
import homework4.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleDataRepository extends JpaRepository<Article, Long> {
    Optional<ArticleData> findOneById(Long id);
}
