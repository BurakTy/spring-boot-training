package com.buraktuysuz.springboottraining.desingpattern.template;

import com.buraktuysuz.springboottraining.service.entitySevice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReportService2 extends AbstractReportService {

    @Autowired
    private ProductEntityService productEntityService;

    @Override
    public String getTitle() {
        return "Products: ";
    }

    @Override
    public List getList() {
        return productEntityService.findAll();
    }
}
