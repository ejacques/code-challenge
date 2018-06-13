package br.com.civey.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.civey.infrastructure.CustomerEntity;
import br.com.civey.infrastructure.MockCustomerRepository;

@Service
public class CustomerService {

	@Autowired
	MockCustomerRepository customerRepository;
	
	@Autowired
	CustomerConverter customerConverter;
	
	public List<CustomerBO> getCustomers(String city, String country, Integer pageSize, Integer pageNumber) {
		return customerConverter.toBO(customerRepository.getCustomers(city, country, pageSize, pageNumber));
	}

	public Optional<CustomerBO> getCustomer(Integer customerId) {
		Optional<CustomerEntity> entity = customerRepository.findById(customerId);
		if (entity.isPresent()) {
			return Optional.of(customerConverter.toBO(entity.get()));
		}
		return Optional.empty();
	}
	
}
