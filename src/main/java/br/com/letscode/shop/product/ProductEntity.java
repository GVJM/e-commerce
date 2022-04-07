package br.com.letscode.shop.product;

import br.com.letscode.shop.manufacturer.ManufacturerEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "PRODUCT")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_product")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALUE")
    private BigDecimal value;

    @Column(name = "BAR_CODE")
    private String barCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER")
    private ManufacturerEntity manufacturer;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "WEIGHT_UNIT_MEASUREMENT")
    private String weightUnitMeasurement;

    @Column(name = "CREATION_DATA")
    private ZonedDateTime creationData;

    @Column(name = "LATEST_UPDATE")
    private ZonedDateTime latestUpdate;


    public ProductEntity(String name, String description,
                         BigDecimal value, String barCode,
                         ManufacturerEntity manufacturer, Integer weight,
                         String weightUnitMeasurement) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.barCode = barCode;
        this.status = ProductStatus.ACTIVE;
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.weightUnitMeasurement = weightUnitMeasurement;
        this.creationData = ZonedDateTime.now();
        this.latestUpdate = ZonedDateTime.now();
    }

}
