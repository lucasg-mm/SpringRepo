package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        Query theQuery = entityManager.createQuery("from Employee");

        // execute the query
        List<Employee> employees = theQuery.getResultList();

        // return them
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the employee
        Employee employee = entityManager.find(Employee.class, theId);

        // return found employee
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
        // save or update the employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        // update with id from db so we can get generated id for save/insert
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {
        // delete object
        Query theQuery = entityManager.createQuery("delete from Employee where id =: employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
