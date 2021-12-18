package com.buraktuysuz.springboottraining.transactionnal.ts13;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts13Service2 {

    private CategoryEntitySevice categoryEntitySevice;

    public Ts13Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void save(){
        Category category=new Category();
        category.setName("transactional12-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println(" support 13-2 save");

    }
}
