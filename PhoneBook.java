package com.phonebook;

public class PhoneBook {
    private String name;
    private String phone;

    public PhoneBook(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PhoneBook" +
                " name: " + name + '\n' +
                " phone: " + phone ;
    }
}
