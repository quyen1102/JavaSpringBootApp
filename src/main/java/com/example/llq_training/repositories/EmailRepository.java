package com.example.llq_training.repositories;

import com.example.llq_training.models.EmailThongTinNguoiGui;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailThongTinNguoiGui, Long>, JpaSpecificationExecutor<EmailThongTinNguoiGui> {

}
