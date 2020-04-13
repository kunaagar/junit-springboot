package com.practice.unittesting.dto;

public class AddressDTO {

    private Integer pincode;
    private String city;

    public AddressDTO() {
    }

    public AddressDTO(Integer pinCode, String city) {
        this.pincode = pinCode;
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
