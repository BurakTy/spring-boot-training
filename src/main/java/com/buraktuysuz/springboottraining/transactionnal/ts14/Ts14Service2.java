package com.buraktuysuz.springboottraining.transactionnal.ts14;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts14Service2 {

    private Ts14EntityService ts14EntityService;

    public Ts14Service2(Ts14EntityService ts14EntityService) {
        this.ts14EntityService = ts14EntityService;
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)  //  aktif transactional ı askıya alıp non transactional olarak devam ettiği için daha hızlıdır
    public void findAll() {                                  // olarak devam ettiği için daha hızlıdır
        for (int i = 0; i< 9999; i++){
            Category category = ts14EntityService.findById(1L);
        }
    }
}
