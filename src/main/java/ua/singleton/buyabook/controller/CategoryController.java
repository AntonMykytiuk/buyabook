package ua.singleton.buyabook.controller;

import org.springframework.web.bind.annotation.*;
import ua.singleton.buyabook.model.Category;
import ua.singleton.buyabook.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("rest/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryService.create(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.removeById(id);
    }
}
