package org.naval.assignment.mapper;

import org.naval.assignment.dto.CustomerRequest;
import org.naval.assignment.dto.Productrequest;
import org.naval.assignment.entity.Customer;
import org.naval.assignment.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(Productrequest request) {
        return Product.builder().price(request.price()).ProductName(request.productName()).build();
    }
}
