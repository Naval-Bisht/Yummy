package org.naval.assignment.repo;

import org.naval.assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max ORDER BY p.price DESC")
    List<Product> getdata(@Param("min") int min, @Param("max") int max);
}
