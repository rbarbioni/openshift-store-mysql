package br.com.rbarbioni.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.rbarbioni.application.core.models.DomainEntity;

@Entity
public class Product extends DomainEntity {
	
	private static final long serialVersionUID = -2142641923557789412L;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn ( name = "category_id", nullable = true )
	@Fetch ( FetchMode.JOIN )
	private Category category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}