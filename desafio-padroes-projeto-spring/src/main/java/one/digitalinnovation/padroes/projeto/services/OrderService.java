package one.digitalinnovation.padroes.projeto.services;

import one.digitalinnovation.padroes.projeto.models.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {
    Page<OrderModel> findAll(Pageable pageable);
    OrderModel findById(long id);
    OrderModel save(OrderModel order);
    OrderModel update(UUID id, OrderModel order);
    void delete(OrderModel order);
}
