package edu.ung.jrcrav8591.CompanyProject.model;

public class Company {
	
	//Instance variables to be used in the Company object
	private String name, address, address2, city, state, zip;
	
	//Set up constructor to take in instance variables.
	public Company(String name, String address, String address2, String city, String state, String zip)
	{
		this.name = name;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
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

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
