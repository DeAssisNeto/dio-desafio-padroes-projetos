package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CustomerService {
    Page<CustomerModel> findAll(Pageable pageable);
    CustomerModel findOne(Long id);
    CustomerModel save(CustomerModel customer);
    CustomerModel update(UUID id, CustomerModel customer);
    void delete(Long id);
}
