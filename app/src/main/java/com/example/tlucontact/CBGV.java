package com.example.tlucontact;

public class CBGV {
    private String Name , Position , PhoneNumber,Email , WordUnit;
    private int AvatarImage;
    public CBGV() {
    }

    public CBGV(int avatarImage, String email, String name, String phoneNumber, String position, String wordUnit) {
        AvatarImage = avatarImage;
        Email = email;
        Name = name;
        PhoneNumber = phoneNumber;
        Position = position;
        WordUnit = wordUnit;
    }

    public int getAvatarImage() {
        return AvatarImage;
    }

    public void setAvatarImage(int avatarImage) {
        AvatarImage = avatarImage;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getWordUnit() {
        return WordUnit;
    }

    public void setWordUnit(String wordUnit) {
        WordUnit = wordUnit;
    }
}
