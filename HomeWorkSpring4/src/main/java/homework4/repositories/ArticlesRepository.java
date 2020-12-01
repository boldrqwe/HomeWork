package homework4.repositories;

import homework4.entity.Article;
import homework4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitle(String title);
    Article findOneByTitle(String title);

    @Query("select a from Article a where a.user = :user")
    List<Article> findArticleByUser(@Param("user") User user);
}
