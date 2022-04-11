package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.client.UserEntity;
import br.com.letscode.shop.client.UserRepository;
import br.com.letscode.shop.manufacturer.ManufacturerEntity;

import br.com.letscode.shop.product.OffsetLimitPageable;
import br.com.letscode.shop.product.ProductEntity;

import br.com.letscode.shop.product.ProductRepository;
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
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

@AllArgsConstructor
@Service
public class ShoppingCartService {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private ShoppingCartRepository shoppingCartRepository;

//    public ShoppingCartEntity create (ShoppingCartRequest shoppingCartRequest){
//
//
//    }

    public List<ShoppingCartRequest> findAllByUser (Long user_id) throws Exception {
        var user = userRepository.findById(user_id).orElseThrow(() -> new Exception("User not found!"));

        List<ShoppingCartEntity> allByUser = shoppingCartRepository.findAllByUser(user);

        return allByUser.stream().map(ShoppingCartRequest::new).collect(Collectors.toList());
    }
}