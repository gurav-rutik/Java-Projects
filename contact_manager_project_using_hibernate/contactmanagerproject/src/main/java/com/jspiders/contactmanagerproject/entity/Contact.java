package com.jspiders.contactmanagerproject.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "contacts")
@Data
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private long mobile;

    @Column(name = "work")
    private long work;

    @Column(name = "email")
    private String email;
    
    public Contact() {
    	
    }

    // Constructors, Getters, Setters, and toString() methods...
}
