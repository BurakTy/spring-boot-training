package com.buraktuysuz.springboottraining.transactionnal.ts5;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.transactionnal.ts4.Ts4Service2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts5Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts5Service2 ts5Service2;

    public Ts5Service1(CategoryEntitySevice categoryEntitySevice, Ts5Service2 ts5Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts5Service2=ts5Service2;
    }
    public void save(){
        Category category=new Category();
        category.setName("transactional5-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        ts5Service2.save();

        System.out.println("5-1 end");
    }
}
