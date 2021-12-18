package com.buraktuysuz.springboottraining.transactionnal.ts11;

import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.transactionnal.ts10.Ts10Service2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class Ts11Service1 {
    private CategoryEntitySevice categoryEntitySevice;
    private Ts11Service2 ts11Service2;


    public Ts11Service1(CategoryEntitySevice categoryEntitySevice, Ts11Service2 Ts11Service2) {
        this.categoryEntitySevice = categoryEntitySevice;
        this.ts11Service2 = Ts11Service2;
    }

    public void save(){
        ts11Service2.save();
        System.out.println(" 11-1 end");
    }
}
