package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.client.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity(name = "T_ORDER")
@Data
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity userId;

    @Column(name = "ORDER_STATUS_ID")
    private int orderStatusId;

    @Column(name = "total")
    private Double total;

    @Column(name = "CREATION_DATE")
    private ZonedDateTime creationDate;

}
