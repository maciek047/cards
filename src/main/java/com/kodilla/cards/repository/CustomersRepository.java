package com.kodilla.cards.repository;

import com.kodilla.cards.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById(Long customerId);
}
