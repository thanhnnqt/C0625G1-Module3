package com.example.demo.repository;

import com.example.demo.entity.KhachHang;

import java.util.List;

public interface IRepository {
    List<KhachHang> findAll();
    boolean add(KhachHang khachHang);
}
