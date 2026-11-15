package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "drinks")
@NoArgsConstructor
@Entity
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable=false)
    Category category;

    @OneToMany(mappedBy="drink")
    Set<BillDrink>billDrinks=new HashSet<>();

    @Column(nullable=false)
    String name;

    String description;
    String image;

    @Column(precision = 12, scale = 2)
    BigDecimal price;

    boolean active;
}
