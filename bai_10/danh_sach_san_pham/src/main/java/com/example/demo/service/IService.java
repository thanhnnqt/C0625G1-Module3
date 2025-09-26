package com.example.demo.service;

import com.example.demo.entity.KhachHang;

import java.util.List;

public interface IService {
    List<KhachHang> findAll();
    boolean add(KhachHang khachHang);
}
