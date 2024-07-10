package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.ProductOrderRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.InsufficientQuantityStockException;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
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
import java.util.Optional;
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
        Optional<ProductOrderModel> productOrderModel = productOrderRepository.findById(id);
        if (productOrderModel.isEmpty()) throw new ResourceNotFoundException("ProductOrder", "id", id.toString());
        return productOrderModel.get();
    }

    @Override
    public ProductOrderModel save(ProductOrderRecordDto dto) {
        ProductModel productModel = productService.findById(dto.productId());
        OrderModel orderModel = orderService.findById(dto.orderId());
        reduceStock(orderModel, productModel);
        return productOrderRepository.save(new ProductOrderModel(productModel, orderModel));
    }

    @Override
    public ProductOrderModel update(UUID id, ProductOrderRecordDto dto) {
        Optional<ProductOrderModel> productOrderModel = productOrderRepository.findById(id);

        if (productOrderModel.isEmpty()) throw new ResourceNotFoundException("ProductOrder", "id", id.toString());

        increaseStock(productOrderModel.get().getOrderModel(), productOrderModel.get().getProductModel());
        ProductModel productModel = productService.findById(dto.productId());
        OrderModel orderModel = orderService.findById(dto.orderId());
        reduceStock(orderModel, productModel);


        return productOrderRepository.save(productOrderModel.get());
    }

    @Override
    public void delete(UUID id) {
        Optional<ProductOrderModel> productOrderModel = productOrderRepository.findById(id);
        if (productOrderModel.isEmpty()) throw new ResourceNotFoundException("ProductOrder", "id", id.toString());

        reduceStock(productOrderModel.get().getOrderModel(), productOrderModel.get().getProductModel());
        productOrderRepository.deleteById(id);
    }

    private void reduceStock(OrderModel orderModel, ProductModel productModel){
        BigInteger order = orderModel.getProductQuantity();
        BigInteger stock = productModel.getStock();
        if (!(stock.compareTo(order) >= 0)) {
            throw new InsufficientQuantityStockException(orderModel.getProductQuantity(), productModel.getStock());
        }

        productModel.setStock(stock.subtract(order));
    }

    private void increaseStock(OrderModel orderModel, ProductModel productModel){
        BigInteger order = orderModel.getProductQuantity();
        BigInteger stock = productModel.getStock();
        productModel.setStock(stock.add(order));
    }
}
