package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AddresService {
    Page<AddressModel> findAll(Pageable pageable);
    AddressModel findById(UUID id);
    AddressModel save(AddressRecordDto dto);
    AddressModel update(UUID id, AddressRecordDto dto);
    void delete(UUID id);
}
