package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomers(){
        List<CustomerDTO> customers = new ArrayList<>();
        customerRepository.findAll().stream().forEach(item ->{
            customers.add(mapCustomerEntityToDTO(item));
        });
        return customers;
    }

    public void createNewCustomer(CustomerDTO customerDTO){
        customerRepository.persist(mapCustomerDTOToEntity(customerDTO));
    }

    public void changeCustomer(Long id, CustomerDTO customerDTO){
        CustomerEntity customer = customerRepository.findById(id);

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setAddress(customerDTO.getAddress());
        customer.setAge(customerDTO.getAge());
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapCustomerEntityToDTO(CustomerEntity customer){

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setAge(customer.getAge());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setName(customer.getName());

        return customerDTO;

    }

    private CustomerEntity mapCustomerDTOToEntity(CustomerDTO customerDTO){

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setName(customerDTO.getName());

        return customerEntity;

    }
}
