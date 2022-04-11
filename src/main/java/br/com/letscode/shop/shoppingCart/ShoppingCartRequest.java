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

    private Long userId;
    private String userUsername;
    private Long oderStatusId;
    private BigDecimal total;
    private ZonedDateTime creationData;

    public ShoppingCartRequest(ShoppingCartEntity shoppingCartEntity) {
        this.userId = userId;
        this.userUsername = userUsername;
        this.oderStatusId = oderStatusId;
        this.total = total;
        this.creationData = creationData;
    }
}
