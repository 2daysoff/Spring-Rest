package com.adi.practice.rest.practice.api;

import com.adi.practice.rest.practice.model.Customer;
import com.adi.practice.rest.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);

    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){

        return customerService.getCustomer(customerId);

    }
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int custmerId,@RequestBody Customer customer){

        return customerService.updateCustomer(custmerId,customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }

}
