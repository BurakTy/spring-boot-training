package com.buraktuysuz.springboottraining.transactionnal.ts1;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

@Service
public class Ts1Service {
    private CategoryEntitySevice categoryEntitySevice;

    public Ts1Service(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }
    public void save(){
        Category category=new Category();
        category.setName("transactional1");
        category.setDepth(1L);

        categoryEntitySevice.save(category);
        System.out.println("end");
    }
}
