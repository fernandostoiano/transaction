package br.com.transaction.business.impl;

import br.com.transaction.business.CustomerBO;
import br.com.transaction.business.repository.CustomerRepository;
import br.com.transaction.domain.Address;
import br.com.transaction.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("transactionManager")
public class CustomerBOImpl implements CustomerBO {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer create() {

		Customer customer = this.customerFactory();

		Customer customerCreated = customerRepository.save(customer);

		customerCreated.setAddress(addressFactory(customer));

		return customerCreated;
	}

	private Customer customerFactory() {

		Customer customer = new Customer();

		customer.setName("Fernando");
		customer.setDocument("31002461871");

		return customer;
	}

	private Address addressFactory(Customer customer) {

		Address address = new Address();

		address.setAddressLine1("Rua Dr. Miranda de Azevedo");
		address.setAddressLine2("546 - apto 112");
		address.setZipCode("05027000");
		address.setCustomer(customer);

		return address;
	}
	
}
