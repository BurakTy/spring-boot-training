package com.buraktuysuz.springboottraining.transactionnal.ts3;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class Ts3Service2 {

    private CategoryEntitySevice categoryEntitySevice;

    public Ts3Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    public void save(){
        Category category=new Category();
        category.setName("transactional3-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        System.out.println("non transactinal service end");
    }
}
