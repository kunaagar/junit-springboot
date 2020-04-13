package com.practice.unittesting.dto;

public class Address {

    private Integer pinCode;
    private String city;

    public Address() {
    }

    public Address(Integer pinCode, String city) {
        this.pinCode = pinCode;
        this.city = city;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
