package br.com.rbarbioni.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbarbioni.store.model.Product;
import br.com.rbarbioni.store.repository.ProductRepository;

/**
 * Created by root on 10/12/15.
 */
@RestController
@RequestMapping(value="product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Product> findAll(){
		return this.productRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Product findOne(@PathVariable(value="id") Long id){
		return this.productRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Product create( @RequestBody Product product ){		
		return this.productRepository.save(product);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public Product update(@PathVariable(value="id") Long id, @RequestBody Product product ){
		return this.productRepository.save(product);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="id") Long id ){
		Product product = this.productRepository.findOne(id);
		if ( product != null ){
			this.productRepository.delete(product);
		}
	}
}
