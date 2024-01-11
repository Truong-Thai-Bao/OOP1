package com.ttb.baitap;

import com.ttb.baitap.CauHinh;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int choice;
        NguoiDung nguoiHocDangNhap = null;
        QLNguoiDung qlnd = new QLNguoiDung();
        QLNguoiDung traCuu = new QLNguoiDung();
        qlnd.dSNguoiDung();
        int luaChon;
        do {
            System.out.println("Dang nhap - Dang ky:");
            System.out.println("        1. Dang ky");
            System.out.println("        2. Dang nhap");
            System.out.print("Nhap lua chon cua ban (0 de thoat): ");
            luaChon = Integer.parseInt(CauHinh.SC.nextLine());
            switch (luaChon) {
                case 1 -> {
                    nguoiHocDangNhap = qlnd.themNguoiHocDK();
                    luaChon = 0;
                    break;
                }
                case 2 -> {
                    nguoiHocDangNhap = qlnd.DangNhap();
                    if (nguoiHocDangNhap != null) {
                        System.out.println("Dang nhap thanh cong!!!");
                        luaChon = 0;
                    } else {
                        System.out.println("Dang nhap that bai!!!");
                    }
                }
                case 0 ->
                    System.out.println("Ket thuc dang ky - dang nhap.");
                default ->
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (luaChon != 0);
        if (nguoiHocDangNhap != null) {
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

                                                String ngaySinhStr;
                                                Date ngaySinh = null;
                                                do {
                                                    System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
                                                    ngaySinhStr = CauHinh.SC.nextLine();
                                                    ngaySinh = qlnd.chuyenDoiNgayThang(ngaySinhStr);
                                                } while (ngaySinh == null);
                                                ngaySinhStr = qlnd.chuyenDateSangChuoi(ngaySinh);
                                                traCuu.setDs(qlnd.traCuu(ngaySinhStr));
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
//                                qlnd.ghiNguoiDungVaoFile();
                                }
                                case 5 -> {
                                    System.out.println("Xoa nguoi hoc: ");
                                    System.out.print("Nhap ten nguoi hoc muon xoa: ");
                                    String ten = CauHinh.SC.nextLine();
                                    qlnd.xoaNguoiDung(ten);
//                                qlnd.ghiNguoiDungVaoFile();
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
                        List<CauHoi> kq;
                        int choice2;
                        do {
                            System.out.println("    Chon dang cau hoi");
                            System.out.println("    1. Multiple Choice");
                            System.out.println("    2. Incomplete");
                            System.out.println("    3. Conversation");
                            System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                            choice2 = Integer.parseInt(CauHinh.SC.nextLine());
                            switch (choice2) {
                                case 1 -> {
                                    int choice21;
                                    qlch.docFileMultipleChoice();
                                    do {
                                        System.out.println("    1. Xem danh sach cau hoi");
                                        System.out.println("    2. Tim cau hoi");
                                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                        choice21 = Integer.parseInt(CauHinh.SC.nextLine());
                                        switch (choice21) {
                                            case 1 -> {
                                                qlch.hienThiDsCauHoi();
                                                break;
                                            }
                                            case 2 -> {
                                                int choice212;
                                                do {
                                                    System.out.println("Tim cau hoi theo");
                                                    System.out.println("        1. Noi dung cau hoi");
                                                    System.out.println("        2. Danh muc");
                                                    System.out.println("        3. Muc do cau hoi");
                                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                                    choice212 = Integer.parseInt(CauHinh.SC.nextLine());
                                                    switch (choice212) {
                                                        case 1 -> {
                                                            System.out.println("Nhap noi dung can tim");
                                                            kq = qlch.timCauHoi(CauHinh.SC.nextLine());
                                                            hienThiDs(kq);
                                                            break;
                                                        }
                                                        case 2 -> {
                                                            System.out.println("Nhap loai danh muc can tim");
                                                            kq = qlch.timCauHoi(new DanhMuc(CauHinh.SC.nextLine()));
                                                            hienThiDs(kq);
                                                            break;
                                                        }
                                                        case 3 -> {
                                                            int choice223;
                                                            do {
                                                                System.out.println("Chon do kho muon tim");
                                                                System.out.println("    1. De");
                                                                System.out.println("    2. Trung binh");
                                                                System.out.println("    3. Kho");
                                                                System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                                                choice223 = Integer.parseInt(CauHinh.SC.nextLine());
                                                                switch (choice223) {
                                                                    case 1 -> {
                                                                        kq = qlch.timCauHoi((Do_Kho.DE));
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 2 -> {
                                                                        kq = qlch.timCauHoi((Do_Kho.TRUNG_BINH));
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 3 -> {
                                                                        kq = qlch.timCauHoi((Do_Kho.KHO));
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 0 ->
                                                                        System.out.println("Ket thuc luyen tap.");
                                                                    default ->
                                                                        System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                                                }
                                                            } while (choice223 != 0);
                                                            // Goi cac phuong thuc luyen tap
                                                        }
                                                        case 0 ->
                                                            System.out.println("Ket thuc tim cau hoi.");
                                                        default ->
                                                            System.out.println("Lua chon khong hop le. Vui long chon lai.");
                                                    }
                                                } while (choice212 != 0);
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc quan ly cau hoi.");
                                            default ->
                                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                        }
                                    } while (choice21 != 0);
                                    // Goi cac phuong thuc quan ly cau hoi
                                }
                                case 2 -> {
                                    int choice22;
                                    do {
                                        System.out.println("        1. Xem danh sach cau hoi");
                                        System.out.println("        2. Tim cau hoi");
                                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                        choice22 = Integer.parseInt(CauHinh.SC.nextLine());
                                        switch (choice22) {
                                            case 1 -> {
                                                QLCauHoi ql = new QLCauHoi();
                                                ql.docFileIncomplete();
                                                ql.hienThiDsCauHoi();
                                                break;
                                            }
                                            case 2 -> {
                                                int choice222;
                                                do {
                                                    System.out.println("        Tim cau hoi theo");
                                                    System.out.println("            1. Noi dung cau hoi");
                                                    System.out.println("            2. Muc do cau hoi");
                                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                                    choice222 = Integer.parseInt(CauHinh.SC.nextLine());
                                                    switch (choice222) {
                                                        case 1 -> {
                                                            QLCauHoi ql = new QLCauHoi();
                                                            ql.docFileIncomplete();
                                                            System.out.println("Nhap noi dung can tim");
                                                            kq = ql.timCauHoi(CauHinh.SC.nextLine());
                                                            hienThiDs(kq);
                                                            break;
                                                        }
                                                        case 2 -> {
                                                            int choice2222;
                                                            do {
                                                                System.out.println("Chon do kho muon tim");
                                                                System.out.println("    1. De");
                                                                System.out.println("    2. Trung binh");
                                                                System.out.println("    3. Kho");
                                                                System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                                                choice2222 = Integer.parseInt(CauHinh.SC.nextLine());
                                                                switch (choice2222) {
                                                                    case 1 -> {
                                                                        QLCauHoi ql = new QLCauHoi();
                                                                        ql.docFileIncomplete();
                                                                        kq = ql.timCauHoi(Do_Kho.DE);
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 2 -> {
                                                                        QLCauHoi ql = new QLCauHoi();
                                                                        ql.docFileIncomplete();
                                                                        kq = ql.timCauHoi(Do_Kho.TRUNG_BINH);
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 3 -> {
                                                                        QLCauHoi ql = new QLCauHoi();
                                                                        ql.docFileIncomplete();
                                                                        kq = ql.timCauHoi(Do_Kho.KHO);
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 0 ->
                                                                        System.out.println("Ket thuc luyen tap.");
                                                                    default ->
                                                                        System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                                                }
                                                            } while (choice2222 != 0);
                                                            // Goi cac phuong thuc luyen tap

                                                        }
                                                        case 0 ->
                                                            System.out.println("Ket thuc tim cau hoi.");
                                                        default ->
                                                            System.out.println("Lua chon khong hop le. Vui long chon lai.");
                                                    }
                                                } while (choice222 != 0);
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc quan ly cau hoi.");
                                            default ->
                                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                        }
                                    } while (choice22 != 0);
                                    // Goi cac phuong thuc quan ly cau hoi
                                }
                                case 3 -> {
                                    int choice23;

                                    do {
                                        System.out.println("        1. Xem danh sach cau hoi");
                                        System.out.println("        2. Tim cau hoi");
                                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                        choice23 = Integer.parseInt(CauHinh.SC.nextLine());
                                        switch (choice23) {
                                            case 1 -> {
                                                QLCauHoi ql = new QLCauHoi();
                                                ql.docFileConversation();
                                                ql.hienThiDsCauHoi();
                                                break;
                                            }
                                            case 2 -> {
                                                int choice232;
                                                do {
                                                    System.out.println("Tim cau hoi theo");
                                                    System.out.println("            1. Noi dung cau hoi");
                                                    System.out.println("            2. Muc do cau hoi");
                                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                                    choice232 = Integer.parseInt(CauHinh.SC.nextLine());
                                                    switch (choice232) {
                                                        case 1 -> {
                                                            QLCauHoi ql = new QLCauHoi();
                                                            ql.docFileConversation();
                                                            System.out.println("Nhap noi dung can tim");
                                                            kq = ql.timCauHoi(CauHinh.SC.nextLine());
                                                            hienThiDs(kq);
                                                            break;
                                                        }
                                                        case 2 -> {
                                                            int choice2322;
                                                            do {
                                                                System.out.println("Chon do kho muon tim");
                                                                System.out.println("    1. De");
                                                                System.out.println("    2. Trung binh");
                                                                System.out.println("    3. Kho");
                                                                System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                                                choice2322 = Integer.parseInt(CauHinh.SC.nextLine());
                                                                switch (choice2322) {
                                                                    case 1 -> {
                                                                        QLCauHoi ql = new QLCauHoi();
                                                                        ql.docFileConversation();
                                                                        kq = ql.timCauHoi(Do_Kho.DE);
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 2 -> {
                                                                        QLCauHoi ql = new QLCauHoi();
                                                                        ql.docFileConversation();
                                                                        kq = ql.timCauHoi(Do_Kho.TRUNG_BINH);
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 3 -> {
                                                                        QLCauHoi ql = new QLCauHoi();
                                                                        ql.docFileConversation();
                                                                        kq = ql.timCauHoi(Do_Kho.KHO);
                                                                        hienThiDs(kq);
                                                                        break;
                                                                    }
                                                                    case 0 ->
                                                                        System.out.println("Ket thuc tim cau hoi.");
                                                                    default ->
                                                                        System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                                                }
                                                            } while (choice2322 != 0);
                                                            // Goi cac phuong thuc luyen tap

                                                        }
                                                        case 0 ->
                                                            System.out.println("Ket thuc tim cau hoi.");
                                                        default ->
                                                            System.out.println("Lua chon khong hop le. Vui long chon lai.");
                                                    }
                                                } while (choice232 != 0);
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc quan ly cau hoi.");
                                            default ->
                                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                        }
                                    } while (choice23 != 0);
                                    // Goi cac phuong thuc quan ly cau hoi
                                }
                                case 0 ->
                                    System.out.println("Ket thuc quan ly cau hoi.");
                                default ->
                                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
                            }
                        } while (choice2 != 0);
                    }
                    case 3 -> {
                        int choice3;
                        List<CauHoi> kq = new ArrayList<>();
                        do {
                            System.out.println("    Nguoi dung chon dang cau hoi");
                            System.out.println("    1. Multiple Choice");
                            System.out.println("    2. Incomple");
                            System.out.println("    3. Conversation");
                            System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                            choice3 = Integer.parseInt(CauHinh.SC.nextLine());
                            switch (choice3) {
                                case 1 -> {
                                    int soLan = soLanGanNhat();
                                    ++soLan;
                                    System.out.println("Nhap so luong cau hoi");
                                    int n = Integer.parseInt(CauHinh.SC.nextLine());
                                    QLCauHoi ds = new QLCauHoi();
                                    kq = ds.docFileMultipleChoice();
                                    int rand = randSo(CauHinh.SL_MUL);
                                    int diem = 0;
                                    int j = 1;
                                    List<CauHoi> list = new ArrayList<>();
                                    for (int i = 0; i < n; i++) {
                                        while (kiemTra(1, rand)) {
                                            rand = randSo(CauHinh.SL_MUL);
                                            j++;
                                            if (j == CauHinh.SL_MUL) {
                                                System.out.println("Da het cau hoi");
                                                xoaDs(1);
                                                break;
                                            }
                                        }
                                        if (j == CauHinh.SL_CON) {
                                            break;
                                        }
                                        int temp = 0;
                                        String pad = null;
                                        for (CauHoi c : kq) {
                                            if (c.getSoThuTu() == rand) {
                                                c.hienThi(1);
                                                pad = c.getPhuongAnDung().toString();
                                                temp = c.getDoKho().getDiemSo();
                                                list.add(c);
                                            }
                                        }
                                        System.out.print("Ban chon phuong an: ");
                                        String chon = CauHinh.SC.nextLine();
                                        if (chon.equalsIgnoreCase(pad)) {
                                            diem += temp;
                                        }
                                    }
                                    ghiDiem(diem, soLan);
                                    if (!list.isEmpty()) {
                                        System.out.println("===========DAP AN===========");
                                    }
                                    list.forEach(c -> {
                                        c.hienThi(0);
                                        System.out.print("Phuong an dung: ");
                                        System.out.println(c.getPhuongAnDung());
                                        System.out.println("");
                                    });
                                    break;
                                }
                                case 2 -> {
                                    int soLan = soLanGanNhat();
                                    ++soLan;
                                    int choice32;
                                    QLCauHoi ds = new QLCauHoi();
                                    kq = ds.docFileIncomplete();
                                    int rand = randSo(CauHinh.SL_INC);
                                    int j = 1;
                                    String pad = null;
                                    List<CauHoi> list = new ArrayList<>();
                                    do {
                                        System.out.println("Chon do kho");
                                        System.out.println("    1. De");
                                        System.out.println("    2. Trung binh");
                                        System.out.println("    3. Kho");
                                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                        choice32 = Integer.parseInt(CauHinh.SC.nextLine());
                                        switch (choice32) {
                                            case 1 -> {
                                                QLCauHoi qlch = new QLCauHoi();
                                                qlch.docFileIncomplete();
                                                kq = qlch.timCauHoi(Do_Kho.DE);
                                                while (kiemTra(2, rand)) {
                                                    rand = randSo(CauHinh.SL_INC);
                                                    j++;
                                                    if (j == CauHinh.SL_INC) {
                                                        System.out.println("Da het cau hoi");
                                                        xoaDs(1);
                                                        break;
                                                    }
                                                }
                                                int diem = 0;
                                                int temp = 0;
                                                for (CauHoi c : kq) {
                                                    if (c.getSoThuTu() == rand) {
                                                        c.hienThi(1);
                                                        System.out.print("Ban chon phuong an:");
                                                        String chon = CauHinh.SC.nextLine();

                                                        pad = c.getPhuongAnDung().toString();
                                                        temp = c.getDoKho().getDiemSo();
                                                        list.add(c);
                                                        if(pad.equalsIgnoreCase(chon))
                                                            diem+=temp;
                                                    }
                                                }
                                                if(!list.isEmpty())
                                                    System.out.println("============DAP AN============");
                                                list.forEach(c -> {
                                                    c.hienThi(0);
                                                    System.out.print("Phuong an dung: ");
                                                    System.out.println(c.getPhuongAnDung());
                                                    System.out.println("");
                                                });
                                                ghiDiem(diem, soLan);
                                                break;
                                            }
                                            case 2 -> {
                                                QLCauHoi qlch = new QLCauHoi();
                                                qlch.docFileIncomplete();
                                                kq = qlch.timCauHoi(Do_Kho.TRUNG_BINH);
                                                while (kiemTra(2, rand)) {
                                                    rand = randSo(CauHinh.SL_INC);
                                                    j++;
                                                    if (j == CauHinh.SL_INC) {
                                                        System.out.println("Da het cau hoi");
                                                        return;
                                                    }
                                                }
                                                for (CauHoi c : kq) {
                                                    if (c.getSoThuTu() == rand) {
                                                        c.hienThi(1);
                                                        System.out.print("Ban chon phuong an:");
                                                        String chon = CauHinh.SC.nextLine();
                                                        if (chon.equalsIgnoreCase(pad)) {
                                                            ghiDiem(diem, soLan);
                                                        }

                                                        pad = c.getPhuongAnDung().toString();
                                                        diem = c.getDoKho().getDiemSo();
                                                        list.add(c);
                                                    }
                                                }
                                                list.forEach(c -> {
                                                    c.hienThi(0);
                                                    System.out.print("Phuong an dung: ");
                                                    System.out.println(c.getPhuongAnDung());
                                                    System.out.println("");
                                                });
                                                break;
                                            }
                                            case 3 -> {
                                                QLCauHoi qlch = new QLCauHoi();
                                                qlch.docFileIncomplete();
                                                kq = qlch.timCauHoi(Do_Kho.KHO);
                                                while (kiemTra(2, rand)) {
                                                    rand = randSo(CauHinh.SL_INC);
                                                    j++;
                                                    if (j == CauHinh.SL_INC) {
                                                        System.out.println("Da het cau hoi");
                                                        return;
                                                    }
                                                }
                                                for (CauHoi c : kq) {
                                                    if (c.getSoThuTu() == rand) {
                                                        c.hienThi(1);
                                                        System.out.print("Ban chon phuong an:");
                                                        String chon = CauHinh.SC.nextLine();
                                                        if (chon.equalsIgnoreCase(pad)) {
                                                            ghiDiem(diem, soLan);
                                                        }

                                                        pad = c.getPhuongAnDung().toString();
                                                        diem = c.getDoKho().getDiemSo();
                                                        list.add(c);
                                                    }
                                                }
                                                list.forEach(c -> {
                                                    c.hienThi(0);
                                                    System.out.print("Phuong an dung: ");
                                                    System.out.println(c.getPhuongAnDung());
                                                    System.out.println("");
                                                });
                                                break;
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc tim cau hoi.");
                                            default ->
                                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                        }
                                    } while (choice32 != 0);
                                }
                                case 3 -> {
                                    int soLan = soLanGanNhat();
                                    ++soLan;
                                    int choice33;
                                    QLCauHoi ds = new QLCauHoi();
                                    kq = ds.docFileConversation();
                                    int rand = randSo(CauHinh.SL_CON);
                                    int diem = 0;
                                    int j = 1;
                                    String pad = null;
                                    List<CauHoi> list = new ArrayList<>();
                                    do {
                                        System.out.println("Chon do kho");
                                        System.out.println("    1. De");
                                        System.out.println("    2. Trung binh");
                                        System.out.println("    3. Kho");
                                        System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                        choice33 = Integer.parseInt(CauHinh.SC.nextLine());
                                        switch (choice33) {
                                            case 1 -> {
                                                QLCauHoi qlch = new QLCauHoi();
                                                qlch.docFileConversation();
                                                kq = qlch.timCauHoi(Do_Kho.DE);
                                                while (kiemTra(3, rand)) {
                                                    rand = randSo(CauHinh.SL_CON);
                                                    j++;
                                                    if (j == CauHinh.SL_CON) {
                                                        System.out.println("Da het cau hoi");
                                                        return;
                                                    }
                                                }
                                                for (CauHoi c : kq) {
                                                    if (c.getSoThuTu() == rand) {
                                                        c.hienThi(1);
                                                        System.out.print("Ban chon phuong an:");
                                                        String chon = CauHinh.SC.nextLine();
                                                        if (chon.equalsIgnoreCase(pad)) {
                                                            ghiDiem(diem, soLan);
                                                        }
                                                        pad = c.getPhuongAnDung().toString();
                                                        diem = c.getDoKho().getDiemSo();
                                                        list.add(c);
                                                    }
                                                }
                                                list.forEach(c -> {
                                                    c.hienThi(0);
                                                    System.out.print("Phuong an dung: ");
                                                    System.out.println(c.getPhuongAnDung());
                                                    System.out.println("");
                                                });
                                                break;
                                            }
                                            case 2 -> {
                                                QLCauHoi qlch = new QLCauHoi();
                                                qlch.docFileConversation();
                                                kq = qlch.timCauHoi(Do_Kho.TRUNG_BINH);
                                                while (kiemTra(3, rand)) {
                                                    rand = randSo(CauHinh.SL_CON);
                                                    j++;
                                                    if (j == CauHinh.SL_CON) {
                                                        System.out.println("Da het cau hoi");
                                                        return;
                                                    }
                                                }
                                                for (CauHoi c : kq) {
                                                    if (c.getSoThuTu() == rand) {
                                                        c.hienThi(1);
                                                        System.out.print("Ban chon phuong an:");
                                                        String chon = CauHinh.SC.nextLine();
                                                        if (chon.equalsIgnoreCase(pad)) {
                                                            ghiDiem(diem, soLan);
                                                        }

                                                        pad = c.getPhuongAnDung().toString();
                                                        diem = c.getDoKho().getDiemSo();
                                                        list.add(c);
                                                    }
                                                }
                                                System.out.println("==========DAP AN==========");
                                                list.forEach(c -> {
                                                    c.hienThi(0);
                                                    System.out.print("Phuong an dung: ");
                                                    System.out.println(c.getPhuongAnDung());
                                                    System.out.println("");
                                                });
                                                break;
                                            }
                                            case 3 -> {
                                                QLCauHoi qlch = new QLCauHoi();
                                                qlch.docFileConversation();
                                                kq = qlch.timCauHoi(Do_Kho.KHO);
                                                while (kiemTra(3, rand)) {
                                                    rand = randSo(CauHinh.SL_CON);
                                                    j++;
                                                    if (j == CauHinh.SL_CON) {
                                                        System.out.println("Da het cau hoi");
                                                        break;
                                                    }
                                                }
                                                if (j == CauHinh.SL_CON) {
                                                    break;
                                                }
                                                for (CauHoi c : kq) {
                                                    if (c.getSoThuTu() == rand) {
                                                        c.hienThi(1);
                                                        System.out.print("Ban chon phuong an:");
                                                        String chon = CauHinh.SC.nextLine();
                                                        if (chon.equalsIgnoreCase(pad)) {
                                                            ghiDiem(diem, soLan);
                                                        } else {
                                                            ghiDiem(0, soLan);
                                                        }
                                                        pad = c.getPhuongAnDung().toString();
                                                        diem = c.getDoKho().getDiemSo();
                                                        list.add(c);
                                                    }
                                                }
                                                if (!list.isEmpty()) {
                                                    System.out.println("============DAP AN============");
                                                }
                                                list.forEach(c -> {
                                                    c.hienThi(0);
                                                    System.out.print("Phuong an dung: ");
                                                    System.out.println(c.getPhuongAnDung());
                                                    System.out.println("");
                                                });
                                                break;
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc tim cau hoi.");
                                            default ->
                                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                        }
                                    } while (choice33 != 0);

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

                    }
                    case 0 ->
                        System.out.println("Ket thuc chuong trinh.");
                    default ->
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }

            } while (choice != 0);
        }
    }

    public static void hienThiDs(List<CauHoi> kq) {
        if (kq.isEmpty()) {
            System.out.println("Khong tim thay ket qua");
            return;
        }
        kq.forEach(c -> c.hienThi(0));
    }

    public static boolean kiemTra(int lineNumber, int targetNumber) throws IOException {
        String tenFile = "src/main/java/com/ttb/baitap/file/CauDaLam"; // Thay đổi đường dẫn và tên file tùy ý

        try {
            // Đọc nội dung từ file
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String[] lines = new String[3]; // Mảng lưu trữ 6 dòng

            // Đọc dòng từ file và lưu vào mảng
            for (int i = 0; i < 3; i++) {
                lines[i] = br.readLine();
            }

            // Đóng đối tượng đọc file
            br.close();
            if (lines[lineNumber - 1].trim().isBlank() || !lines[lineNumber - 1].contains(Integer.toString(targetNumber))) // Ghi giá trị mới vào dòng thứ 6
            {
                lines[lineNumber - 1] += Integer.toString(targetNumber) + " ";
                BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
                bw.close();
                return false;
            } else {
                return true;
            }

            // Ghi lại toàn bộ nội dung vào file
            // Đóng đối tượng ghi file
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
        return false;
    }

    public static int randSo(int n) {
        Random random = new Random();
        return random.nextInt(n) + 1;
    }

    public static String ngay() throws FileNotFoundException {
        String ngay = null;

        try ( Scanner sc = new Scanner(new File("src/main/java/com/ttb/baitap/file/ThongKeLuyenTap"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() == 10) {
                    ngay = line;
                }
            }
        }

        return ngay;
    }

    public static int soLanGanNhat() throws FileNotFoundException {
        String filePath = "src/main/java/com/ttb/baitap/file/ThongKeLuyenTap";
        ArrayList<Integer> integers = new ArrayList<>();
        String now = LocalDate.now().toString();
        try ( Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNext()) {
                String token = sc.nextLine();
                if (token.trim().isBlank() || ngay().equals(now)) {
                    return 0;
                }

                try {
                    int number = Integer.parseInt(token);
                    integers.add(number);
                } catch (NumberFormatException e) {
                    // Nếu không phải số nguyên, bỏ qua
                }
            }
        }
        if (integers.isEmpty()) {
            return 0;
        }
        // Nếu có ít nhất 2 số nguyên trong mảng, trả về số gần cuối
        return integers.get(integers.size() - 2);

    }

    public static void ghiDiem(int diem, int soLan) throws IOException {
        try ( PrintWriter writer = new PrintWriter(new FileWriter("src/main/java/com/ttb/baitap/file/ThongKeLuyenTap", true))) {
            String now = LocalDate.now().toString();
            if (isFirstLineEmpty()) {
                writer.println(now);
            } else {
                if (ngay().equals(now)) {
                    writer.println(Integer.toString(soLan));
                    writer.println(Integer.toString(diem));
                } else {
                    writer.println(now);
                    soLan = 0;
                }

            }

        } catch (IOException e) {
        }

    }

    public static boolean isFirstLineEmpty() throws FileNotFoundException {
        String filePath = "src/main/java/com/ttb/baitap/file/ThongKeLuyenTap";
        try ( Scanner sc = new Scanner(new File(filePath))) {
            if (sc.hasNextLine()) {
                String firstLine = sc.nextLine();
                return firstLine.trim().isEmpty();
            }
        }
        return true; // Nếu tệp trống
    }

    public static void xoaDsDaLam(int soDong) {
        String tenFile = "src/main/java/com/ttb/baitap/file/CauDaLam"; // Thay đổi đường dẫn và tên file tùy ý

        try {
            // Đọc nội dung từ file
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String[] lines = new String[3]; // Mảng lưu trữ 6 dòng

            // Đọc dòng từ file và lưu vào mảng
            for (int i = 0; i < 3; i++) {
                lines[i] = br.readLine();
            }

            // Đóng đối tượng đọc file
            br.close();
            lines[soDong - 1] = "";
            // Ghi lại toàn bộ nội dung vào file
            BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

            // Đóng đối tượng ghi file
            bw.close();

        } catch (IOException e) {

        }
    }

    public static void xoaDs(int soDong) {
        int choice;
        do {
            System.out.println("Ban co muon reset danh sach khong");
            System.out.println("1. Co");
            System.out.println("0. Thoat");
            System.out.println("Nhap lua chon");
            choice = Integer.parseInt(CauHinh.SC.nextLine());
            switch (choice) {
                case 1 -> {
                    xoaDsDaLam(soDong);
                    System.out.println("Xoa thanh cong");
                    break;
                }
                case 0 ->
                    System.out.println("Ket thuc reset");

                default ->
                    System.out.println("Nhap sai! Nhap lai");
            }
            break;
        } while (choice != 0);
    }

}
