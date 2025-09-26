package com.example.demo.repository;

import com.example.demo.entity.KhachHang;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository implements IKhachHangRepository{
    private static List<KhachHang> khachHangList = new ArrayList<>();
    {
        khachHangList.add(new KhachHang(1, "Mai Văn Hoàn", LocalDate.parse("1983-08-20"), "Hà Nội", "anh/anh1.jpg"));
        khachHangList.add(new KhachHang(2, "Nguyễn Văn Nam", LocalDate.parse("1983-08-21"), "Bắc Giang", "anh/anh2.jpeg"));
        khachHangList.add(new KhachHang(3, "Nguyễn Thái Hòa", LocalDate.parse("1983-08-22"), "Nam Định", "anh/anh3.jpg"));
        khachHangList.add(new KhachHang(4, "Trần Đăng Khoa", LocalDate.parse("1983-08-17"), "Hà Tây", "anh/anh4.jfif"));
        khachHangList.add(new KhachHang(4, "Nguyễn Đình Thi", LocalDate.parse("1983-08-19"), "Hà Nội", "anh/anh5.jpg"));
    }
    @Override
    public List<KhachHang> findAll() {
        return khachHangList;
    }

    @Override
    public boolean add(KhachHang khachHang) {
        return khachHangList.add(khachHang);
    }
}
