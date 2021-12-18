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
    private Ts9Service3 ts9Service3;
    public Ts9Service3(CategoryEntitySevice categoryEntitySevice, Ts9Service3 ts9Service3) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts9Service3 = ts9Service3;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveCategory(int i) {

        Category kategori = new Category();
        kategori.setName("transactional9-" + i);
        kategori.setDepth(1L);
        categoryEntitySevice.save(kategori);

        if (i == 9){
            throw new RuntimeException("hata");
        }
    }

}
