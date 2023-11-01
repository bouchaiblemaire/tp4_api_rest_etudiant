package fr.einfolearning.employee_crud.db.dao;

import fr.einfolearning.employee_crud.beans.Employee;
import fr.einfolearning.employee_crud.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements IEmployeeDAO
{	
	static Connection connection = DBConnection.getInstance();

	@Override
	public Employee addEmployee(Employee employee) throws SQLException 
	{
	
			String insertStatement = "INSERT INTO employee (name, email, phone, address) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getName());		
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getAddress());
			
                        System.out.println(preparedStatement);
			int result = preparedStatement.executeUpdate();
			return result == 1 ? employee : null;
		
		
	}
	
	@Override
	public boolean deleteEmployee(int id) throws SQLException 
	{
		try
		{
			String deleteStatement = "delete from employee where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
			
			preparedStatement.setInt(1, id);
			return  preparedStatement.executeUpdate() == 1 ? true : false;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee getEmployee(int id)
	{
		try
		{
			String query = "select * from employee where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			Employee employee = new Employee();
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) 
			{
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPhone(resultSet.getString("phone"));
			}
			return employee;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException 
	{
		try
		{		
			String query = "SELECT * FROM employee;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();

			while(rs.next()) 
			{
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAddress(rs.getString("address"));
				emp.setPhone(rs.getString("phone"));
				emp.setEmail(rs.getString("email"));
				
				employees.add(emp);
			}
			
			return employees;			
		}
		catch (Exception e) {
			System.out.println("exception===================" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) throws SQLException 
	{
		try
		{
			String query = "update employee SET name = ?, email = ?, phone = ?, address = ? WHERE id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());		
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getAddress());
			preparedStatement.setInt(5, employee.getId());
			
			return preparedStatement.executeUpdate() == 1 ? employee : null;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) throws SQLException 
	{
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		Employee employee = new Employee();
		//employee.setId(10);
		employee.setName("Jennifer1");
		employee.setEmail("jennifer@gamil.com");
		employee.setPhone("00335446666");
		employee.setAddress("Spain");
		//boolean result = employeeDAOImpl.addEmployee(employee);
		//employeeDAOImpl.updateEmployee(employee);
		//Employee employee2 = employeeDAOImpl.getEmployee(10);
		//List<Employee> employees = new ArrayList<Employee>();
		//employees = employeeDAOImpl.getAllEmployees();
		//boolean result = employeeDAOImpl.deleteEmployee(10);
		//System.out.println(result);
		
		List<Employee> employees = employeeDAOImpl.getAllEmployees();
		System.out.println("listAllEmployees employees size ==>" + employees.size());
				
	}
}

