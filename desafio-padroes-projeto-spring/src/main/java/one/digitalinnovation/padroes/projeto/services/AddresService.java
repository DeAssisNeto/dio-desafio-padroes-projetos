package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.AddressModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddresService {
    Page<AddressModel> findAll(Pageable pageable);
    AddressModel findById(String id);
    AddressModel save(AddressModel address);
    AddressModel update(String id, AddressModel address);
    void delete(String id);
}
