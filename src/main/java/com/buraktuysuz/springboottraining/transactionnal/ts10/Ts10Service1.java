package com.buraktuysuz.springboottraining.transactionnal.ts10;

import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;

@Service
public class Ts10Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts10Service2 ts10Service2;


    public Ts10Service1(CategoryEntitySevice categoryEntitySevice, Ts10Service2 ts10Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts10Service2 = ts10Service2;
    }

    public void save(){
        ts10Service2.save();
        System.out.println(" 10-1 end");
    }
}
