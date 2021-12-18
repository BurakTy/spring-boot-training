package com.buraktuysuz.springboottraining.controller;

import com.buraktuysuz.springboottraining.dto.CategoryDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransactionalController {

    /*
    * 1: transactional olmayan yerde kayıt işlemi
    * @param CategoryDto
    * */

    @PostMapping("/")
    public void transactionnal(@RequestBody CategoryDto categoryDto){

    }
}
