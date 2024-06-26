package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.models.ProductOrderModel;
import one.digitalinnovation.padroes.projeto.services.ProductOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Override
    public Page<ProductOrderModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductOrderModel findOne(Long id) {
        return null;
    }

    @Override
    public ProductOrderModel save(ProductOrderModel productOrderModel) {
        return null;
    }

    @Override
    public ProductOrderModel update(UUID id, ProductOrderModel productOrderModel) {
        return null;
    }

    @Override
    public void delete(ProductOrderModel productOrderModel) {

    }
}
