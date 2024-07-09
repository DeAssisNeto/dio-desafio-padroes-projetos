package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.ProductOrderRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.InsufficientQuantityStockException;
import one.digitalinnovation.padroes.projeto.models.OrderModel;
import one.digitalinnovation.padroes.projeto.models.ProductModel;
import one.digitalinnovation.padroes.projeto.models.ProductOrderModel;
import one.digitalinnovation.padroes.projeto.repositories.ProductOrderRepository;
import one.digitalinnovation.padroes.projeto.services.OrderService;
import one.digitalinnovation.padroes.projeto.services.ProductOrderService;
import one.digitalinnovation.padroes.projeto.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @Override
    public Page<ProductOrderModel> findAll(Pageable pageable) {
        return productOrderRepository.findAll(pageable);
    }

    @Override
    public ProductOrderModel findOne(UUID id) {
        return null;
    }

    @Override
    public ProductOrderModel save(ProductOrderRecordDto dto) {
        ProductModel productModel = productService.findById(dto.productId());
        OrderModel orderModel = orderService.findById(dto.orderId());
        checkStock(orderModel, productModel);
        return productOrderRepository.save(new ProductOrderModel(productModel, orderModel));
    }

    @Override
    public ProductOrderModel update(UUID id, ProductOrderRecordDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    private void checkStock(OrderModel orderModel, ProductModel productModel){
        BigInteger order = orderModel.getProductQuantity();
        BigInteger stock = productModel.getStock();
        if (!(stock.compareTo(order) >= 0)) {
            throw new InsufficientQuantityStockException(orderModel.getProductQuantity(), productModel.getStock());
        }

        productModel.setStock(stock.subtract(order));
    }
}
