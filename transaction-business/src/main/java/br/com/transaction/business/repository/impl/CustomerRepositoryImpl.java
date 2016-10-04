package br.com.transaction.business.repository.impl;

import br.com.transaction.business.repository.CustomerRepository;
import br.com.transaction.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by fernando on 04/10/16.
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext(unitName = "entityManager")
    protected EntityManager entityManager;

    public Customer save(Customer customer) {
        entityManager.persist(customer);

        return customer;
    }

}
