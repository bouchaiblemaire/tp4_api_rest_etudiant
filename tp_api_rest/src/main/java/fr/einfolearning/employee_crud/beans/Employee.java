package fr.einfolearning.employee_crud.beans;

import lombok.Data;




//@Data
public class Employee {

	private int id;
	private String name;
	private String address;
	private String email;
	private String phone;

	public Employee() {
		super();
	}

	public Employee(String name, String address, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public Employee(int id, String name, String address, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone="
				+ phone + "]";
	}

	public static void main(String[] args) {
		Employee employee = new Employee();

		employee.setId(1);
		employee.setName("Karim Mahmoud");
		employee.setAddress("Egypt");
		employee.setPhone("009750413948");
		employee.setEmail("kmshawky20@gmail.com");

		System.out.println(employee);
	}
}