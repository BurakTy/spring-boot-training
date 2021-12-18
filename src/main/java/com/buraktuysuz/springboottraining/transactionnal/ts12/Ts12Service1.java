package com.buraktuysuz.springboottraining.transactionnal.ts12;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts12Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts12Service2 ts12Service2;


    public Ts12Service1(CategoryEntitySevice categoryEntitySevice, Ts12Service2 ts12Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts12Service2 = ts12Service2;
    }

    public void save(){
        Category category = new Category();
        category.setName("transactional12-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println(" 12-1 save");

        ts12Service2.save();
        System.out.println(" 12-1 end");
    }
}
