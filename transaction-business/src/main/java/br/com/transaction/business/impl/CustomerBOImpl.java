package br.com.transaction.business.impl;

import org.springframework.stereotype.Service;

import br.com.transaction.business.CustomerBO;
import br.com.transaction.domain.Customer;

@Service
public class CustomerBOImpl implements CustomerBO {
	
	@Override
	public Customer create(Customer customer) {
		customer.setId(1L);
		return customer;
	}
	
}
