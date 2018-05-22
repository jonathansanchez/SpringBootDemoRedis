package com.example.redis.demo.domain.Customer;

import java.util.Map;

public interface CustomerRepository {

    /**
     * Save a new Customer
     * @param customer
     */
    void save(Customer customer);

    /**
     * Find a Customer by id
     * @param id
     * @return Customer
     */
    Customer find(Long id);

    /**
     * Return all customers
     * @return Map
     */
    Map<Long, Customer> findAll();

    /**
     * Update a existing Customer
     * @param customer
     */
    void update(Customer customer);

    /**
     * Delete a existing Customer by id
     * @param id
     */
    void delete(Long id);
}
