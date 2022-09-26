package com.example.customer.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByFirstName(String firstName);

	Customer findByCustomerId(int id);
}
