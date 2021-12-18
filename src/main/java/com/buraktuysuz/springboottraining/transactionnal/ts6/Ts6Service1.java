package com.buraktuysuz.springboottraining.transactionnal.ts6;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.transactionnal.ts5.Ts5Service2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts6Service1 {
    private CategoryEntitySevice categoryEntitySevice;

    public Ts6Service1(CategoryEntitySevice categoryEntitySevice) {
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
