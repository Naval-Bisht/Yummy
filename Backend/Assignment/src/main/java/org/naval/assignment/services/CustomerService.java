package org.naval.assignment.services;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.naval.assignment.dto.CustomerRequest;
import org.naval.assignment.dto.Productrequest;
import org.naval.assignment.entity.Customer;
import org.naval.assignment.entity.Product;
import org.naval.assignment.helper.EncryptPassword;
import org.naval.assignment.helper.JWTHelper;
import org.naval.assignment.mapper.CustomerMapper;
import org.naval.assignment.mapper.ProductMapper;
import org.naval.assignment.repo.CustomerRepo;
import org.naval.assignment.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;
    private final CustomerRepo customerRepo;
    private final EncryptPassword encryptPassword;
    private final JWTHelper jwtHelper;
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;



    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        customer.setPassword(encryptPassword.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";
    }

    public String getUser (CustomerRequest request){
        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        return customer == null ? "no user found": customer.toString();
    }

    public String updateUser (CustomerRequest request){
        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        if (customer == null) {return "user not found";}
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setPassword(encryptPassword.encode(customer.getPassword()));

        customerRepo.save(customer);
        return "Customer Updated Successfully \n" +customer.toString();

    }

    public String deleteUser (CustomerRequest request){
        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        if (customer == null) {return "user not found";}

        customerRepo.delete(customer);


        return "Customer delete Successfully \n" +customer.toString();

    }


    public String addProduct(Productrequest request) {
        Product product = productMapper.toProduct(request);
        productRepo.save(product);
        return  "succesfully added product";
    }
    public String getProduct(Productrequest request) {
        List<Product> product= productRepo.getdata(request.min(),request.max());
        return product ==null ?"No Producr found":product.toString();
    }


    public String login(@Valid CustomerRequest request) {

        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        if(!encryptPassword.validates(request.password(), customer.getPassword())) {
            return "Wrong Password or Email";
        }


        return jwtHelper.generateToken(request.email());

    }
}
