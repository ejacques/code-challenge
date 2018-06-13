package br.com.civey.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository { // extends CrudRepository<CustomerEntity, Integer> {

	public List<CustomerEntity> findAll();
	
}
