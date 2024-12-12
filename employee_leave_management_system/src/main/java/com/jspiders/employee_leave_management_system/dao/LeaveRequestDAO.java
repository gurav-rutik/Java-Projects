package com.jspiders.employee_leave_management_system.dao;

import com.jspiders.employee_leave_management_system.entity.LeaveRequest;
import com.jspiders.employee_leave_management_system.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LeaveRequestDAO {
    public void saveLeaveRequest(LeaveRequest leaveRequest) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(leaveRequest);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<LeaveRequest> getLeaveRequestsByEmployeeId(int employeeId) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.createQuery("FROM LeaveRequest WHERE employeeId = :employeeId", LeaveRequest.class)
                    .setParameter("employeeId", employeeId)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }
}