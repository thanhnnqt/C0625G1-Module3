package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.IKhachHangRepository;
import com.example.demo.repository.KhachHangRepository;

import java.util.List;

public class KhachHangService implements IKhachHangService{
    private final IKhachHangRepository khachHangRepository = new KhachHangRepository();
    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public boolean add(KhachHang khachHang) {
        return khachHangRepository.add(khachHang);
    }
}
