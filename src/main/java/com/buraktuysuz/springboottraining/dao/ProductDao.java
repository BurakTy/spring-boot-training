package com.buraktuysuz.springboottraining.dao;

import com.buraktuysuz.springboottraining.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Long> {
}
