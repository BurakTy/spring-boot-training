package com.buraktuysuz.springboottraining.transactionnal.ts9;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts9Service2 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts9Service3 ts9Service3;
    public Ts9Service2(CategoryEntitySevice categoryEntitySevice,Ts9Service3 ts9Service3) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts9Service3 = ts9Service3;
    }

    public void multiInsert(){

        for (int i = 2; i < 12; i++){
            try {
                ts9Service3.saveCategory(i);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
