package edu.ung.jrcrav8591.CompanyProject;

public class Company {
	
	//Instance variables to be used in the Company object
	private String companyName, companyLocation;
	private int maxEmployees, maxSupervisors;
	private Employee[] employeeArray;
	private Supervisor[] supervisorArray;
	
	//Set up constructor to take in instance variables.
	public Company(String name, String location, int employees, int supervisors)
	{
		companyName = name;
		companyLocation = location;
		maxEmployees = employees;
		maxSupervisors = supervisors;
		employeeArray = new Employee[maxEmployees];
		supervisorArray = new Supervisor[maxSupervisors];
	}
	
	//Method to print all employees
	public String printEmployees()
	{
		String print = "";
		int i = 0;
		while (i < employeeArray.length)
		{
		 if (employeeArray[i] == null)
			 break;
		 else
			 print += employeeArray[i].toString() + "\n";
		 i += 1;
		}
		return print;
	}
	
	//Method to prnt the list of supervisors
	public String printSupervisors()
	{
		String printSupervisor = "";
		int i = 0;
		while (i < supervisorArray.length)
		{
		 if (supervisorArray[i] == null)
			 break;
		 else
			 printSupervisor += supervisorArray[i].toString() + "\n";
		 i += 1;
		}
		return printSupervisor;
	}
	
	//Linear search to find out if a specified person is an employee in the system
	public String findEmployee(String name)
	{
		int i = 0, index = employeeArray.length;
		while (i < employeeArray.length && employeeArray[i] != null)
		{
			if (employeeArray[i].getName().equalsIgnoreCase(name)){
				index = i;
				break;
			}
			i += 1;
		}
		if (index == employeeArray.length)
			return "This employee is not in the system";
		return "This employee is in the system";
	}
	
	//Finds and returns specified employee
	public Employee getEmployee(String name){
		Employee employee = null;
		int i = 0;
		while (i < employeeArray.length && employeeArray[i] != null)
		{
			if (employeeArray[i].getName().equalsIgnoreCase(name)){
				employee = employeeArray[i];
				break;
			}
			i += 1;
		}
		return employee;
	}
	
	//Add an employee to the list
	public String addEmployee(Employee newEmployee) 
	{
		int i = 0;
		String add = "The list is already full";  
		while (i < employeeArray.length)
		{
			if (employeeArray[i] == null)
			{
				employeeArray[i] = newEmployee;
				add = "You have added: " + newEmployee.getName();
				break;
			}
			else if (employeeArray[i].getSocial().equals(newEmployee.getSocial()))
			{
				add = "An employee with this social security number is already in the system.";
				break;
			}
			else if (i == employeeArray.length)
			{
				break;
			}
			i += 1;
		}
		return add;
	}
	
	//Add a supervisor to the list
	public void addSupervisor(Supervisor newSupervisor)
	{
		int i = 0;
		while (i < supervisorArray.length)
		{
			if (supervisorArray[i] == null)
			{
				supervisorArray[i] = newSupervisor;
				break;
			}					
			i += 1;
		}
	}
	
	//Method to remove an employee from the system. If that employee is a supervisor, then it will also remove them from the supervisor list
	public String removeEmployee(String name)
	{
		int i = 0;
		String remove = "This name was not found.";
		while (i < employeeArray.length && employeeArray[i] != null)
		{
			if (employeeArray[i].getName().equalsIgnoreCase(name))
			{
				if (employeeArray[i+1] == null)
					employeeArray[i] = null;
				else {
					employeeArray[i] = employeeArray[i+1];
					employeeArray[i+1] = null;
				}
				remove = "You have successfully removed " + name;
			}
			i += 1;
		}
		
		int j = 0;
		while (j < supervisorArray.length && supervisorArray[j] != null)
		{
			if (supervisorArray[j].getName().equalsIgnoreCase(name))
			{
				if (supervisorArray[j+1] == null)
					supervisorArray[j] = null;
				else {
					supervisorArray[j] = supervisorArray[j+1];
					supervisorArray[j+1] = null;
				}	
			}
			j += 1;
		}
		return remove;
	}
	
	//Removes a specified supervisor from the supervisor array. This method does not remove them from the employee list.
	public void removeSupervisor(String name)
	{
		int i = 0;
		while (i < supervisorArray.length && supervisorArray[i] != null)
		{
			if (supervisorArray[i].getName().equalsIgnoreCase(name))
			{
				if (supervisorArray[i+1] == null)
					supervisorArray[i] = null;
				else
					supervisorArray[i] = supervisorArray[i+1];
			} 
		}
	}
	
	//toString() method to print the information of a company
	public String toString()
	{
		String summary = "";
		if (employeeArray[0] == null)
		{
			summary = "Company Name: " + companyName
					+ "\n Company Location: " + companyLocation
					+ "\n There are currently no employees.";
		}
		else if (employeeArray[1] == null)
		{
			summary = "Company Name: " + companyName
					+ "\n Company Location: " + companyLocation
					+ "\n Only employee: " + employeeArray[0].getName();
		}
		else if (employeeArray[2] == null)
		{
			summary = "Company Name: " + companyName
			+ "\n Company Location: " + companyLocation
			+ "\n First 2 Employees: " + "\n" + employeeArray[0].getName()
			+ "\n" + employeeArray[1].getName();
		}
		else
		{
			summary = "Company Name: " + companyName
					+ "\nCompany Location: " + companyLocation
					+ "\nFirst 3 Employees: " + "\n" + employeeArray[0].getName()
					+ "\n"+ employeeArray[1].getName()
					+ "\n"+ employeeArray[2].getName();
		}
		return summary;
				
	}
	
}
