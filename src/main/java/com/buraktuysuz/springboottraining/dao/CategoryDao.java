package com.buraktuysuz.springboottraining.dao;

import com.buraktuysuz.springboottraining.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends CrudRepository<Category,Long> {
}
