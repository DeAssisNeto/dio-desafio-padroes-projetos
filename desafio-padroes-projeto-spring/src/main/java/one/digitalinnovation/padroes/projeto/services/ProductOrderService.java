package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.ProductOrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductOrderService {
    Page<ProductOrderModel> findAll(Pageable pageable);
    ProductOrderModel findOne(Long id);
    ProductOrderModel save(ProductOrderModel productOrderModel);
    ProductOrderModel update(UUID id, ProductOrderModel productOrderModel);
    void delete(ProductOrderModel productOrderModel);

}
