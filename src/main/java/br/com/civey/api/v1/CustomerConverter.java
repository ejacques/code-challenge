package br.com.civey.api.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import br.com.civey.api.v1.model.Customer;
import br.com.civey.business.CustomerBO;

@Component
public class CustomerConverter {

	public Customer toDTO(CustomerBO business) {
		Assert.notNull(business, "Customer cannot be converted if null.");
		Customer dto = new Customer();
		dto.setCity(business.getCity());
		dto.setCompanyName(business.getCompanyName());
		dto.setCountry(business.getCountry());
		dto.setId(business.getId());
		return dto;
	}
	
	public List<Customer> toDTO(List<CustomerBO> bos) {
		Assert.notNull(bos, "List of customer cannot be converted if null.");
		return bos.stream().map(bo -> toDTO(bo)).collect(Collectors.toList());
	}
}
