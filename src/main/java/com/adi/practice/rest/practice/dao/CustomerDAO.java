package com.adi.practice.rest.practice.dao;

import com.adi.practice.rest.practice.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer> {

@Override
    List<Customer> findAll();


}
