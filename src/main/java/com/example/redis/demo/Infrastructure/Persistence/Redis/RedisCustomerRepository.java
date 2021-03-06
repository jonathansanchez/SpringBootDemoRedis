package com.example.redis.demo.Infrastructure.Persistence.Redis;

import com.example.redis.demo.domain.Customer.Customer;
import com.example.redis.demo.domain.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisCustomerRepository implements CustomerRepository {

    private static final String KEY = "Customer";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Customer> hashOperations;

    @Autowired
    public RedisCustomerRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    @Override
    public Customer find(Long id) {
        return hashOperations.get(KEY, id);
    }

    @Override
    public Map<Long, Customer> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void update(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }
}
