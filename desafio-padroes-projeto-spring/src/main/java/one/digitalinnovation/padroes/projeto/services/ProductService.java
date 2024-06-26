package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductModel> findAll(Pageable pageable);
    ProductModel findById(long id);
    ProductModel save(ProductModel product);
    ProductModel update(long id, ProductModel product);
    void delete(long id);
}
