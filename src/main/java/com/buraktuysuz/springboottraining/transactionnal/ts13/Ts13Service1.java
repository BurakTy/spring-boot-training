package com.buraktuysuz.springboottraining.transactionnal.ts13;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.transactionnal.ts12.Ts12Service2;
import com.buraktuysuz.springboottraining.transactionnal.ts3.Ts3Service2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts13Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts13Service2 ts13Service2;


    public Ts13Service1(CategoryEntitySevice categoryEntitySevice, Ts13Service2 ts13Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts13Service2 = ts13Service2;
    }

    public void save(){
        Category category = new Category();
        category.setName("transactional13-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println(" 13-1 save");


        ts13Service2.save();
        System.out.println(" 13-1 end");
    }
}
