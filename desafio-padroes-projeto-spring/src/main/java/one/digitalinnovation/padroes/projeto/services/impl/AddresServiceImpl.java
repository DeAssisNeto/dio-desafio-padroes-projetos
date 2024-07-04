package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import one.digitalinnovation.padroes.projeto.repositories.AddressRepository;
import one.digitalinnovation.padroes.projeto.repositories.CustomerRepository;
import one.digitalinnovation.padroes.projeto.services.AddresService;
import one.digitalinnovation.padroes.projeto.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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
    public AddressModel findById(UUID id) {
        Optional<AddressModel> address = addressRepository.findById(id);
        if (address.isPresent()) return address.get();
        throw new ResourceNotFoundException("Address", "id", id.toString());
    }

    @Override
    public AddressModel save(AddressRecordDto dto) {
        Optional<CustomerModel> customerModel = customerRepository.findById(dto.customer_id());
        if (customerModel.isPresent()){
            AddressModel address = viaCepService.getAddressByCep(dto.cep());
            address.setCustomerModel(customerModel.get());
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
