package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.dtos.ProductRecordDto;
import one.digitalinnovation.padroes.projeto.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    Page<ProductModel> findAll(Pageable pageable);
    ProductModel findById(UUID id);
    ProductModel save(ProductRecordDto dto);
    ProductModel update(UUID id, ProductRecordDto dto);
    void delete(UUID id);
}
