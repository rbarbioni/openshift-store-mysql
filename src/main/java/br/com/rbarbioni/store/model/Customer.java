package br.com.rbarbioni.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.rbarbioni.application.core.models.DomainEntity;

/**
 * Created by root on 10/12/15.
 */
@Entity
public class Customer extends DomainEntity {
	
	private static final long serialVersionUID = 4200782039831548268L;
	
	@Column(name="name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}