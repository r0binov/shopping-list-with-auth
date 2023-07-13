package ee.sdacademy.database.models;

import jakarta.persistence.*;

@Entity
@Table(name = "shoppingList")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    private Long listId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users users) {
        this.user = users;
    }

    public ShoppingList(Long listId, Users user) {
        this.listId = listId;
        this.user = user;
    }
}
