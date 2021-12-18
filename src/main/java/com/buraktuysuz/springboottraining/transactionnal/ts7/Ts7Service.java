package com.buraktuysuz.springboottraining.transactionnal.ts7;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class Ts7Service {
    private CategoryEntitySevice categoryEntitySevice;

    public Ts7Service(CategoryEntitySevice categoryEntitySevice) {
        this.categoryEntitySevice = categoryEntitySevice;
    }

    public void save(){
        Category category=new Category();
        category.setName("transactional7-1");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("transactional 7-1 save");

        save2();
        System.out.println("7-1 end");
    }

    /**
     * https://stackoverflow.com/questions/28480480/propagation-requires-new-does-not-create-a-new-transaction-in-spring-with-jpa
     *
     * Spring transactions are proxy-based. Here's thus how it works when bean A causes a transactional
     * of bean B. A has in fact a reference to a proxy, which delegates to the bean B.
     * This proxy is the one which starts and commits/rollbacks the transaction:
     *
     * A ---> proxy ---> B
     * In your code, a transactional method of A calls another transactional method of A.
     * So Spring can't intercept the call and start a new transaction.
     * It's a regular method call without any proxy involved.
     *
     * So, if you want a new transaction to start, the method save2 should be in another bean,
     * injected into your current bean.
     */

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save2(){
        Category category=new Category();
        category.setName("transactional7-2");
        category.setDepth(1L);
        categoryEntitySevice.save(category);
        System.out.println("transactional requires_new 7-2 save");

    }
}
