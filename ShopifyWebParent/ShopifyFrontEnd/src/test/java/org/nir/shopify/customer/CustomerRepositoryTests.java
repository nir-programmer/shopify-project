package org.nir.shopify.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.nir.shopify.common.entity.AuthenticationType;
import org.nir.shopify.common.entity.Country;
import org.nir.shopify.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {

	@Autowired private CustomerRepository repo;
	@Autowired private TestEntityManager entityManager;

	@Test
	public void testCreateCustomer1() {
		Integer countryId = 234; // USA
		Country country = entityManager.find(Country.class, countryId);

		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setFirstName("David");
		customer.setLastName("Fountaine");
		customer.setPassword("password123");
		customer.setEmail("david.s.fountaine@gmail.com");
		customer.setPhoneNumber("312-462-7518");
		customer.setAddressLine1("1927  West Drive");
		customer.setCity("Sacramento");
		customer.setState("California");
		customer.setPostalCode("95867");
		customer.setCreatedTime(new Date());

		Customer savedCustomer = repo.save(customer);

		assertThat(savedCustomer).isNotNull();
		assertThat(savedCustomer.getId()).isGreaterThan(0);
	}

	@Test
	public void testCreateCustomer2() {
		Integer countryId = 106; // India
		Country country = entityManager.find(Country.class, countryId);

		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setFirstName("Sanya");
		customer.setLastName("Lad");
		customer.setPassword("password456");
		customer.setEmail("sanya.lad2020@gmail.com");
		customer.setPhoneNumber("02224928052");
		customer.setAddressLine1("173 , A-, Shah & Nahar Indl.estate, Sunmill Road");
		customer.setAddressLine2("Dhanraj Mill Compound, Lower Parel (west)");
		customer.setCity("Mumbai");
		customer.setState("Maharashtra");
		customer.setPostalCode("400013");
		customer.setCreatedTime(new Date());

		Customer savedCustomer = repo.save(customer);

		assertThat(savedCustomer).isNotNull();
		assertThat(savedCustomer.getId()).isGreaterThan(0);
	}	

	@Test
	public void testListCustomers() {
		Iterable<Customer> customers = repo.findAll();
		customers.forEach(System.out::println);

		assertThat(customers).hasSizeGreaterThan(1);
	}

	@Test
	public void testUpdateCustomer() {
		Integer customerId = 1;
		String lastName = "Stanfield";

		Customer customer = repo.findById(customerId).get();
		customer.setLastName(lastName);
		customer.setEnabled(true);

		Customer updatedCustomer = repo.save(customer);
		assertThat(updatedCustomer.getLastName()).isEqualTo(lastName);
	}

	@Test
	public void testGetCustomer() {
		Integer customerId = 2;
		Optional<Customer> findById = repo.findById(customerId);

		assertThat(findById).isPresent();

		Customer customer = findById.get();
		System.out.println(customer);
	}

	@Test
	public void testDeleteCustomer() {
		Integer customerId = 2;
		repo.deleteById(customerId);

		Optional<Customer> findById = repo.findById(customerId);		
		assertThat(findById).isNotPresent();		
	}

	@Test
	public void testFindByEmail() {
		String email = "david.s.fountaine@gmail.com";
		Customer customer = repo.findByEmail(email);

		assertThat(customer).isNotNull();
		System.out.println(customer);		
	}

	@Test
	public void testFindByVerificationCode() {
		String code = "code_123";
		Customer customer = repo.findByVerificationCode(code);

		assertThat(customer).isNotNull();
		System.out.println(customer);		
	}

	@Test
	public void testEnableCustomer() {
		Integer customerId = 1;
		repo.enable(customerId);

		Customer customer = repo.findById(customerId).get();
		assertThat(customer.isEnabled()).isTrue();
	}
	
	@Test
	public void testUpdateAuthenticationType() {
		Integer id = 1;
		repo.updateAuthenticationType(id, AuthenticationType.DATABASE);

		Customer customer = repo.findById(id).get();

		assertThat(customer.getAuthenticationType()).isEqualTo(AuthenticationType.DATABASE);
	}
	
	//Create a password from github2021
	@Test
	public void generatePasswordForCustomerOnHeroku()
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "github2021";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
		boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
		
		assertThat(matches).isTrue();
		//$2a$10$Hpzf7VQ0DncM9Q8cpoqx9.V4repsStiYjKvxnlkhmo8SGUl6z3OqG
		//$2a$10$Ii6l.5dh5Frpg3W8oNImyu4OwVWNuV2H6uc6hWjqMIE6gcVSjh5H
		
	}
}