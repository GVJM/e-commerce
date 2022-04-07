package br.com.letscode.shop.product;


import br.com.letscode.shop.manufacturer.ManufacturerEntity;
import br.com.letscode.shop.manufacturer.ManufacturerRepository;
import br.com.letscode.shop.product.requests.ProductRequest;
import br.com.letscode.shop.product.requests.StatusRequest;
import br.com.letscode.shop.product.requests.ValueRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Optional;

import static org.springframework.data.jpa.domain.Specification.where;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;
    private ManufacturerRepository manufacturerRepository;

    private EntityManager entityManager;

    public Page<ProductEntity> searchAll(Integer offset,
                                         Integer limit,
                                         String name,
//                                           String nomeFabricante,
                                         BigDecimal value
    ) {
        Pageable pageable = new OffsetLimitPageable(offset, limit);

/*
    Filtro com Criteria
  */
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<ProdutoEntity> query = criteriaBuilder.createQuery(ProdutoEntity.class);
//        Root<ProdutoEntity> product = query.from(ProdutoEntity.class);
//
//        List<Predicate> predicates = new ArrayList();
//
//        if (name != null){
//            predicates.add(criteriaBuilder.like(product.get("name"), "%"+name+"%"));
//        }
//
//        predicates.add(criteriaBuilder.or(
//                criteriaBuilder.equal(product.get("name"), "Pablo"),
//                criteriaBuilder.equal(product.get("name"), "Diogo")
//        ));
////        /**
////        select * from product
////        where value <= 12
////        and name = Pablo or name = Diogo
////        */
//
//        if(value != null ) {
//            predicates.add(criteriaBuilder.lessThanOrEqualTo(product.get("value"), value));
//        }
//
//        query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
//
//        return entityManager.createQuery(query).getResultList();

 /*
    Filtro com Specification
  */
        return productRepository.findAll(
                where(nameContains(name)).and(valueLessThan(value)),
                pageable
        );
    }

    public ProductEntity searchById(Long id){
        return productRepository.findById(id).get();//TODO adicionar tratativa para optional empty
    }

    public ProductEntity searchByBarCode(String barCode){
            return productRepository.findByBarCode(barCode);
    }

    public ProductEntity create(ProductRequest productRequest){

            Optional<ManufacturerEntity> manufacturerEntity = manufacturerRepository.findById(productRequest.getManufactrerId());
            ProductEntity productEntity = toEntity(productRequest, manufacturerEntity.get());
            return productRepository.save(productEntity);
    }

    public ProductEntity updateValue(Long id, ValueRequest valueRequest){

        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        //valido se recuperou ou 404
        ProductEntity productEntity = optionalProductEntity.get();

        productEntity.setValue(valueRequest.getValue());

        return productRepository.save(productEntity);
    }

    public ProductEntity updateStatus(Long id, StatusRequest statusRequest){

        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        //valido se recuperou ou 404
        ProductEntity productEntity = optionalProductEntity.get();

        productEntity.setStatus(statusRequest.getStatus());

        return productRepository.save(productEntity);
    }

    private  ProductEntity toEntity(ProductRequest productRequest,
                                    ManufacturerEntity manufacturer){
        return new ProductEntity(
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getValue(),
                productRequest.getBarCode(),
                manufacturer,
                productRequest.getWeight(),
                productRequest.getWeightUnitMeasurement()
        );
    }

    static Specification<ProductEntity> valueLessThan(BigDecimal value) {
        return value == null ? null : (productEntity, cq, cb) -> cb.lessThanOrEqualTo(productEntity.get("value"),value);
    }
    static Specification<ProductEntity> nameContains(String name) {
        return name == null ? null : (productEntity, cq, cb) -> cb.like(productEntity.get("name"), "%" + name + "%");
    }

}
