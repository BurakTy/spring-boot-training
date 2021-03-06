package com.buraktuysuz.springboottraining.transactionnal.ts8;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts8Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts8Service2 ts8Service2;

    public Ts8Service1(CategoryEntitySevice categoryEntitySevice,Ts8Service2 ts8Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts8Service2 = ts8Service2;
    }

    public void save(){
        Category category=new Category();
        category.setName("transactional8-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("transactional 8-1 save");

        this.ts8Service2.save();

        System.out.println("8-1 end");
    }

}
