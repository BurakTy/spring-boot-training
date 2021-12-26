package com.buraktuysuz.springboottraining.desingpattern.template;

import com.buraktuysuz.springboottraining.entity.Product;
import com.buraktuysuz.springboottraining.service.entitySevice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReportService {

    @Autowired
    private ProductEntityService productEntityService;

    public void report(){

        List<Product> urunList = productEntityService.findAll();

        System.out.println("Products: ");
        for (Product product : urunList) {
            System.out.println(product);
        }

    }
}
