package com.neagaze.imcs.db.controller;

import com.neagaze.imcs.db.entities.Customer;
import com.neagaze.imcs.db.entities.PaymentMethod;
import com.neagaze.imcs.db.service.DatabaseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by neaGaze on 11/21/17.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private Customer customer;

    @Autowired
    @Qualifier(value="concreteDbService")
    private DatabaseServiceInterface service;


    /***
     * View Customer without Payment Methods (Customer + Address)
     * **/
    @RequestMapping(value = "/{customerId}/view", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> viewCustomer(@PathVariable(value = "customerId") String custID) {

        // check from the OrderLibrary service and retrieve the Customer model
        customer = service.getCustomerWithAddress(Integer.parseInt(custID));
        return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
    }


    /***
     * View Customer with Payment Methods
     * **/
    @RequestMapping(value = "/{customerId}/view", method = RequestMethod.GET)
    public ResponseEntity<?> viewCustomerWithPayment(@PathVariable(value = "customerId") String custID) {

        // check from the OrderLibrary service and retrieve the Customer model
        customer = service.getCustomer(Integer.parseInt(custID));
        return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
        customer.getAddress().setCustomer(customer);
        service.addCustomer(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{customerId}/addPaymentMethod", method = RequestMethod.POST)
    public ResponseEntity addPaymentMethod(@PathVariable("customerId") String customerId,
                                   @Valid @RequestBody PaymentMethod paymentMethod,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            System.out.println("payment method binding failed");

        service.addPayments(Integer.parseInt(customerId), paymentMethod);

        System.out.println("New payment method: " + paymentMethod);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /***
     * Show all the customers from the database
     ****/
    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public ResponseEntity getAllCustomersPage() {
        List<Customer> lists =  service.getAllCustomers();

        return new ResponseEntity(lists, HttpStatus.ACCEPTED);
    }
}
