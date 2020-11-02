package correia.augusto.todorest.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {
    @GeneratedValue
    @Id
    Integer id;
    @Column
    String email;
    @Column
    String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public Object clone (){
        return this;
    }
}
