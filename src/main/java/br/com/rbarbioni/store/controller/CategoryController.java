package br.com.rbarbioni.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rbarbioni.store.model.Category;
import br.com.rbarbioni.store.repository.CategoryRepository;

/**
 * Created by root on 10/12/15.
 */
@RestController
@RequestMapping(value="category", produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> findAll(){
		return this.categoryRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Category findOne(@PathVariable(value="id") Long id){
		return this.categoryRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Category create( @RequestBody Category category ){

		if ( category.getParent() != null ){

			Category parent = null;

			if (category.getParent().getUUID() != null ) {
				 parent = (Category) categoryRepository.findByuUID( category.getParent().getUUID() );
			}

			if ( parent == null ){
				parent = new Category();
				parent.setName( category.getParent().getName());
			}

			category.setParent( parent );
		}

		return this.categoryRepository.save(category);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public Category update(@PathVariable(value="id") Long id, @RequestBody Category category ){
		return this.categoryRepository.save(category);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="id") Long id ){
		Category category = this.categoryRepository.findOne(id);
		if ( category != null ){
			this.categoryRepository.delete(category);
		}
	}
}
