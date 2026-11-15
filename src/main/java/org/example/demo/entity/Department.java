package org.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();
}
