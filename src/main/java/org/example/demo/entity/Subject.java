package org.example.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    @ManyToMany(mappedBy = "subjects")
    @ManyToMany(mappedBy = "subjects")
    private Set<Student> student = new HashSet<>();
}
