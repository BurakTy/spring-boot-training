package com.buraktuysuz.springboottraining.transactionnal.ts4;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.transactionnal.ts3.Ts3Service2;
import org.springframework.stereotype.Service;

@Service
public class Ts4Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts4Service2 ts4Service2;

    public Ts4Service1(CategoryEntitySevice categoryEntitySevice, Ts4Service2 ts4Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts4Service2=ts4Service2;
    }
    public void save(){
        Category category=new Category();
        category.setName("transactional4-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        ts4Service2.save();

        System.out.println("non transactional 4-1 end");
    }
}
