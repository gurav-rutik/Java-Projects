// StudentDataImplementation.java
package com.jspiders.student.data;

import com.jspiders.student.entity.Student;

public class StudentDataImplementation implements StudentData {

    private Student[] students = new Student[10];
    private int index = 0;

    @Override
    public void add(Student student) {
        if (index == students.length) {
            expandCapacity();
        }
        students[index++] = student;
    }

    @Override
    public void update(int id, Student updatedStudent) {
        for (int i = 0; i < index; i++) {
            if (students[i].getId() == id) {
                students[i] = updatedStudent;
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < index; i++) {
            if (students[i].getId() == id) {
                students[i] = null;
                normalizeArray(i);
                break;
            }
        }
    }

    @Override
    public Student findByName(String name) {
        for (int i = 0; i < index; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                return students[i];
            }
        }
        return null;
    }

    @Override
    public Student findByClass(String grade) {
        for (int i = 0; i < index; i++) {
            if (students[i].getGrade().equalsIgnoreCase(grade)) {
                return students[i];
            }
        }
        return null;
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < index; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    @Override
    public Student[] getAllStudents() {
        Student[] allStudents = new Student[index];
        for (int i = 0; i < index; i++) {
            allStudents[i] = students[i];
        }
        return allStudents;
    }

    private void expandCapacity() {
        Student[] temp = new Student[students.length * 2];
        for (int i = 0; i < index; i++) {
            temp[i] = students[i];
        }
        students = temp;
    }

    private void normalizeArray(int pos) {
        for (int i = pos; i < index - 1; i++) {
            students[i] = students[i + 1];
        }
        index--;
    }
}
