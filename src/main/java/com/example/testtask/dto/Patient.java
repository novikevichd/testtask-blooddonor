package com.example.testtask.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {

    private String firstName;
    private String lastName;
    private BloodInfo bloodInfo;


    public Patient() {
    }

    public Patient(String firstName, String lastName, BloodInfo bloodInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodInfo = bloodInfo;
    }


    public BloodInfo getBloodInfo() {
        return bloodInfo;
    }

    public void setBloodInfo(BloodInfo bloodInfo) {
        this.bloodInfo = bloodInfo;
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

    @Override
    public String toString() {
        return "{ Имя: " + firstName +
                ", Фамилия: " + lastName +
                ", Анализ крови -  " + bloodInfo + " }";
    }
}