// StudentBusinessImplementation.java
package com.jspiders.student.business;

import com.jspiders.student.data.StudentData;
import com.jspiders.student.data.StudentDataImplementation;
import com.jspiders.student.entity.Student;

import java.util.Scanner;

public class StudentBusinessImplementation implements StudentBusiness {

    private StudentData data = new StudentDataImplementation();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void addStudent() {
        System.out.println("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Student Class: ");
        String grade = scanner.nextLine();
        Student student = new Student(id, name, grade);
        data.add(student);
        System.out.println("Student added successfully!");
    }

    @Override
    public void updateStudent() {
        System.out.println("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student student = data.findById(id);
        if (student != null) {
            System.out.println("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter New Class: ");
            String grade = scanner.nextLine();
            Student updatedStudent = new Student(id, name, grade);
            data.update(id, updatedStudent);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void deleteStudent() {
        System.out.println("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        data.delete(id);
        System.out.println("Student deleted successfully!");
    }

    @Override
    public void restoreStudent() {
        // Implement restoration logic if needed
    }

    @Override
    public void searchByName() {
        System.out.println("Enter Student Name to search: ");
        String name = scanner.next();
        Student student = data.findByName(name);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void searchByClass() {
        System.out.println("Enter Class to search: ");
        String grade = scanner.next();
        Student student = data.findByClass(grade);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void graduateStudent() {
        System.out.println("Enter Student ID to mark as graduated: ");
        int id = scanner.nextInt();
        Student student = data.findById(id);
        if (student != null) {
            student.setStatus("Graduated");
            System.out.println("Student marked as graduated!");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void markDropout() {
        System.out.println("Enter Student ID to mark as dropout: ");
        int id = scanner.nextInt();
        Student student = data.findById(id);
        if (student != null) {
            student.setStatus("Dropped out");
            System.out.println("Student marked as dropout!");
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void showAllStudents() {
        Student[] allStudents = data.getAllStudents();
        if (allStudents.length == 0) {
            System.out.println("No students available.");
        } else {
            System.out.println("All Students:");
            for (Student student : allStudents) {
                if (student != null) {
                    System.out.println(student);
                }
            }
        }
    }
}
