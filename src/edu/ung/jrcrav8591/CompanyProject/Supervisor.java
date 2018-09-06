package edu.ung.jrcrav8591.CompanyProject;
public class Supervisor extends Employee {
	public Supervisor(String superName, String superSocial)
	{
		super(superName, superSocial);
	}
	
	public String getName()
	{
		return fullName;
	}
	
	public String getSocial()
	{
		return ssn;
	}
	
	public String toString()
	{
		return "Supervisor Information \n Name: " + getName()
		       + "\n Social Security Number: " + getSocial();
	}

}
