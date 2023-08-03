package ee.sdacademy.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Items extends AbstractEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private ShoppingLists shoppingList;

    public Items() {

    }

    public Items(String name, BigDecimal quantity, ShoppingLists shoppingList) {
        this.name = name;
        this.quantity = quantity;
        this.shoppingList = shoppingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public ShoppingLists getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingLists shoppingList) {
        this.shoppingList = shoppingList;
    }


}
