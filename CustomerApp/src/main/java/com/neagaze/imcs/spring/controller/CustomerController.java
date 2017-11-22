package com.neagaze.imcs.spring.controller;

import com.neagaze.imcs.db.entities.Customer;
import com.neagaze.imcs.db.entities.PaymentMethod;
import com.neagaze.imcs.db.service.DatabaseServiceInterface;
import com.neagaze.imcs.spring.validator.CustomerValidator;
import com.neagaze.imcs.spring.validator.PaymentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by neaGaze on 11/17/17.
 */
@Controller
@RequestMapping("customers")
public class CustomerController {

   // final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CustomerController.class);

    private Customer customer;

    @Autowired
    private DatabaseServiceInterface service;

    @Autowired
    private CustomerValidator customerValidator;

    @Autowired
    private PaymentValidator paymentValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // binder.addValidators(customerValidator, paymentValidator);

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage() {
        // logger.debug("root page shown");
        return "index";
    }

    @ModelAttribute("customer")
    public Customer constructCustomer() {
        return new Customer();
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCustomerInputID() {
        return "view-customer-input";
    }


    /***
     * View Customer without Payment Methods (Customer + Address)
     * **/
    @RequestMapping(value = "/{customerId}/view", method = RequestMethod.POST)
    public ModelAndView viewCustomer(@PathVariable(value = "customerId") String custID) {
        // logger.debug("the customerId selected is: " + custID);
        System.out.println("the customerId selected is: " + custID);

        // check from the OrderLibrary service and retrieve the Customer model
        customer = service.getCustomerWithAddress(Integer.parseInt(custID));

        System.out.println(customer.getName());
        System.out.println(customer.getAddress());

        ModelAndView modelAndView = new ModelAndView("view-customer");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    /***
     * View Customer with Payment Methods
     * **/
    @RequestMapping(value = "/{customerId}/view", method = RequestMethod.GET)
    public ModelAndView viewCustomerWithPayment(@PathVariable(value = "customerId") String custID) {

        ModelAndView modelAndView = new ModelAndView("view-customer");

        // check from the OrderLibrary service and retrieve the Customer model
        customer = service.getCustomerWithAddress(Integer.parseInt(custID));

        System.out.println(customer.getName());
        System.out.println(customer.getAddress());
        /*
        if(customer.getPaymentMethodList() != null) {
            for (PaymentMethod p : customer.getPaymentMethodList()) {
                System.out.println(p);
                modelAndView.addObject("payment", p);
            }
        }
        */
        List<PaymentMethod> lists = (ArrayList<PaymentMethod>)service.getPaymentFromCustomer(new Integer(custID));
        if(lists != null) {
            modelAndView.addObject("paymentList", lists);
        }
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    /**
     *  Create a new Customer
     *****/
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCustomerView(Model model) {
        model.addAttribute("customer", new Customer());
        return "create-customer-form";
    }

    @RequestMapping(value = "/createCus", method = RequestMethod.POST)
    public String createCustomer(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            System.out.println("Binding failed");
        System.out.println("New customer created: " + customer);
        System.out.println("New address only: " + customer.getAddress());

        customer.getAddress().setCustomer(customer);
        service.addCustomer(customer);
        System.out.println("1. The customerId in main.app is: " + customer.getId());
        //logger.debug("The customerId in main.app is: " + customer.getId());

        return "index";
    }

    @RequestMapping(value = "/{customerId}/addPaymentMethod", method = RequestMethod.POST)
    public String addPaymentMethod(@PathVariable("customerId") String customerId,
                                   @Valid @ModelAttribute("payment") PaymentMethod paymentMethod,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            System.out.println("payment method binding failed");

        service.addPayments(Integer.parseInt(customerId), paymentMethod);

        System.out.println("New payment method: " + paymentMethod);
        return "index";
    }

    @RequestMapping(value = "/{customerId}/getPaymentAddMethod", method = RequestMethod.GET)
    public String getAddPaymentPage(@PathVariable("customerId") String customerId, Model model) {
        model.addAttribute("payment", new PaymentMethod());
        model.addAttribute("customerId", customerId);
        return "add-payment";
    }


    /***
     * Show all the customers from the database
     ****/
    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String getAllCustomersPage(Model model) {
/*
        List<Customer> lists = service.getAllCustomers();
        if(lists != null)
            System.out.println("All customers size: " + lists.size());
        model.addAttribute("customersList", lists);
        */
        return "customers-list-view";
    }

}