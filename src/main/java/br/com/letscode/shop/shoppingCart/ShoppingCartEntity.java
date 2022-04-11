package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.client.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity(name = "ORDER")
@Builder
@Data
@NoArgsConstructor
public class ShoppingCartEntity {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user_id;

    @ManyToOne
    @JoinColumn(name = "USER_USERNAME")
    private UserEntity user_username;

    @Column(name = "ORDER_STATUS_ID")
    private int order_status_id;

    @Column(name = "total")
    private Double total;

    @Column(name = "CREATION_DATE")
    private ZonedDateTime creation_date;

    public ShoppingCartEntity(Long id, UserEntity user_id, UserEntity user_username, int order_status_id, double total,
                              ZonedDateTime creation_date) {
        this.id = id;
        this.user_id = user_id;
        this.user_username = user_username;
        this.order_status_id = order_status_id;
        this.total = total;
        this.creation_date = creation_date;
    }
}
