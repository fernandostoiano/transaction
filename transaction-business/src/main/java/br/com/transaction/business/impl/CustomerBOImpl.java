package br.com.transaction.business.impl;

import br.com.transaction.business.CustomerBO;
import br.com.transaction.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerBOImpl implements CustomerBO {

	@Override
	public Customer create(Customer customer) {
		customer.setId(1L);
		return customer;
	}
	
}
