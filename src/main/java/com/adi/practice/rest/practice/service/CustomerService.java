package com.adi.practice.rest.practice.service;

import com.adi.practice.rest.practice.dao.CustomerDAO;
import com.adi.practice.rest.practice.exception.CustomerNotFoundException;
import com.adi.practice.rest.practice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {


    @Autowired
    private CustomerDAO customerDAO;

    private List<Customer> customerList=new CopyOnWriteArrayList<>();

 //   private int customerIdCount=1;
    public Customer addCustomer(Customer customer){
//        customer.setCustomer_id(customerIdCount);
//  customerList.add(customer);
//    customerIdCount++;



    return customerDAO.save(customer);
    }

    public List<Customer> getCustomer(){

        //return customerList;

        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId){
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomer_id()==customerId)
//                .findFirst()
//                .get();
        Optional<Customer> optionalCustomer=customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer record not available");
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId,Customer customer){
//        customerList
//                .stream()
//                .forEach(c->{
//                    if(c.getCustomer_id()==customerId){
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//
//        return customerList
//                .stream()
//                .filter(c->c.getCustomer_id()==customerId)
//                .findFirst()
//                .get();

        customer.setCustomer_id(customerId);
       return customerDAO.save(customer);
    }

public void deleteCustomer(int customerId){
//        customerList
//                .stream()
//                .forEach(c->{
//                    if(c.getCustomer_id()==customerId){
//                        customerList.remove(c);
//                    }
//                });
    customerDAO.deleteById(customerId);
}



}
