package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.models.ProductOrder;
import one.digitalinnovation.padroes.projeto.services.ProductOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Override
    public Page<ProductOrder> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductOrder findOne(Long id) {
        return null;
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return null;
    }

    @Override
    public ProductOrder update(UUID id, ProductOrder productOrder) {
        return null;
    }

    @Override
    public void delete(ProductOrder productOrder) {

    }
}
