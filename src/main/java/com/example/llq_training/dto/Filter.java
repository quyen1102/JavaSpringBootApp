package com.example.llq_training.dto;

import com.example.llq_training.models.EmailThongTinNguoiGui;

public class Filter {

    public Page page;
    public EmailThongTinNguoiGui emailThongTinNguoiGui;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public EmailThongTinNguoiGui getEmailThongTinNguoiGui() {
        return emailThongTinNguoiGui;
    }

    public void setEmailThongTinNguoiGui(EmailThongTinNguoiGui emailThongTinNguoiGui) {
        this.emailThongTinNguoiGui = emailThongTinNguoiGui;
    }
}
