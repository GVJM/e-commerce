package br.com.letscode.shop.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName (String name);

    @Query("SELECT e FROM USER e JOIN FETCH e.roles WHERE e.username= (:username)")
    public UserEntity findByUsername(@Param("username") String username);
}
