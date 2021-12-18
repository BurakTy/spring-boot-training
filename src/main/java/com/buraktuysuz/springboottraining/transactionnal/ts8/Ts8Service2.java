package com.buraktuysuz.springboottraining.transactionnal.ts8;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts8Service2 {
    private CategoryEntitySevice categoryEntitySevice;

    public Ts8Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(){
        Category category=new Category();
        category.setName("transactional8-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("transactional requires_new 8-2 save");


    }

}
