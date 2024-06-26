package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.OrderRecordDto;
import one.digitalinnovation.padroes.projeto.models.OrderModel;
import one.digitalinnovation.padroes.projeto.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Page<OrderModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public OrderModel findById(UUID id) {
        return null;
    }

    @Override
    public OrderModel save(OrderRecordDto dto) {
        return null;
    }

    @Override
    public OrderModel update(UUID id, OrderRecordDto dto) {
        return null;
    }

    @Override
    public void delete(UUID order) {

    }
}
