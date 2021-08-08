package com.example.testtask.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BloodInfo {

    private Character bloodGroup;
    private Character rh;


    public Character getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Character bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Character getRh() {
        return rh;
    }

    public void setRh(Character rh) {
        this.rh = rh;
    }

    @Override
    public String toString() {
        return "Группа крови: " + bloodGroup +
                ", резус фактор:" + rh;
    }
}
