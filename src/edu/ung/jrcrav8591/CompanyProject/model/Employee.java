package edu.ung.jrcrav8591.CompanyProject.model;

public class Employee {
	
	//Instance variables for Employee class
    String firstName, lastName;
	String social;
	private String phone, email, dob, startDate;
	
	//Basic constructor. Only takes in name and ssn
	public Employee(String firstName, String lastName, String social)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.social = social;
	}
	
	//Overloads basic constructor. Takes in all Employee information
	public Employee(String firstName, String lastName, String social, String phone, String email, String dob, String startDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.social = social;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.startDate = startDate;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName(){ return lastName; }
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email= email;
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

	public void setSocial(String social){this.social = social;}

	public String getSocial(){return social;}

}
