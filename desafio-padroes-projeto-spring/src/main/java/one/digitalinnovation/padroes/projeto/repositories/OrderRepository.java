package one.digitalinnovation.padroes.projeto.repositories;

import one.digitalinnovation.padroes.projeto.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, UUID> {
}
