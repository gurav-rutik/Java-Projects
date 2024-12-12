// Student.java
package com.jspiders.student.entity;

public class Student {
    private int id;
    private String name;
    private String grade;
    private String status;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.status = "Enrolled";  // Default status is "Enrolled"
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", status=" + status + "]";
    }
}
