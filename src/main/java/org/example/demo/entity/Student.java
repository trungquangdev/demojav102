package org.example.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")

public class Student {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY) //fetch: khi nao` thi` load data ra
//    @JoinColumn(name = "departments")
    private Department department; //department_id

    @ManyToMany
    //create table with name "students_subjects"
    @JoinTable(name = "students_subjects",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name = "subject_id", referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<>(); //dung set, khong dung list vi trong set khong co 2 phan tu trung nhau
}

