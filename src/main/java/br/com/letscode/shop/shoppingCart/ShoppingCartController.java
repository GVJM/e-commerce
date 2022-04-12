package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.product.ProductEntity;
import br.com.letscode.shop.product.requests.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RequestMapping("shoppingCart")
@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ShoppingCartRequest>> checkShoppingCart(@PathVariable Long userId) {
        try {
            var shoppingCartEntities = shoppingCartService.findAllByUser(userId);
            return ResponseEntity.ok(shoppingCartEntities);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<ShoppingCartEntity> create(
            @RequestBody ShoppingCartRequest request) {
        try {
            return new ResponseEntity(shoppingCartService.createShoppingCart(request), HttpStatus.CREATED);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}