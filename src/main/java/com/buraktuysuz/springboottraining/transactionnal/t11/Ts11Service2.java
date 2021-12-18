package com.buraktuysuz.springboottraining.transactionnal.t11;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts11Service2 {

    private CategoryEntitySevice categoryEntitySevice;

    public Ts11Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void save(){
        Category category=new Category();
        category.setName("transactional11-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("transactional mandatory 11-2 save");

    }
}
