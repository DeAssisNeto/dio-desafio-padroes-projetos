package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import one.digitalinnovation.padroes.projeto.services.AddresService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddresServiceImpl implements AddresService {

    @Override
    public Page<AddressModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public AddressModel findById(String id) {
        return null;
    }

    @Override
    public AddressModel save(AddressRecordDto dto) {
        return null;
    }

    @Override
    public AddressModel update(String id, AddressRecordDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
