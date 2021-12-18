package com.buraktuysuz.springboottraining.transactionnal.ts12;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts12Service2 {

    private CategoryEntitySevice categoryEntitySevice;

    public Ts12Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void save(){
        Category category=new Category();
        category.setName("transactional12-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("before transactional support 12-2 save");

    }
}
