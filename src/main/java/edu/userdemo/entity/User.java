package edu.userdemo.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="mytable")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid")
    private Integer id;
    @Column(name="username",unique = true,nullable = false,length = 20)
    private String name;
    @Column(name="useremail",unique = true,nullable = false,length = 20)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
