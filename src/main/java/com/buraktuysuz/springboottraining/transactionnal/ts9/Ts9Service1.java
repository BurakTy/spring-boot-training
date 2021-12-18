package com.buraktuysuz.springboottraining.transactionnal.ts9;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class Ts9Service1 {

    private CategoryEntitySevice categoryEntitySevice;
    private Ts9Service2 ts9Service2;

    public Ts9Service1(CategoryEntitySevice categoryEntitySevice, Ts9Service2 ts9Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts9Service2 = ts9Service2;
    }

    public void save(){
        Category category = new Category();
        category.setName("transactional9-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        ts9Service2.multiInsert();

        System.out.println("9-1 end");

    }
}
