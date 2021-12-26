package com.buraktuysuz.springboottraining.desingpattern.template;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryReportService {

    @Autowired
    private CategoryEntitySevice categoryEntitySevice;

    public void report(){

        List<Category> categoryList = categoryEntitySevice.findAll();

        System.out.println("Categories: ");
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }
}
