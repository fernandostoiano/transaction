package br.com.transaction.business.repository;

import br.com.transaction.domain.Customer;

/**
 * Created by fernando on 04/10/16.
 */
public interface CustomerRepository {

    public Customer save(Customer customer);
}
