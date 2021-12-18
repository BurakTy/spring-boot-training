package com.buraktuysuz.springboottraining.transactionnal.ts5;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts5Service2 {

    private CategoryEntitySevice categoryEntitySevice;

    public Ts5Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    public void save(){
        Category category=new Category();
        category.setName("transactional5-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        System.out.println("5-2 end");
    }
}
