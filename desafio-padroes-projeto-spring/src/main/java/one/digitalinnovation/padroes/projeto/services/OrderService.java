package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.dtos.OrderRecordDto;
import one.digitalinnovation.padroes.projeto.models.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {
    Page<OrderModel> findAll(Pageable pageable);
    OrderModel findById(UUID id);
    OrderModel save(OrderRecordDto dto);
    OrderModel update(UUID id, OrderRecordDto dto);
    void delete(UUID order);
}
