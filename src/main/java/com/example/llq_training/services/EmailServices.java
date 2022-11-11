package com.example.llq_training.services;

import com.example.llq_training.dto.Filter;
import com.example.llq_training.models.EmailThongTinNguoiGui;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface EmailServices {

     void insert(EmailThongTinNguoiGui email);

     List<EmailThongTinNguoiGui> findAll();
     EmailThongTinNguoiGui findById(EmailThongTinNguoiGui emailFind);
     Page<EmailThongTinNguoiGui> filter(Filter filter);
     String update(EmailThongTinNguoiGui email);
}
