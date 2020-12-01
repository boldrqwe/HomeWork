package homework4.dao;

import homework4.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findALL();
    void save(Category category);
    Category findById(Long id);
    void update(Category category);
    void delete(Category category);
}
