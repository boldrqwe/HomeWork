package homework4.dao.impl;

import homework4.dao.ArticleDAO;
import homework4.entity.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("articleDAO")
public class DefaultArticleDAO implements ArticleDAO {

    @PersistenceContext
    @Qualifier("entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<Article> findAll() {
        return entityManager.createQuery("from Article", Article.class).getResultList();
    }

    @Override
    public void save(Article article) {
        entityManager.persist(article);
    }

    @Override
    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    @Override
    public void update(Article article) {
        entityManager.merge(article);
    }

    @Override
    public void delete(Article article) {
        entityManager.remove(article);
    }

}
