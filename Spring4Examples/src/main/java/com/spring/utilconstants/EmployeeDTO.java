package com.spring.utilconstants;

public class EmployeeDTO {

	public static final EmployeeDTO MANAGER = new EmployeeDTO("manager");
	public static final EmployeeDTO DIRECTOR = new EmployeeDTO("director");

	private Integer id;
	private String firstName;
	private String lastName;
	private String designation;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String designation) {
		this.id = -1;
		this.firstName = "dummy";
		this.lastName = "dummy";
		this.designation = designation;
	}

	public void initBean() {
		System.out.println("Init Bean for : EmployeeDAOImpl");
	}

	public void destroyBean() {
		System.out.println("Init Bean for : EmployeeDAOImpl");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", type=" + designation + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}