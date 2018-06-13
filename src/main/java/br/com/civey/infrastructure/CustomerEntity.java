package br.com.civey.infrastructure;

//@Entity
public class CustomerEntity {

//	@Id
	private Integer id;
	private String companyName;
	private String city;
	private String country;
	
	public CustomerEntity(Integer id, String companyName, String city, String country) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.city = city;
		this.country = country;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
    
	
}
