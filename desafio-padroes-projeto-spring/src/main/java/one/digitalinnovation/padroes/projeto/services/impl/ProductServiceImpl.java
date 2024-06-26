package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.models.ProductModel;
import one.digitalinnovation.padroes.projeto.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Page<ProductModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductModel findById(long id) {
        return null;
    }

    @Override
    public ProductModel save(ProductModel product) {
        return null;
    }

    @Override
    public ProductModel update(long id, ProductModel product) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
