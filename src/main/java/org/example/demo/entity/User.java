package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable =false, unique=true)
    String email;

    @Column(nullable=false)
    String password;

    String fullName;
    String phone;

    @Enumerated(EnumType.STRING)
    Role role;

    boolean active;
}
