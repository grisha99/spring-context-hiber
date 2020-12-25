package ru.grishchenko.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class ShoppingListKey implements Serializable {

    private static final long serialVersionUID = -5649548612015989580L;

    @Column(name = "buyer_id")
    private Integer buyerId;

    @Column(name = "product_id")
    private Integer productId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingListKey that = (ShoppingListKey) o;
        return Objects.equals(buyerId, that.buyerId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerId, productId);
    }
}