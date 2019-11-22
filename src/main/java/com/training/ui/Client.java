package com.training.ui;

import java.util.List;
import java.util.Scanner;

import com.training.assignments.dao.EmployeeDao;
import com.training.assignments.dao.EmployeeDaoImpl;
import com.training.model.Employee;

public class Client {

	public static void main(String[] args) {
		Employee employee = null;
		EmployeeDao empdao = new EmployeeDaoImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("----Enter Your Choice-----");
		System.out.println("1.Add Employee Details");
		System.out.println("2.Delete Employee Details");
		System.out.println("3.Find All Employee Details");
		System.out.println("4.Find Employee By Id");
		System.out.println("5.Update Employee");
		System.out.println("6.Exit");
		int num = scanner.nextInt();
		switch (num) {
		case 1:
			System.out.println("Enter employeeId");
			int empId = scanner.nextInt();

			System.out.println("Enter employeeName");
			
			String empName = scanner.next();

			System.out.println("Enter employeeDesignation");
			String empDesgn = scanner.next();

			System.out.println("Enter employeeSalary");
			int empSal = scanner.nextInt();

			 employee = new Employee(empId, empName, empDesgn, empSal);

			if (empdao.addNewEmployee(employee))
				System.out.println("Employee record added successfully.");
			else
				System.out.println("Failed to add Employee record.");

			break;
		case 2:
			System.out.println("Enter Employee Id");
			int Id = scanner.nextInt();

			if(empdao.deleteNewEmployee(Id)) 
				System.out.println("Employee record deleted successfully");
			else
				System.out.println("Employee record not found.");
			break;
		case 3:
			List<Employee> employees = empdao.findAllEmployees();
		    employees.forEach(System.out::println);		
			break;
		case 4:
			System.out.println("Enter Employee Id");
			int eId = scanner.nextInt();
			 Employee emp=empdao.findEmployeeById(eId);
			if(emp != null)
				System.out.println(emp);
			else
				System.out.println("Employee record not found.");
		    break;
		case 5:
			System.out.println("Enter Employee Id");
			int employeeId = scanner.nextInt();
			System.out.println("Enter Employee salary");
			double sal = scanner.nextDouble();
			System.out.println("Enter employeeDesignation");
			String dep = scanner.next();
			 boolean status=empdao.updateEmployee(employeeId,sal,dep);
			if(status =true)
				System.out.println("updated");
			else
				System.out.println("Employee record not found.");
		  
			break;
		case 6:
			System.out.println("Thank You!");
			System.exit(0);
			break;
		
		}

	}

}
