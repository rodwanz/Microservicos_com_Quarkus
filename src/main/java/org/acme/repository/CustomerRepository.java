package org.acme.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.CustomerEntity;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<CustomerEntity> {
}
