package ee.sdacademy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_lists")
public class ShoppingLists extends AbstractEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public ShoppingLists() {

    }

    public ShoppingLists(String name, Users user) {
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
