package ua.singleton.buyabook.dao;

import ua.singleton.buyabook.model.Category;

import java.util.List;

public interface CategoryDao {
    Category getCategoryById(long id);
    List<Category> getAllCategories();
    void addCategory(Category category);
    void updateCategory(Category category);
    void removeCategoryById(long id);
}
