package com.buraktuysuz.springboottraining.dao;

import com.buraktuysuz.springboottraining.entity.Product;
import com.buraktuysuz.springboottraining.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User,Long> {

    User findByUsername(String username);
}
