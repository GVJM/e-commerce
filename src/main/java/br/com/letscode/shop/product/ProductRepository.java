package br.com.letscode.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> , JpaSpecificationExecutor<ProductEntity> {

//    @Query("SELECT p from ProdutoEntity p where p.codigoBarra = :codigoBarra")
    @Query(value = "SELECT * FROM PRODUCT where BAR_CODE = ?1", nativeQuery = true)
    ProductEntity findByBarCode(String barCode);

//    @Query(value = "SELECT sum(valor) FROM PRODUTO where id_fabricante = ?1", nativeQuery = true)
//    BigDecimal sumProductValuesByFabricante(Long idFabricante);
}
