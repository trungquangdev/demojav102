package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "bills")
@Setter
@Getter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    User user;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<BillDrink> billDrinks = new HashSet<>();

    @Column(nullable = false, unique = true)
    String code;

    @CreationTimestamp
    @Column(nullable = false)
    LocalDateTime createdAt;

    @Column(precision = 12, scale = 2)
    BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    BillStatus status;
}
