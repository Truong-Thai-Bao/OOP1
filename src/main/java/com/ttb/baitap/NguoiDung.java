package com.ttb.baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NguoiDung {

    private String hoTen;

    private String queQuan;

    private String gioiTinh;

    private LocalDate ngaySinh;

    private LocalDate ngayGiaNhap;
    
    private double diem;


    public void hienThi() {
    System.out.printf("| %-25s  | %-20s | %-8s   | %-15s  | %-15s  |\n", getHoTen(), getQueQuan(), getGioiTinh(), getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.TIME)), getNgayGiaNhap().format(DateTimeFormatter.ofPattern(CauHinh.TIME)));
    
    }

    public NguoiDung(String hoTen, String queQuan, String gioiTinh, LocalDate ngaySinh, LocalDate ngayGiaNhap, double diem) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayGiaNhap = ngayGiaNhap;
        this.diem=diem;
    }
    public NguoiDung(String hoTen, String queQuan, String gioiTinh, String ngaySinh, String ngayGiaNhap,String diem) {
        this(hoTen, queQuan, gioiTinh,LocalDate.parse( ngaySinh,DateTimeFormatter.ofPattern(CauHinh.TIME)), 
                LocalDate.parse( ngayGiaNhap,DateTimeFormatter.ofPattern(CauHinh.TIME)),Double.parseDouble(diem));
    }
    
    
    public String ngaySinhToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CauHinh.TIME);
        return this.ngaySinh.format(formatter);
    }
    
    public String ngayGiaNhapToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CauHinh.TIME);
        return this.ngayGiaNhap.format(formatter);
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayGiaNhap
     */
    public LocalDate getNgayGiaNhap() {
        return ngayGiaNhap;
    }

    /**
     * @param ngayGiaNhap the ngayGiaNhap to set
     */
    public void setNgayGiaNhap(LocalDate ngayGiaNhap) {
        this.ngayGiaNhap = ngayGiaNhap;
    }

    /**
     * @return the diem
     */
    public double getDiem() {
        return diem;
    }

    /**
     * @param diem the diem to set
     */
    public void setDiem(double diem) {
        this.diem = diem;
    }
    
    

}
