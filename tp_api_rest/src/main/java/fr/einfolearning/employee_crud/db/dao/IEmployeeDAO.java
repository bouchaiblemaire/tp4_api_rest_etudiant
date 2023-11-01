package fr.einfolearning.employee_crud.db.dao;

import fr.einfolearning.employee_crud.beans.Employee;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



public interface IEmployeeDAO {

	// 1- Insert new Employee
	public Employee addEmployee(Employee employee) throws SQLException;
	
	// 2- Delete an Employee
	public boolean deleteEmployee(int employeeId) throws SQLException;
	
	// 3- Update an Employee
	public Employee updateEmployee(Employee employee) throws SQLException;
	
	// 4- Get an Employee using Employee ID
	public Employee getEmployee(int employeeId) throws SQLException;
	
	// 5- Get All Employees
	public List<Employee> getAllEmployees() throws SQLException;
}
