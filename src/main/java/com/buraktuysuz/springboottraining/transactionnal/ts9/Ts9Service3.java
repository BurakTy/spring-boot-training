package com.buraktuysuz.springboottraining.transactionnal.ts9;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts9Service3 {
    private CategoryEntitySevice categoryEntitySevice;
    public Ts9Service3(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveCategory(int i) {

        Category category = new Category();
        category.setName("transactional9-" + i);
        category.setDepth(1L);
        categoryEntitySevice.save(category);

        if (i == 9){
            throw new RuntimeException("hata");
        }
    }

}
