package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductOrderService {
    Page<ProductOrder> findAll(Pageable pageable);
    ProductOrder findOne(Long id);
    ProductOrder save(ProductOrder productOrder);
    ProductOrder update(UUID id, ProductOrder productOrder);
    void delete(ProductOrder productOrder);

}
