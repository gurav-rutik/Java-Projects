package com.jspiders.employee_leave_management_system.dao;

import com.jspiders.employee_leave_management_system.entity.Employee;
import com.jspiders.employee_leave_management_system.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeDAO {
    public void saveEmployee(Employee employee) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Employee getEmployeeById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(Employee.class, id);
        } finally {
            entityManager.close();
        }
    }
}