package br.com.rbarbioni.store.controller;

import java.util.List;

import br.com.rbarbioni.store.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbarbioni.store.model.CustomerOrder;

/**
 * Created by root on 10/12/15.
 */
@RestController
@RequestMapping(value="order", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerOrderController {
	
	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CustomerOrder> findAll(){
		return this.customerOrderRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public CustomerOrder findOne(@PathVariable(value="id") Long id){
		return this.customerOrderRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public CustomerOrder create( @RequestBody CustomerOrder customerOrder ){		
		return this.customerOrderRepository.save(customerOrder);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public CustomerOrder update(@PathVariable(value="id") Long id, @RequestBody CustomerOrder customerOrder ){
		return this.customerOrderRepository.save(customerOrder);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="id") Long id ){
		CustomerOrder customerOrder = this.customerOrderRepository.findOne(id);
		if ( customerOrder != null ){
			this.customerOrderRepository.delete(customerOrder);
		}
	}
}
