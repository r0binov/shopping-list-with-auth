package ee.sdacademy.database.models;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ShoppingList shoppingList;

    public Items(Long itemId, String itemName, String quantity, ShoppingList shoppingList) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.shoppingList = shoppingList;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
