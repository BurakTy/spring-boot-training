package com.buraktuysuz.springboottraining.transactionnal.ts14;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.transactionnal.ts12.Ts12Service2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class Ts14Service1 {

    private Ts14Service2 ts14Service2;


    public Ts14Service1(CategoryEntitySevice categoryEntitySevice, Ts14Service2 ts14Service2) {
        this.ts14Service2 = ts14Service2;
    }

    public void save(){
        Date date1 = new Date();

        ts14Service2.findAll();

        Date date2 = new Date();

        long diff = date2.getTime() - date1.getTime();

        System.out.println(diff);
    }
}
