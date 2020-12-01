package homework4.main;

import homework4.config.AppConfig;
import homework4.dao.CategoryDAO;
import homework4.entity.Article;
import homework4.entity.Category;
import homework4.entity.Product;
import homework4.entity.User;
import homework4.repositories.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

       // ArticleDataRepository articleDataRepository = applicationContext.getBean("articleDataRepository", ArticleDataRepository.class);
        CategoryPaginationRepository categoryPaginationRepository = applicationContext. getBean("categoryPaginationRepository", CategoryPaginationRepository.class);

        CategoryRepository categoryRepository = applicationContext.getBean("categoryRepository", CategoryRepository.class);

//        articlesRepository.save(new Article("NEW title 1", new User("Alex")));
//        articlesRepository.save(new Article("NEW title 2", new User("Alex1")));
//        articlesRepository.save(new Article("NEW title 3", new User("Alex2")));
//        articlesRepository.save(new Article("NEW title 4", new User("Alex3")));
//        articlesRepository.save(new Article("NEW title 5", new User("Alex4")));
//        articlesRepository.save(new Article("NEW title 6", new User("Alex5")));
        List<Product> productList = new ArrayList<>();
        CategoryDAO categoryDAO = applicationContext.getBean("categoryDAO",CategoryDAO.class);
categoryDAO.save(new Category("Фрукты"));
        Pageable pageable = PageRequest.of(0,3);
        Page<Category> categoryPage = categoryPaginationRepository.findAll(pageable);
        System.out.println(categoryPage.getContent());
    }
}
