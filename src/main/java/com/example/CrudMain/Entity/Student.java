package com.example.CrudMain.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "student")
@Table(name = "student", schema = "public")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stdid")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "fathersname")
    private String father;
    @Column(name = "age")
    private int age;
    @Column(name = "dob")
    private String dob;
    @Column(name = "phnumber")
    private String phnumber;
    @Column(name = "gender")
    private String gender;

}
