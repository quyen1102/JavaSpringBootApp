package com.example.llq_training.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Clob;
import java.sql.Date;

@Entity
@Table(name="EMAIL_THONG_TIN_GUI")
@DynamicUpdate
public class EmailThongTinNguoiGui {
    @Id
    private long id;

    @Override
    public String toString() {
        return "EmailThongTinNguoiGui{" +
                "id=" + id +
                ", emailTo='" + emailTo + '\'' +
                ", emailCc='" + emailCc + '\'' +
                ", noiDung='" + noiDung + '\'' +
                ", ngayTao=" + ngayTao +
                ", chucNang='" + chucNang + '\'' +
                ", ngayGui=" + ngayGui +
                ", trangThaiGui=" + trangThaiGui +
                '}';
    }

    @Column(name="email_to" )
    private String emailTo;
    @Column(name="email_cc")
    private String emailCc;
    @Column(name="noi_dung")
    private String noiDung;
    @Column(name="ngay_tao")
    private Date ngayTao;
    @Column(name="chuc_nang")
    private String chucNang;
    @Column(name="ngay_gui")
    private Date ngayGui;

    public int getTrangThaiGui() {
        return trangThaiGui;
    }

    public void setTrangThaiGui(int trangThaiGui) {
        this.trangThaiGui = trangThaiGui;
    }

    @Column(name="trang_thai_gui")
    private int trangThaiGui;

    public EmailThongTinNguoiGui() {
        super();
    }

    public EmailThongTinNguoiGui(int id,
                                 String emailTo,
                                 String emailCc,
                                 String noiDung,
                                 Date ngayTao,
                                 String chucNang,
                                 Date ngayGui,
                                 int trangThaiGui) {
        this.id = id;
        this.emailTo = emailTo;
        this.emailCc = emailCc;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
        this.chucNang = chucNang;
        this.ngayGui = ngayGui;
        this.trangThaiGui = trangThaiGui;
    }

    public EmailThongTinNguoiGui(String emailTo,
                                 String emailCc,
                                 String noiDung,
                                 Date ngayTao,
                                 String chucNang,
                                 Date ngayGui,
                                 int trangThaiGui) {
        this.emailTo = emailTo;
        this.emailCc = emailCc;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
        this.chucNang = chucNang;
        this.ngayGui = ngayGui;
        this.trangThaiGui = trangThaiGui;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailCc() {
        return emailCc;
    }

    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getChucNang() {
        return chucNang;
    }

    public void setChucNang(String chucNang) {
        this.chucNang = chucNang;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

}
