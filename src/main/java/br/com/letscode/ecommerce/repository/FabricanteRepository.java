package br.com.letscode.ecommerce.repository;

import br.com.letscode.ecommerce.model.entity.FabricanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<FabricanteEntity, Long> {
}
