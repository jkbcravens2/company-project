package edu.ung.jrcrav8591.CompanyProject;
 
public class Employee {
	
	//Instance variables for Employee class
	protected String fullName;
	protected String ssn;
	private String phoneNumber, emailAddress, dob, startDate;
	private String supervisorSsn;
	private boolean isSupervisor;
	
	//Basic constructor. Only takes in name and ssn
	public Employee(String name, String social)
	{
		fullName = name;
		ssn = social;
	}
	
	//Overloads basic constructor. Takes in all Employee information
	public Employee(String name, String social, String phone, String email, String birthday, String start, 
			String supervisorSocial, boolean supervisor)
	{
		fullName = name;
		ssn = social;
		phoneNumber = phone;
		emailAddress = email;
		dob = birthday;
		startDate = start;
		supervisorSsn = supervisorSocial;
		isSupervisor = supervisor;
	}
	
	//Getters and setters for Employee object parameters
	public String getSocial()
	{
		return ssn;
	}
	public void setSocial(String ssn)
	{
		this.ssn = ssn;
	}
	
	public String getName()
	{
		return fullName;
	}
	
	public void setName(String fullName)
	{
		this.fullName = fullName;
	}
	
	public String getPhone()
	{
		return phoneNumber;
	}
	
	public void setPhone(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail()
	{
		return emailAddress;
	}
	
	public void setEmail(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getDob()
	{
		return dob;
	}
	
	public void setDob(String dob)
	{
		this.dob = dob;
	}
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	
	public String getSupervisorSsn()
	{
		return supervisorSsn;
	}
	
	public void setSupervisorSsn(String supervisorSsn)
	{
		this.supervisorSsn = supervisorSsn;
	}
	
	public boolean getSupervisor()
	{
			return isSupervisor;
	}
	
	public void setSupervisor(boolean supervisor)
	{
		isSupervisor = supervisor;
	}
	
	//Returns whether one employee is the same as another employee
	public boolean equals(Employee e)
	{
		boolean same = false;
		if (getSocial() == e.getSocial())
			same = true;
		return same;
	}
	
	//toString() method prints employee information
	public String toString()
	{
		return "Employee Information" + "\n Name: " + getName() 
				+ "\n Social Security Number: " + getSocial() + "\n Phone Number: " + getPhone()
				+ "\n Email Address: " + getEmail() + "\n Date of Birth: " + getDob()
				+ "\n Start Date: " + getStartDate() + "\n Supervisor's SSN: " + getSupervisorSsn()
				+ "\n Is a Supervisor?: " + getSupervisor();
	}
	

}
