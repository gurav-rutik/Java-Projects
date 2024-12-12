package com.jspiders.employee_leave_management_system.service;

import com.jspiders.employee_leave_management_system.dao.EmployeeDAO;
import com.jspiders.employee_leave_management_system.entity.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void addEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }
}
