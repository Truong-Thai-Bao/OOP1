package com.ttb.baitap;

import com.ttb.baitap.CauHinh;
import java.io.FileNotFoundException;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int choice;
        QLNguoiDung qlnd = new QLNguoiDung();
        QLNguoiDung traCuu = new QLNguoiDung();
        do {
            System.out.println("MENU");
            System.out.println("1. Quan ly nguoi hoc");
            System.out.println("2. Quan ly cau hoi");
            System.out.println("3. Luyen tap");
            System.out.println("4. Thong ke ket qua hoc tap cua hoc vien theo thang");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban (0 de thoat): ");
            choice = Integer.parseInt(CauHinh.SC.nextLine());

            switch (choice) {
                case 1 -> {
                    qlnd.dSNguoiDung();
                    int choice1;
                    do {
                        System.out.println("    1. Xem danh sach nguoi hoc");
                        System.out.println("    2. Tra cuu nguoi hoc");
                        System.out.println("    3. Them nguoi hoc");
                        System.out.println("    4. Cap nhat thong tin hoc vien");
                        System.out.println("    5. Xoa thong tin hoc vien");
                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                        choice1 = Integer.parseInt(CauHinh.SC.nextLine());
                        switch (choice1) {
                            case 1 -> {
                                System.out.println("==========DANH SACH NGUOI DUNG==========");
                                qlnd.hienThiDSNguoiDung();
                                break;
                            }
                            case 2 -> {
                                int choice12;
                                do {
                                    System.out.println("Tra cuu nguoi hoc theo: ");
                                    System.out.println("        1. Theo ho ten");
                                    System.out.println("        2. Theo gioi tinh");
                                    System.out.println("        3. Theo ngay sinh");
                                    System.out.println("        4. Theo que quan");
                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                    choice12 = Integer.parseInt(CauHinh.SC.nextLine());
                                    switch (choice12) {
                                        case 1 -> {
                                            System.out.print("Nhap ho ten: ");
                                            traCuu.setDs(qlnd.traCuu(CauHinh.SC.nextLine()));
                                            traCuu.hienThiDSNguoiDung();
                                            break;
                                        }
                                        case 2 -> {
                                            System.out.print("Nhap gioi tinh: ");
                                            traCuu.setDs(qlnd.traCuu(CauHinh.SC.nextLine()));
                                            traCuu.hienThiDSNguoiDung();
                                        }
                                        case 3 -> {
                                            System.out.print("Nhap ngay sinh: ");
                                            traCuu.setDs(qlnd.traCuu(CauHinh.SC.nextLine()));
                                            traCuu.hienThiDSNguoiDung();
                                        }
                                        case 4 -> {
                                            System.out.print("Nhap que quan: ");
                                            traCuu.setDs(qlnd.traCuu(CauHinh.SC.nextLine()));
                                            traCuu.hienThiDSNguoiDung();
                                        }
                                        case 0 ->
                                            System.out.println("Ket thuc tra cuu nguoi hoc.");
                                        default ->
                                            System.out.println("Lua chon khong hop le. Vui long chon lai.");
                                    }
                                } while (choice12 != 0);
                            }
                            case 3 -> {
                                System.out.println("Them nguoi hoc: ");
                                qlnd.themNguoiHoc();
                                
                            }
                            case 4 -> {
                                System.out.println("Cap nhat thong tin nguoi hoc: ");
                                System.out.print("Nhap ten nguoi hoc muon cap nhat: ");
                                String ten = CauHinh.SC.nextLine();
                                qlnd.capNhatThongTin(ten);
                                qlnd.setDs(qlnd.getDs());
                                qlnd.ghiNguoiDungVaoFile();
                            }
                            case 5 -> {
                                System.out.println("Xoa nguoi hoc: ");
                                System.out.print("Nhap ten nguoi hoc muon xoa: ");
                                String ten = CauHinh.SC.nextLine();
                                qlnd.xoaNguoiDung(ten);
                                qlnd.setDs(qlnd.getDs());
                                qlnd.ghiNguoiDungVaoFile();
                            }
                            case 0 ->
                                System.out.println("Ket thuc quan ly nguoi hoc.");
                            default ->
                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                        }
                    } while (choice1 != 0);
                    // Goi cac phuong thuc quan ly nguoi hoc
                }
                case 2 -> {
                    QLCauHoi qlch = new QLCauHoi();
                    int choice2;
                    do {
                        System.out.println("    1. Xem danh sach cau hoi");
                        System.out.println("    2. Tim cau hoi");
                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                        choice2 = Integer.parseInt(CauHinh.SC.nextLine());
                        switch (choice2) {
                            case 1 -> {
                                qlch.docFileMultipleChoice();
                                qlch.hienThiDsCauHoi();
                                break;
                            }
                            case 2 -> {
                                int choice22;
                                do {
                                    System.out.println("Tim cau hoi theo");
                                    System.out.println("        1. Noi dung cau hoi");
                                    System.out.println("        2. Danh muc");
                                    System.out.println("        3. Muc do cau hoi");
                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                    choice22 = Integer.parseInt(CauHinh.SC.nextLine());
                                    switch (choice22) {
                                        case 1 -> {
                                        }
                                        case 2 -> {
                                        }
                                        case 3 -> {
                                        }
                                        case 4 -> {
                                        }
                                        case 0 ->
                                            System.out.println("Ket thuc tim cau hoi.");
                                        default ->
                                            System.out.println("Lua chon khong hop le. Vui long chon lai.");
                                    }
                                } while (choice22 != 0);
                            }
                            case 0 ->
                                System.out.println("Ket thuc quan ly cau hoi.");
                            default ->
                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                        }
                    } while (choice2 != 0);
                    // Goi cac phuong thuc quan ly cau hoi
                }
                case 3 -> {
                    int choice3;
                    do {
                        System.out.println("    Nguoi dung chon dang cau hoi");
                        System.out.println("    1. Multiple Choice");
                        System.out.println("    2. Incomple");
                        System.out.println("    3. Conversation");
                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                        choice3 = Integer.parseInt(CauHinh.SC.nextLine());
                        switch (choice3) {
                            case 1 -> {
                                
                            }
                            case 2 -> {

                            }
                            case 3 -> {

                            }
                            case 0 ->
                                System.out.println("Ket thuc luyen tap.");
                            default ->
                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                        }
                    } while (choice3 != 0);
                    // Goi cac phuong thuc luyen tap
                }
                case 4 -> {
                    System.out.println("    Thong ke ket qua hoc tap cua hoc vien");
                    // Goi cac phuong thuc thong ke
                }
                case 0 ->
                    System.out.println("Ket thuc chuong trinh.");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }

        } while (choice != 0);
    }
}
