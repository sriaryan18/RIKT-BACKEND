package com.Project.RIKT.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="USER")
public class USER {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="UserName")
    private  String userName;

    @Column(name="Name")
    private String Name;

    @Column(name="Hashed Password")
    private String hashPassword;

    private LocalDate dateOfRegistration;



}
