package com.buraktuysuz.springboottraining.transactionnal.ts8;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class Ts8Service1 {
    private CategoryEntitySevice categoryEntitySevice;

    public Ts8Service1(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    public void save(){
        Category category=new Category();
        category.setName("transactional5-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("non transactional 5-1 save");

        throw  new RuntimeException("hata");

    }

}
