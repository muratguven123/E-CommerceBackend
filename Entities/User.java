package Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "deneme")
@Data
public class User {
    @Id
    Long id;

    String username;
    String password;
}
