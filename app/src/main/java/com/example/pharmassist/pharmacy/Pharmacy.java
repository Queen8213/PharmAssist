package com.example.pharmassist.pharmacy;

public class Pharmacy {
    private String name;
    private String province;
    private String city;
    private String streetNumber;
    private String contactNumber;

    public Pharmacy(String name, String province, String city, String streetNumber, String contactNumber) {
        this.name = name;
        this.province = province;
        this.city = city;
        this.streetNumber = streetNumber;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

}
