package br.com.rbarbioni.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbarbioni.store.model.OrderProduct;
import br.com.rbarbioni.store.repository.OrderProductRepository;

/**
 * Created by root on 10/12/15.
 */
@RestController
@RequestMapping(value="orderProduct", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderProductController {
	
	@Autowired
	private OrderProductRepository orderProductRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<OrderProduct> findAll(){
		return this.orderProductRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public OrderProduct findOne(@PathVariable(value="id") Long id){
		return this.orderProductRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public OrderProduct create( @RequestBody OrderProduct orderProduct ){		
		return this.orderProductRepository.save(orderProduct);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public OrderProduct update(@PathVariable(value="id") Long id, @RequestBody OrderProduct orderProduct ){
		return this.orderProductRepository.save(orderProduct);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="id") Long id ){
		OrderProduct orderProduct = this.orderProductRepository.findOne(id);
		if ( orderProduct != null ){
			this.orderProductRepository.delete(orderProduct);
		}
	}
}
