package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddresService {
    Page<AddressModel> findAll(Pageable pageable);
    AddressModel findById(String id);
    AddressModel save(AddressRecordDto dto);
    AddressModel update(String id, AddressRecordDto dto);
    void delete(String id);
}
