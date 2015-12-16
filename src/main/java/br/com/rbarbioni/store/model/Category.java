package br.com.rbarbioni.store.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.rbarbioni.application.core.models.DomainEntity;

/**
 * Created by root on 10/12/15.
 */
@Entity
public class Category extends DomainEntity {
	
	private static final long serialVersionUID = -2142641923557789412L;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn ( name = "parent_id")
	private Category parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
}