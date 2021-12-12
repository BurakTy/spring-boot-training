package com.buraktuysuz.springboottraining.service.entitySevice;

import com.buraktuysuz.springboottraining.dao.CategoryDao;
import com.buraktuysuz.springboottraining.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryEntitySevice {
    private CategoryDao categoryDao;

    public CategoryEntitySevice(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> findAll() {
        return (List<Category>) categoryDao.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryDao.findById(id);

        Category category = null;
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        }

        return category;
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }

    public Category save(Category category) {
        return categoryDao.save(category);
    }

    public void deleteById(Long id) {
        categoryDao.deleteById(id);
    }

    public long count() {
        return categoryDao.count();
    }
}
