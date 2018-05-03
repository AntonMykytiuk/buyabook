package ua.singleton.buyabook.dao;

import org.springframework.stereotype.Repository;
import ua.singleton.buyabook.model.Category;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public Category getCategoryById(long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void removeCategoryById(long id) {

    }
}
