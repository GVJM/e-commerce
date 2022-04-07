package br.com.letscode.shop.product.requests;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductRequest {

    private String name;

    private String description;

    private BigDecimal value;

    private String barCode;

    private Long manufactrerId;

    private Integer weight;

    private String weightUnitMeasurement;
}
