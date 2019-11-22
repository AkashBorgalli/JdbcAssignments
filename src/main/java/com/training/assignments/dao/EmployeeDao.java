package com.training.assignments.dao;

import java.util.List;

import com.training.model.Employee;

public interface EmployeeDao {

	public boolean addNewEmployee(Employee employee);	
	public boolean deleteNewEmployee(int employeeId);
	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(int employeeId);
	public boolean updateEmployee(int id,double sal,String dep);

}
