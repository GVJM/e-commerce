package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ORDER_ITEMS")
@Builder
@Data
@NoArgsConstructor
public class ShoppingCartItemsEntity implements Serializable {

    @EmbeddedId
    private ShoppingCartItemID shoppingCartItemID;

    @Column(name = "UNIT_PRICE")
    private int unit_price;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "TOTAL")
    private int total;

    public ShoppingCartItemsEntity(ShoppingCartItemID shoppingCartItemID, int unit_price, int amount, int total) {
        this.shoppingCartItemID = shoppingCartItemID;
        this.unit_price = unit_price;
        this.amount = amount;
        this.total = total;
    }
}
