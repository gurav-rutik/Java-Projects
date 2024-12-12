package com.jspiders.employee_leave_management_system;

import com.jspiders.employee_leave_management_system.entity.Employee;
import com.jspiders.employee_leave_management_system.entity.LeaveRequest;
import com.jspiders.employee_leave_management_system.service.EmployeeService;
import com.jspiders.employee_leave_management_system.service.LeaveRequestService;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        LeaveRequestService leaveRequestService = new LeaveRequestService();

     // Add an employee
        Employee employee = new Employee();
        employee.setName("Rutik Gurav");
        employee.setRole("Java Developer");
        employee.setLeaveBalance(20);
        employee.setMobile("9011715158");
        employee.setSalary(50000.0); // Ensure salary is set
        employeeService.addEmployee(employee);
        
     // After employee is added, the ID should be set
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeId(employee.getId()); // Correctly set employee ID
        leaveRequest.setStartDate(new Date());
        leaveRequest.setEndDate(new Date());
        leaveRequest.setStatus("Pending");
        leaveRequestService.applyForLeave(leaveRequest);
        
        Employee employee1 = new Employee();
        employee1.setName("Vikas Yelgar");
        employee1.setRole("Web Developer");
        employee1.setLeaveBalance(20);
        employee1.setMobile("1234567890");
        employee1.setSalary(50000.0); // Ensure salary is set
        employeeService.addEmployee(employee1);

        // After employee is added, the ID should be set
        LeaveRequest leaveRequest1 = new LeaveRequest();
        leaveRequest1.setEmployeeId(employee1.getId()); // Correctly set employee ID
        leaveRequest1.setStartDate(new Date());
        leaveRequest1.setEndDate(new Date());
        leaveRequest1.setStatus("Approved");
        leaveRequestService.applyForLeave(leaveRequest1);


        // Fetch employees
        employeeService.getAllEmployees().forEach(System.out::println);

        // Fetch leave requests
        leaveRequestService.getLeaveRequestsByEmployeeId(employee.getId()).forEach(System.out::println);
        leaveRequestService.getLeaveRequestsByEmployeeId(employee1.getId()).forEach(System.out::println);
    }
}



/*
 * src/
├── entity/
│   ├── Employee.java
│   ├── LeaveRequest.java
├── dao/
│   ├── EmployeeDAO.java
│   ├── LeaveRequestDAO.java
├── service/
│   ├── EmployeeService.java
│   ├── LeaveRequestService.java
├── util/
│   ├── HibernateUtil.java
├── main/
│   ├── App.java
resources/
├── Persistence.xml

 */
