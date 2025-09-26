package com.example.demo.entity;

import java.time.LocalDate;

public class KhachHang {
    private int id;
    private String name;
    private LocalDate birthDay;
    private String address;
    private String anh;

    public KhachHang() {
    }

    public KhachHang(int id, String name, LocalDate birthDay, String address, String anh) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
