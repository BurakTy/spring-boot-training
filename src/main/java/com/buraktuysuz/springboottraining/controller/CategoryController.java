package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.converter.CategoryConverter;
import com.buraktuysuz.springboottraining.dto.CategoryDto;
import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryEntitySevice categoryEntitySevice;

    public CategoryController(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    @GetMapping("/")
    public List<Category> findAllCategory(){
        return categoryEntitySevice.findAll();
    }

    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Long id){
        return categoryEntitySevice.findById(id);
    }

    @PostMapping("/")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto){
        Category category=  CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);
        category =categoryEntitySevice.save(category);
        return CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody CategoryDto categoryDto){
        Category category=  CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);
        return categoryEntitySevice.save(category);
    }
}
