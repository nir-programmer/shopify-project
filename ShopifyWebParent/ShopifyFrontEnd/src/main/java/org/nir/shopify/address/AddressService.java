package org.nir.shopify.address;

import java.util.List;

import org.nir.shopify.common.entity.Address;
import org.nir.shopify.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	@Autowired private AddressRepository repo;

	public List<Address> listAddressBook(Customer customer) {
		return repo.findByCustomer(customer);
	}

}