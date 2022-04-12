package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.client.UserEntity;
import br.com.letscode.shop.client.UserRepository;

import br.com.letscode.shop.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;


    public List<ShoppingCartRequest> findAllByUser (Long userId) {
            UserEntity user = new UserEntity();
            user.setId(userId);
            List<ShoppingCartEntity> allByUser = shoppingCartRepository.findAllByUserId(user);

            return allByUser.stream().map(ShoppingCartRequest::new).collect(Collectors.toList());
    }

    public ShoppingCartEntity createShoppingCart(ShoppingCartRequest request) {

        ShoppingCartEntity order = new ShoppingCartEntity();

        UserEntity user = new UserEntity();
        user.setId(request.getUserId());

        order.setUserId(user);
        order.setOrderStatusId(1);
        order.setCreationDate(ZonedDateTime.now());

        return shoppingCartRepository.save(order);
    }
}