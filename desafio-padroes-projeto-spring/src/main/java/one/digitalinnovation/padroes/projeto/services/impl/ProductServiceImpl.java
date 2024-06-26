package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.ProductRecordDto;
import one.digitalinnovation.padroes.projeto.models.ProductModel;
import one.digitalinnovation.padroes.projeto.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Page<ProductModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductModel findById(UUID id) {
        return null;
    }

    @Override
    public ProductModel save(ProductRecordDto dto) {
        return null;
    }

    @Override
    public ProductModel update(long id, ProductRecordDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
