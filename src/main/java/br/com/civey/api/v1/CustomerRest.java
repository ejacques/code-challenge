package br.com.civey.api.v1;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.civey.api.v1.model.Customer;
import br.com.civey.api.v1.model.Order;
import br.com.civey.api.v1.model.Product;
import br.com.civey.business.CustomerBO;
import br.com.civey.business.CustomerService;

@RestController
@RequestMapping(path = "/v1/customers")
public class CustomerRest {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerConverter customerConverter;
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getCustomers(@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "country", required = false) String country,
			@RequestParam(name = "pageSize", required = false) Integer pageSize,
			@RequestParam(name = "pageNumber", required = false) Integer pageNumber) {
		List<Customer> customers = customerConverter.toDTO(customerService.getCustomers(city, country, pageSize, pageNumber));
		return ok(customers);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId) {
		Optional<CustomerBO> optCustomer = customerService.getCustomer(customerId);
		if (optCustomer.isPresent()) {
			return ok(customerConverter.toDTO(optCustomer.get()));
		}
		return notFound().build();
	}
	
	@GetMapping("/{customerId}/orders")
	public List<Order> getOrders(@PathVariable("customerId") Integer customerId) {
		
		return null;
	}
	
	@GetMapping("/{customerId}/favorite-products")
	public List<Product> getFavoriteProducts(@PathVariable("customerId") Integer customerId) {
		
		return null;
	}
}
