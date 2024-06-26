package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.CustomerRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.CustomerAlreadyExistsException;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import one.digitalinnovation.padroes.projeto.repositories.CustomerRepository;
import one.digitalinnovation.padroes.projeto.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<CustomerModel> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public CustomerModel findById(UUID id) {
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if (customer.isPresent()) return customer.get();

        throw new ResourceNotFoundException("Customer", "id", id.toString());

    }

    @Override
    public CustomerModel save(CustomerRecordDto dto) {
        if (customerRepository.existsByCpf(dto.cpf())) throw new CustomerAlreadyExistsException(dto.cpf());
        return customerRepository.save(new CustomerModel(dto.name(), dto.cpf()));
    }

    @Override
    public CustomerModel update(UUID id, CustomerRecordDto dto) {
        Optional<CustomerModel> optionalCustomerModel = customerRepository.findById(id);
        if (optionalCustomerModel.isPresent()) {
            CustomerModel customerModel = optionalCustomerModel.get();
            if(dto.name() != null) customerModel.setName(dto.name());
            if(dto.cpf() != null) customerModel.setCpf(dto.cpf());
            return customerRepository.save(customerModel);
        }
        throw new ResourceNotFoundException("Customer", "id", id.toString());
    }

    @Override
    public void delete(UUID id) {
        if (!customerRepository.existsById(id)) throw new ResourceNotFoundException("Customer", "id", id.toString());
        customerRepository.deleteById(id);
    }
}
