package com.buraktuysuz.springboottraining.service.entitySevice;

import com.buraktuysuz.springboottraining.dao.ProductDao;
import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService {

    private ProductDao productDao;

    public ProductEntityService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll(){
        return (List<Product>) productDao.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalProduct = productDao.findById(id);

        Product product = null;
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }
        return product;
    }
}
