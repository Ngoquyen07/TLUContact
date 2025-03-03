package com.example.tlucontact;

public class DBDV {
    private String Name , PhoneNumber , Address;
    private int SymbolImage;

    public DBDV() {
    }

    public DBDV(String address, String name, String phoneNumber, int symbolImage) {
        Address = address;
        Name = name;
        PhoneNumber = phoneNumber;
        SymbolImage = symbolImage;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getSymbolImage() {
        return SymbolImage;
    }

    public void setSymbolImage(int symbolImage) {
        SymbolImage = symbolImage;
    }
}
