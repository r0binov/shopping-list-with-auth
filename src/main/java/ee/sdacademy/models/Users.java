package ee.sdacademy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users extends AbstractEntity {

    @Column(name = "username", nullable = false, length = 45, unique = true)
    private String username;

    @Column(name = "password",  nullable = false, length = 128)
    private String password;

    public Users() {

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
