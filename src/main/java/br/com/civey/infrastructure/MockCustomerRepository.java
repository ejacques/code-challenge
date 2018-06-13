package br.com.civey.infrastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class MockCustomerRepository {
	
	private Logger LOGGER = LoggerFactory.getLogger(MockCustomerRepository.class);

	public Optional<CustomerEntity> findById(Integer customerId) {
		return mockedCustomers().stream()
				.filter(customer -> customer.getId().equals(customerId))
				.findFirst();
	}

	public List<CustomerEntity> getCustomers(String city, String country, Integer pageSize, Integer pageNumber) {
		List<CustomerEntity> entities = mockedCustomers();

		if (!StringUtils.isEmpty(city)) {
			entities = entities.stream().filter(customer -> customer.getCity().equals(city)).collect(Collectors.toList());
		}
		if (!StringUtils.isEmpty(country)) {
			entities = entities.stream().filter(customer -> customer.getCountry().equals(country)).collect(Collectors.toList());
		}
		
		if (pageNumber == null || pageNumber <= 0) {
			pageNumber = 0;
		}
		if (pageSize != null) {
			Integer start = pageNumber * pageSize;
			Integer finish = start + pageSize;
			if (start > entities.size()) {
				LOGGER.info("Pagination start out of index.");
				start = entities.size();
			}
			if (finish > entities.size()) {
				LOGGER.info("Pagination finish out of index.");
				finish = entities.size();
			}
			entities = entities.subList(start, finish);
		}
		
		return entities;
	}
	
	private List<CustomerEntity> mockedCustomers() {
		return Arrays.asList(
				new CustomerEntity(1, "My Company", "Porto Alegre", "Brazil"),
				new CustomerEntity(2, "Civey", "Berlin", "Deutschland"),
				new CustomerEntity(3, "Another Company", "Palo Alto", "EUA"),
				new CustomerEntity(4, "The Name of This", "Rio de Janeiro", "Brazil"),
				new CustomerEntity(5, "Architects.io", "Berlin", "Deutschland"),
				new CustomerEntity(6, "Idea of a Name", "Berlin", "Deutschland"),
				new CustomerEntity(7, "DBServer", "Porto Alegre", "Brazil"));
	}
	
}
