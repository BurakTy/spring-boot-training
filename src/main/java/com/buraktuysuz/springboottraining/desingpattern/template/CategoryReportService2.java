package com.buraktuysuz.springboottraining.desingpattern.template;

import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryReportService2 extends AbstractReportService {

    @Autowired
    private CategoryEntitySevice categoryEntitySevice;

    @Override
    public String getTitle() {
        return "Categories: ";
    }

    @Override
    public List getList() {
        return categoryEntitySevice.findAll();
    }
}
