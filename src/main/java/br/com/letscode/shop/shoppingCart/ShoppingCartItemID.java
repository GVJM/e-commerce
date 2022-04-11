package br.com.letscode.shop.shoppingCart;

import br.com.letscode.shop.product.ProductEntity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ShoppingCartItemID implements Serializable {

    @JoinColumn(name = "ID_ORDER")
    @ManyToOne
    private ShoppingCartEntity shoppingCart;

    @JoinColumn(name = "ID_PRODUCT")
    @ManyToOne
    private ProductEntity product;
}
