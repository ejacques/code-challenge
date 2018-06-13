package br.com.civey.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import br.com.civey.infrastructure.CustomerEntity;

@Component("customerBOConverter")
public class CustomerConverter {

	public CustomerBO toBO(CustomerEntity entity) {
		Assert.notNull(entity, "Customer entity cannot be converted if null.");
		CustomerBO business = new CustomerBO();
		business.setCity(entity.getCity());
		business.setCompanyName(entity.getCompanyName());
		business.setCountry(entity.getCountry());
		business.setId(entity.getId());
		return business;
	}
	
	public List<CustomerBO> toBO(List<CustomerEntity> entities) {
		Assert.notNull(entities, "List of customer entity cannot be converted if null.");
		return entities.stream().map(entity -> toBO(entity)).collect(Collectors.toList());
	}
	
}
