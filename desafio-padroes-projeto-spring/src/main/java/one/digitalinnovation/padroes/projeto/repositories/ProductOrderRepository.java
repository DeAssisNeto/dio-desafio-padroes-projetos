package one.digitalinnovation.padroes.projeto.repositories;

import one.digitalinnovation.padroes.projeto.models.ProductOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderModel, UUID> {
}
