package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.OrderRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import one.digitalinnovation.padroes.projeto.models.OrderModel;
import one.digitalinnovation.padroes.projeto.repositories.OrderRepository;
import one.digitalinnovation.padroes.projeto.services.CustomerService;
import one.digitalinnovation.padroes.projeto.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;

    @Override
    public Page<OrderModel> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public OrderModel findById(UUID id) {
        Optional<OrderModel> orderModel = orderRepository.findById(id);
        if (orderModel.isEmpty()) throw new ResourceNotFoundException("Order", "id", id.toString());
        return orderModel.get();
    }

    @Override
    public OrderModel save(OrderRecordDto dto) {
        CustomerModel customerModel = customerService.findById(dto.customerId());
        return orderRepository.save(new OrderModel(dto.productQuantity(), customerModel));
    }

    @Override
    public OrderModel update(UUID id, OrderRecordDto dto) {
        Optional<OrderModel> orderModel = orderRepository.findById(id);
        if (orderModel.isEmpty()) throw new ResourceNotFoundException("Order", "id", id.toString());

        if (dto.productQuantity() != null) orderModel.get().setProductQuantity(dto.productQuantity());
        return orderRepository.save(orderModel.get());
    }

    @Override
    public void delete(UUID order) {
        Optional<OrderModel> orderModel = orderRepository.findById(order);
        if (orderModel.isEmpty()) throw new ResourceNotFoundException("Order", "id", order.toString());
        orderRepository.deleteById(order);
    }
}
