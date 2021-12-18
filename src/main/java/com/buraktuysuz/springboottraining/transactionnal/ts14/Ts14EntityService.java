package com.buraktuysuz.springboottraining.transactionnal.ts14;


import com.buraktuysuz.springboottraining.dao.CategoryDao;
import com.buraktuysuz.springboottraining.entity.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class Ts14EntityService {

    private Map<Long, Category> categoryMap = new LinkedHashMap<>();

    private CategoryDao categoryDao;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Category findById(Long id){

        Category category = categoryMap.get(id);

        if (category != null){
            return category;
        }

        Optional<Category> optionalCategory = categoryDao.findById(id);

        if (optionalCategory.isPresent()){
            category = optionalCategory.get();
        }

        categoryMap.put(id, category);

        return category;
    }

}