package com.buraktuysuz.springboottraining.transactionnal.ts4;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts4Service2 {

    private CategoryEntitySevice categoryEntitySevice;

    public Ts4Service2(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    public void save(){
        Category category=new Category();
        category.setName("transactional4-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        System.out.println("transactinal service 4-2 end");
    }
}
