package ua.singleton.buyabook.service;

import org.springframework.stereotype.Service;
import ua.singleton.buyabook.dao.CategoryRepo;
import ua.singleton.buyabook.model.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepo.getById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.getAll();
    }

    @Override
    public void create(Category category) {
        categoryRepo.create(category);
    }

    @Override
    public void update(Long id, Category category) {
        Category categoryFromRepo = categoryRepo.getById(id);
        categoryFromRepo.setName(category.getName());
        categoryRepo.update(category);
    }

    @Override
    public void removeById(Long id) {
        categoryRepo.removeById(id);
    }
}
