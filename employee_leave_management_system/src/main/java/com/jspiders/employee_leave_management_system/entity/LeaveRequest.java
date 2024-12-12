package com.jspiders.employee_leave_management_system.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "LeaveRequest")
@Data
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "status")
    private String status;

    // Getters and setters
}
