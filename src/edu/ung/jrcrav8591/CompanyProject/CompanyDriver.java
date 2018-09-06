package edu.ung.jrcrav8591.CompanyProject;
import java.util.Scanner;
public class CompanyDriver {

	public static void main(String[] args){
		int exit = 0;
		Company newCompany = new Company("", "", 0, 0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the company creater");
		System.out.println("Please choose from one of the following options");
		while (exit != 9)
		{	
			System.out.println("1. Create a new company");
			System.out.println("2. Print the company's information");
			System.out.println("3. Add a new employee");
			System.out.println("4. Find out if an employee is already in the system.");
			System.out.println("5. Remove an existing employee");
			System.out.println("6. Print the list of all employees");
			System.out.println("7. Print the list of all supervisors");
			System.out.println("8. Update an existing employee's information");
			System.out.println("9. Exit the program");
			System.out.print("What would you like to do?: ");
			int choice = sc.nextInt();
			if (choice == 1)
			{
				System.out.print("What is the name of your company?: ");
				String companyName = sc.next();
				System.out.print("Where is your company located?: ");
				String location = sc.next();
				System.out.print("What is the maximum number of employees in your company?: ");
				int maxEmployees = sc.nextInt();
				System.out.print("What is the maximum number of supervisors in your company?: ");
				int maxSupervisors = sc.nextInt();
				if (maxSupervisors > maxEmployees)
					System.out.println("There can not be more supervisors than employees.");
				else
					newCompany = new Company(companyName, location, maxEmployees, maxSupervisors);
			}
			
			else if (choice == 2)
			{
				try{
				System.out.println(newCompany.toString());
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("There is no company information to print.");
				}
			}
			
			else if (choice == 3)
			{
				Employee newEmployee = new Employee("","","","","","","",false);
				System.out.print("What is the new employee's name?: ");
				String employeeName = sc.next();
				newEmployee.setName(employeeName);
				System.out.print("What is the employee's social security number?: (xxx-xx-xxxx): ");
				String employeeSocial = sc.next();
				newEmployee.setSocial(employeeSocial);
				System.out.print("What is the employee's phone number? (xxx-xxx-xxxx): ");
				String phone = sc.next();
				newEmployee.setPhone(phone);
				System.out.print("What is the employee's email address?: ");
				String email = sc.next();
				newEmployee.setEmail(email);
				System.out.print("What is the employee's date of birth? (mm/dd/yyyy): ");
				String dob = sc.next();
				newEmployee.setDob(dob);
				System.out.print("What is the employee's start date? (mm/dd/yyyy): ");
				String startDate = sc.next();
				newEmployee.setStartDate(startDate);
				System.out.print("What is the social security number of the employee's supervisor? (xxx-xx-xxxx): ");
				String supervisorSocial = sc.next();
				newEmployee.setSupervisorSsn(supervisorSocial);
				double random = Math.random();
				boolean supervisor;
				if (random < 0.5)
					supervisor = false;
				else
					supervisor = true;
				newEmployee.setSupervisor(supervisor);
				
				System.out.println(newCompany.addEmployee(newEmployee));
				if (newEmployee.getSupervisor()) {
					Supervisor newSupervisor = new Supervisor(employeeName, employeeSocial);
					newCompany.addSupervisor(newSupervisor);
				}
			}
			else if (choice == 4)
			{
				System.out.print("What is the employee's name?: ");
				String name = sc.next();
				System.out.println(newCompany.findEmployee(name));
			}
			
			else if (choice == 5)
			{
				System.out.print("What is the name of the employee you want to remove?: ");
				String name = sc.next();
				System.out.println(newCompany.removeEmployee(name));
			}
			
			else if (choice == 6)
			{
				System.out.println(newCompany.printEmployees());
			}
			
			else if (choice == 7)
			{
				System.out.println(newCompany.printSupervisors());
			}
			else if (choice == 8){
				System.out.print("What is the name of the employee you want to update?: ");
				String name = sc.next();
				if (newCompany.getEmployee(name) != null)
				{
					Employee updateEmployee = newCompany.getEmployee(name);
					System.out.print("What is the employee's new name?: ");
					String employeeName = sc.next();
					updateEmployee.setName(employeeName);
					System.out.print("What is the employee's social security number?: (xxx-xx-xxxx): ");
					String employeeSocial = sc.next();
					updateEmployee.setSocial(employeeSocial);
					System.out.print("What is the employee's phone number? (xxx-xxx-xxxx): ");
					String phone = sc.next();
					updateEmployee.setPhone(phone);
					System.out.print("What is the employee's email address?: ");
					String email = sc.next();
					updateEmployee.setEmail(email);
					System.out.print("What is the employee's date of birth? (mm/dd/yyyy): ");
					String dob = sc.next();
					updateEmployee.setDob(dob);
					System.out.print("What is the employee's start date? (mm/dd/yyyy): ");
					String startDate = sc.next();
					updateEmployee.setStartDate(startDate);
					System.out.print("What is the social security number of the employee's supervisor? (xxx-xx-xxxx): ");
					String supervisorSocial = sc.next();
					updateEmployee.setSupervisorSsn(supervisorSocial);
					boolean supervisor;
					System.out.print("Is the employee a supervisor?: ");
					String isSuper = sc.next();
					if (isSuper.equalsIgnoreCase("yes"))
						supervisor = true;
					else
						supervisor = false;
					updateEmployee.setSupervisor(supervisor);
					
				}
				else
					System.out.println("This employee could not be found");
			
			}
			else if (choice == 9)
				exit = 9;	
		}
		sc.close();
	}
}
