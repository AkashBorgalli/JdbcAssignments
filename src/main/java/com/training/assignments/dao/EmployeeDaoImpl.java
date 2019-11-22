package com.training.assignments.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.DbUtil.DbUtil;
import com.training.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public boolean addNewEmployee(Employee employee) {
		String query = "INSERT INTO employees VALUES(?, ?, ?, ?)";

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getName());
			statement.setString(3, employee.getDepartment());
			statement.setDouble(4, employee.getSalary());

			int count = statement.executeUpdate();
			if (count != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	
	
	
	public boolean deleteNewEmployee(int employeeId) {
		String query = "DELETE FROM employees WHERE empid = " + employeeId;

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			int count = statement.executeUpdate();
			if (count != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	
	public List<Employee> findAllEmployees() {
		String query = "SELECT * FROM employees";
		List<Employee> employees = new ArrayList<Employee>();

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			while (result.next()) {
				Employee employee = new Employee(result.getInt(1), result.getString(2), result.getString(3),
						result.getDouble(4));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	
	
	
	
	public Employee findEmployeeById(int employeeId) {
		String query = "SELECT * FROM employees WHERE empid = " + employeeId;
		Employee employee = null;

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			if (result.next())
				employee = new Employee(result.getInt(1), result.getString(2), result.getString(3),
						result.getDouble(4));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
		
	}

	
	
	
	
	
	public boolean updateEmployee(int id,double sal,String dep) {
		Employee employee=findEmployeeById(id);
		String query = "UPDATE employees SET design=?, salary=? WHERE empid=?";

		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, dep);
			statement.setDouble(2, sal);
			statement.setInt(3, employee.getEmployeeId());

			int count = statement.executeUpdate();
			if (count != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
