package br.com.rbarbioni.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbarbioni.store.model.Customer;
import br.com.rbarbioni.store.repository.CustomerRepository;

/**
 * Created by root on 10/12/15.
 */
@RestController
@RequestMapping(value="customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
	
	@Autowired
	private CustomerRepository pcustomerRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> findAll(){
		return this.pcustomerRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Customer findOne(@PathVariable(value="id") Long id){
		return this.pcustomerRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Customer create( @RequestBody Customer pcustomer ){		
		return this.pcustomerRepository.save(pcustomer);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public Customer update(@PathVariable(value="id") Long id, @RequestBody Customer pcustomer ){
		return this.pcustomerRepository.save(pcustomer);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="id") Long id ){
		Customer pcustomer = this.pcustomerRepository.findOne(id);
		if ( pcustomer != null ){
			this.pcustomerRepository.delete(pcustomer);
		}
	}
}
