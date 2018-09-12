package edu.ung.jrcrav8591.CompanyProject.model;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeTable {
    public SimpleStringProperty firstName = new SimpleStringProperty();
    public SimpleStringProperty lastName = new SimpleStringProperty();
    public SimpleStringProperty social = new SimpleStringProperty();
    public SimpleStringProperty phone = new SimpleStringProperty();
    public SimpleStringProperty email = new SimpleStringProperty();
    public SimpleStringProperty dob = new SimpleStringProperty();
    public SimpleStringProperty startDate = new SimpleStringProperty();

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getSocial() {
        return social.get();
    }

    public SimpleStringProperty socialProperty() {
        return social;
    }

    public void setSocial(String social) {
        this.social.set(social);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDob() {
        return dob.get();
    }

    public SimpleStringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public SimpleStringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }
}
