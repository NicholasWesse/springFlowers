package c322.springFlowers.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(schema = "flowers")
public final class Customer {
    @Id
    private String username;
    private String password;
    private String email;

    private List<Integer> orders;


    public Customer() {
    }


    public Customer(String username,
                    String password,
                    String email,
                    List<Integer> orders) {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}