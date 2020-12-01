package homework4.dao.impl;

import homework4.dao.CategoryDAO;
import homework4.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Category> findALL() {
        return entityManager.createQuery("FROM Category", Category.class).getResultList();
    }

    @Override
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void update(Category category) {
entityManager.merge(category);
    }

    @Override
    public void delete(Category category) {
entityManager.remove(category);
    }
}
