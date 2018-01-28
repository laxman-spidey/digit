package com.example.cgi.digit.models;

/**
 * Created by laxman on 28/01/18.
 */

public class House {
    public String id;
    public String houseTax;
    public String electricityNumber;
    public String aadharNumber;
    public String gasConnectionNumber;
    public String waterBillNumber;
    public String rationCardNumber;
    public String address;
    public String phoneNumber;

    public static House getDummyHouse() {
        House house = new House();
        house.houseTax = "tax";
        house.electricityNumber = "1234567";
        house.aadharNumber = "23456789";
        house.gasConnectionNumber = "2345678";
        house.waterBillNumber = "23456789";
        house.rationCardNumber = "1234567";
        house.address = "skdljas, jjdsfs, sdfsd";
        house.phoneNumber = "1234567890";
        return house;
    }
}
