package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.dtos.ProductOrderRecordDto;
import one.digitalinnovation.padroes.projeto.models.ProductOrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductOrderService {
    Page<ProductOrderModel> findAll(Pageable pageable);
    ProductOrderModel findOne(UUID id);
    ProductOrderModel save(ProductOrderRecordDto dto);
    ProductOrderModel update(UUID id, ProductOrderRecordDto dto);
    void delete(UUID id);

}
