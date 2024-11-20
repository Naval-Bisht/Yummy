package org.naval.assignment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.naval.assignment.dto.CustomerRequest;
import org.naval.assignment.dto.Productrequest;
import org.naval.assignment.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // it is used beause we want to talk to backend
@RequiredArgsConstructor
@RequestMapping("/api/user")

public class UserController {
    private final CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<String> sayhello(){
        return ResponseEntity.ok("hello");
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
    @GetMapping("getUser")
    public ResponseEntity<String> getUser(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(customerService.getUser(request));

    }
    @PutMapping("updateUser")
    public ResponseEntity<String> updateUser(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(customerService.updateUser(request));

    }
    @DeleteMapping("deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(customerService.deleteUser(request));

    }

    @PostMapping("addProduct")
    public ResponseEntity<String>addProduct(@RequestBody Productrequest request){
        return ResponseEntity.ok(customerService.addProduct(request));

    }

    @GetMapping("getProduct")
    public ResponseEntity<String>getProduct(@RequestBody Productrequest request){
        return ResponseEntity.ok(customerService.getProduct(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.login(request));
    }

}

