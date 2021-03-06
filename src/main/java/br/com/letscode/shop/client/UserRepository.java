package br.com.letscode.shop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT e FROM USERS e JOIN FETCH e.roles WHERE e.username = :username")
    public UserEntity findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}
