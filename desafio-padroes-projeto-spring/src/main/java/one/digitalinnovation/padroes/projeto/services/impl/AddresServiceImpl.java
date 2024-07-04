package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import one.digitalinnovation.padroes.projeto.repositories.AddressRepository;
import one.digitalinnovation.padroes.projeto.repositories.CustomerRepository;
import one.digitalinnovation.padroes.projeto.services.AddresService;
import one.digitalinnovation.padroes.projeto.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddresServiceImpl implements AddresService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Page<AddressModel> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    @Override
    public AddressModel findById(String id) {
        return null;
    }

    @Override
    public AddressModel save(AddressRecordDto dto) {
        if (customerRepository.existsById(dto.customer_id())){
            AddressModel address = viaCepService.getAddressByCep(dto.cep());
            addressRepository.save(address);
            return address;
        }
        throw new ResourceNotFoundException("Customer", "id", dto.customer_id().toString());
    }

    @Override
    public AddressModel update(String id, AddressRecordDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
