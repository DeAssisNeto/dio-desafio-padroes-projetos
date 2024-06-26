package one.digitalinnovation.padroes.projeto.repositories;

import one.digitalinnovation.padroes.projeto.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, String> {
}
