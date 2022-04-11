package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.client.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long>{
    List<ShoppingCartEntity> findAllByUserId(UserEntity user);
}
