package com.jspiders.employee_leave_management_system.service;

import com.jspiders.employee_leave_management_system.dao.LeaveRequestDAO;
import com.jspiders.employee_leave_management_system.entity.LeaveRequest;

import java.util.List;

public class LeaveRequestService {
    private LeaveRequestDAO leaveRequestDAO = new LeaveRequestDAO();

    public void applyForLeave(LeaveRequest leaveRequest) {
        leaveRequestDAO.saveLeaveRequest(leaveRequest);
    }

    public List<LeaveRequest> getLeaveRequestsByEmployeeId(int employeeId) {
        return leaveRequestDAO.getLeaveRequestsByEmployeeId(employeeId);
    }
}