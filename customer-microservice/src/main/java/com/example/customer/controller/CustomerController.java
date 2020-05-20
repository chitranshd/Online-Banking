package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.bean.Customer;
import com.example.customer.service.CustomerService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	
	
	@GetMapping(value="/login/{username}/{password}")
	public Customer verifyLogin(@PathVariable String username,@PathVariable String password) {
		System.out.println("Done");
	Customer cust=service.findCustomerByUsername(username);
	System.out.println(cust);
		 if(cust!=null && cust.getPassword().equals(password)) {
		 return cust;}
		 else {
		   return null;}
		}
	
	@PostMapping(value = "/password/{oldPassword}/{newPassword}")
    public Customer updatePassword(@PathVariable String oldPassword,@PathVariable String newPassword) {
    	Customer cust=service.findCustomerByPassword(oldPassword);
    	if(cust!=null) {
    		cust.setPassword(newPassword);
    	    service.addCustomer(cust);
    	    return cust;
    }
    	else {
    		return null;
    	}
	}
	
	@PostMapping(value = "/address/{oldAddress}/{newAddress}")
    public Customer updateAddress(@PathVariable String oldAddress,@PathVariable String newAddress) {
    	Customer cust=service.findCustomerByAddress(oldAddress);
    	if(cust!=null) {
    		cust.setAddress(newAddress);
    	    service.addCustomer(cust);
    	    return cust;
    	    
    }
    	else {
    		return null;
    	}
	}
	
	@PostMapping(value = "/mobileNumber/{oldmobileNumber}/{newmobileNumber}")
    public Customer updateMobileNumber(@PathVariable String oldmobileNumber,@PathVariable String newmobileNumber) {
    	Customer cust=service.findCustomerByMobileNumber(oldmobileNumber);
    	if(cust!=null) {
    		cust.setMobileNumber(newmobileNumber);
    	    service.addCustomer(cust);
    	    return cust;
    }
    	else {
    		return null;
    	}
	}
	
	@PostMapping(value="/addcustomer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer) {
	return service.addCustomer(customer);
	}
	
	@GetMapping(value="/getcustomer/{username}")
	public Customer getCustomerByusername(@PathVariable String username) {
	return service.findCustomerByUsername(username);
	}
	
	@GetMapping(value="/getcustomername/{customerName}")
	public Customer getCustomerByCustomerName(@PathVariable String customerName) {
	return service.findCustomerByCustomerName(customerName);
	}
	
	@GetMapping(value="/allcustomers")
	public List<Customer> getCustomers(){
	return service.getCustomers();	
	}	
		
	
	
}
