package org.naval.assignment.repo;


import org.naval.assignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> { // if we use the jpa then no
                                                                      // need of using the @repository
    Optional<Customer> findByEmail(String email);
}
