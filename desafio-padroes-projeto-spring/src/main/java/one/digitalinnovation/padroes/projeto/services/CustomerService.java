package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.dtos.CustomerRecordDto;
import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CustomerService {
    Page<CustomerModel> findAll(Pageable pageable);
    CustomerModel findById(UUID id);
    CustomerModel save(CustomerRecordDto dto);
    CustomerModel update(UUID id, CustomerRecordDto dto);
    void delete(UUID id);
}
