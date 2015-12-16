package br.com.rbarbioni.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rbarbioni.store.model.Customer;

/**
 * Created by root on 10/12/15.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
