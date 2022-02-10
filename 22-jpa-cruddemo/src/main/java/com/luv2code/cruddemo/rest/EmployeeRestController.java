package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // get a single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        return employee;
    }

    // create a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // set employee id to 0 in order to add
        employee.setId(0);

        employeeService.save(employee);

        return employee;
    }

    // update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }

    // delete employee by id
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id: " + employeeId;
    }
}
