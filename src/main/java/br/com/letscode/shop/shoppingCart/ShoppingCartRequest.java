package br.com.letscode.shop.shoppingCart;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShoppingCartRequest {

    private Long user_id;
    private String user_username;
    private Long oder_status_id;
    private BigDecimal total;
    private ZonedDateTime creationData;

    public ShoppingCartRequest(ShoppingCartEntity shoppingCartEntity) {
        this.user_id = user_id;
        this.user_username = user_username;
        this.oder_status_id = oder_status_id;
        this.total = total;
        this.creationData = creationData;
    }
}
