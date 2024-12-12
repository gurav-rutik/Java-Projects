// StudentData.java
package com.jspiders.student.data;

import com.jspiders.student.entity.Student;

public interface StudentData {
    void add(Student student);
    void update(int id, Student updatedStudent);
    void delete(int id);
    Student findByName(String name);
    Student findByClass(String grade);
    Student findById(int id);
    Student[] getAllStudents();
}
