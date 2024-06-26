package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import one.digitalinnovation.padroes.projeto.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Page<CustomerModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CustomerModel findOne(Long id) {
        return null;
    }

    @Override
    public CustomerModel save(CustomerModel customer) {
        return null;
    }

    @Override
    public CustomerModel update(UUID id, CustomerModel customer) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
