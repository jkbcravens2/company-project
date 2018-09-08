package edu.ung.jrcrav8591.CompanyProject.model;

import edu.ung.jrcrav8591.CompanyProject.model.Employee;

//Supervisor object inherits from the Employee object
public class Supervisor extends Employee {
	public Supervisor(String firstName, String lastName, String social)
	{
		super(firstName, lastName, social);
	}
	
	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName(){return lastName;}

	public String getSocial()
	{
		return social;
	}

}
