package com.jspiders.employee_leave_management_system.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "leaveBalance")
    private int leaveBalance;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "salary")
    private double salary;  // Ensure salary field is defined

    // Getters and setters
}
