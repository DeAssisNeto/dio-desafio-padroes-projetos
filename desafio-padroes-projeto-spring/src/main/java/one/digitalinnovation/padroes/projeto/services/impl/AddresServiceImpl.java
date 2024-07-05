package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import one.digitalinnovation.padroes.projeto.repositories.AddressRepository;
import one.digitalinnovation.padroes.projeto.services.AddresService;
import one.digitalinnovation.padroes.projeto.services.CustomerService;
import one.digitalinnovation.padroes.projeto.services.ViaCepService;
import org.springframework.beans.BeanUtils;
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
    private CustomerService customerService;

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
        CustomerModel customerModel = customerService.findById(dto.customer_id());
        AddressModel address = viaCepService.getAddressByCep(dto.cep());
        address.setCustomerModel(customerModel);
        addressRepository.save(address);
        return address;
    }

    @Override
    public AddressModel update(UUID id, AddressRecordDto dto) {
        Optional<AddressModel> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            AddressModel addressModel = addressOptional.get();
            if (dto.customer_id() != null) {
                CustomerModel customerModel = customerService.findById(dto.customer_id());
                addressModel.setCustomerModel(customerModel);
            }
            if (dto.cep() != null) {
                AddressModel addressViaCep = viaCepService.getAddressByCep(dto.cep());
                addressViaCep.setId(addressModel.getId());
                addressViaCep.setCustomerModel(addressModel.getCustomerModel());
                BeanUtils.copyProperties(addressViaCep, addressModel);
            }
            return addressRepository.save(addressModel);
        }
        throw new ResourceNotFoundException("Address", "id", id.toString());

    }

    @Override
    public void delete(UUID id) {
        if (!addressRepository.existsById(id)) throw new ResourceNotFoundException("Address", "id", id.toString());
        addressRepository.deleteById(id);

    }
}
