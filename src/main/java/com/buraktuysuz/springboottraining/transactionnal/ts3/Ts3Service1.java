package com.buraktuysuz.springboottraining.transactionnal.ts3;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts3Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts3Service2 ts3Service2;

    public Ts3Service1(CategoryEntitySevice categoryEntitySevice,Ts3Service2 ts3Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts3Service2=ts3Service2;
    }
    public void save(){
        Category category=new Category();
        category.setName("transactional3-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        ts3Service2.save();

        System.out.println("3-1 end");
    }
}
