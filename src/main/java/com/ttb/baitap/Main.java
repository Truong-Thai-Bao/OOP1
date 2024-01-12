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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                    taoFile(nguoiHocDangNhap);
                    luaChon = 0;
                    break;
                }
                case 2 -> {
                    nguoiHocDangNhap = qlnd.DangNhap();
                    if (nguoiHocDangNhap != null) {
                        System.out.println("Dang nhap thanh cong!!!");
                        taoFile(nguoiHocDangNhap);
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
                                    int soLan = soLanGanNhat(nguoiHocDangNhap);
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
                                    ghiDiem(diem, soLan, nguoiHocDangNhap);
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
                                    int soLan = soLanGanNhat(nguoiHocDangNhap);
                                    ++soLan;
                                    int choice32;
                                    int rand = randSo(CauHinh.SL_INC);
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
                                                IncAndCon(Do_Kho.DE, 2, nguoiHocDangNhap, 2);
                                                break;
                                            }
                                            case 2 -> {
                                                IncAndCon(Do_Kho.TRUNG_BINH, 3, nguoiHocDangNhap, 2);
                                                break;
                                            }
                                            case 3 -> {
                                                IncAndCon(Do_Kho.KHO, 4, nguoiHocDangNhap, 2);
                                                break;
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc.");
                                            default ->
                                                System.out.println("Lua chon khong hop le. Vui long chon lai.");

                                        }
                                    } while (choice32 != 0);
                                }
                                case 3 -> {
                                    int choice33;
                                    int rand = randSo(CauHinh.SL_CON);
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
                                                IncAndCon(Do_Kho.DE, 5, nguoiHocDangNhap, 3);
                                                break;
                                            }
                                            case 2 -> {
                                                IncAndCon(Do_Kho.TRUNG_BINH, 6, nguoiHocDangNhap, 3);
                                                break;
                                            }
                                            case 3 -> {
                                                IncAndCon(Do_Kho.KHO, 7, nguoiHocDangNhap, 3);
                                                break;
                                            }
                                            case 0 ->
                                                System.out.println("Ket thuc.");
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

                        Map<String, Integer> diemTheoThang = thongKeDiemTheoThang(nguoiHocDangNhap);
                        int tamThoi = 0;
                        int i;
                        for (i = 1; i <= soLanGanNhat(nguoiHocDangNhap); i++) {
                            tamThoi += i;
                        }
                        System.out.println("================Thong ke diem theo thang================");
                        for (Map.Entry<String, Integer> entry : diemTheoThang.entrySet()) {
                            System.out.println("Nam thang duoc thong ke: " + entry.getKey() + " \nDiem trung binh thang: " + ((entry.getValue() - tamThoi) / (double) (i - 1)));
                        }
                        int j = 0;
                        int tmp = 0;
                        try {
                            List<Integer> diemList = docFileThongKe(nguoiHocDangNhap);

                            if (diemList.isEmpty()) {
                                System.out.println("Khong co du lieu diem so.");
                            } else {
                                System.out.println("Diem moi lan lam bai cua nguoi dung:");
                                for (int diem : diemList) {
                                    tmp++;
                                    if (tmp % 2 == 0) {
                                        j++;
                                        System.out.print("Diem lan " + j + " la: ");
                                        System.out.println(diem);
                                    }

                                }
                            }
                        } catch (FileNotFoundException e) {
                            // Xử lý lỗi tệp tin không tồn tại
                            System.out.println("Tep tin khong ton tai.");
                        }

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
            String[] lines = new String[7]; // Mảng lưu trữ 6 dòng

            // Đọc dòng từ file và lưu vào mảng
            for (int i = 0; i < 7; i++) {
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

    public static String ngay(NguoiDung nguoiDung) throws FileNotFoundException, IOException {
        String ngay = null;
        String name = nguoiDung.getHoTen();
        Path filePath = Paths.get("src/main/java/com/ttb/baitap/file/", name);
        try ( Scanner sc = new Scanner(filePath)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() == 10) {
                    ngay = line;
                }
            }
        }

        return ngay;
    }

    public static int soLanGanNhat(NguoiDung nguoiDung) throws FileNotFoundException, IOException {
        String name = nguoiDung.getHoTen();
        Path filePath = Paths.get("src/main/java/com/ttb/baitap/file/", name);
        ArrayList<Integer> integers = new ArrayList<>();
        String now = LocalDate.now().toString();

        try ( Scanner sc = new Scanner(filePath)) {
            while (sc.hasNext()) {
                String token = sc.nextLine();

                if (token.trim().isEmpty()) {
                    continue; // Bỏ qua dòng trắng
                }

                try {
                    int number = Integer.parseInt(token);
                    integers.add(number);
                } catch (NumberFormatException e) {
                    // Nếu không phải số nguyên, kiểm tra ngày và bỏ qua nếu trùng
                    if (ngay(nguoiDung).equals(now)) {
                        continue;
                    }
                }
            }
        }

        if (integers.isEmpty()) {
            return 0;
        }

        // Nếu có ít nhất 2 số nguyên trong mảng, trả về số gần cuối
        return integers.get(integers.size() - 2);
    }

    public static void ghiDiem(int diem, int soLan, NguoiDung nguoiDung) throws IOException {
        String name = nguoiDung.getHoTen();
        Path filePath = Paths.get("src/main/java/com/ttb/baitap/file/", name);

        try ( PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile(), true))) {
            String now = LocalDate.now().toString();
            if (isFirstLineEmpty(nguoiDung)) {
                writer.println(now);
            } else {
                if (ngay(nguoiDung).equals(now)) {
                    writer.println(Integer.toString(soLan));
                    writer.println(Integer.toString(diem));
                } else {
                    writer.println(now);
                    soLan = 0;
                }
            }
        }
    }

    public static boolean isFirstLineEmpty(NguoiDung nguoiDung) throws FileNotFoundException, IOException {
        String name = nguoiDung.getHoTen();
        Path filePath = Paths.get("src/main/java/com/ttb/baitap/file/", name);

        try ( Scanner sc = new Scanner(filePath)) {
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
            System.out.println("Danh sach cau hoi da het");
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

    public static String full(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(i + " ");
        }
        return s.toString();
    }

    public static boolean isFull(int line) throws FileNotFoundException {
        String tenFile = "src/main/java/com/ttb/baitap/file/CauDaLam"; // Thay đổi đường dẫn và tên file tùy ý
        try {
            // Đọc nội dung từ file
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String[] lines = new String[7]; // Mảng lưu trữ 6 dòng

            // Đọc dòng từ file và lưu vào mảng
            for (int i = 0; i < 7; i++) {
                lines[i] = br.readLine();
            }

            // Đóng đối tượng đọc file
            br.close();
            if (lines[line - 1].length() == full(line).length()) {
                return true;
            }
        } catch (IOException e) {

        }
        return false;
    }

    public static void taoFile(NguoiDung nguoiDung) {
        // Đường dẫn tới thư mục lưu trữ tệp tin
        String folderPath = "src/main/java/com/ttb/baitap/file/";
        String name = nguoiDung.getHoTen();
        // Tạo đối tượng File cho tệp tin mới
        File file = new File(folderPath + name);

        try {
            // Kiểm tra xem tệp tin đã tồn tại chưa
            if (file.createNewFile()) {
                System.out.println("Tep tin duoc tao thanh cong: " + file.getAbsolutePath());
            } else {
                System.out.println("Tep tin da ton tai: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Khong the tao tep tin.");
        }
    }

    public static Map<String, Integer> thongKeDiemTheoThang(NguoiDung nguoiDung) throws IOException {
        String name = nguoiDung.getHoTen();
        Path filePath = Paths.get("src/main/java/com/ttb/baitap/file/", name);

        Map<String, Integer> diemTheoThang = new HashMap<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            String currentThang = null;

            while ((line = br.readLine()) != null) {
                if (line.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    // Nếu dòng là ngày, cập nhật tháng hiện tại
                    currentThang = line.substring(0, 7); // Lấy yyyy-MM từ ngày
                } else if (line.matches("\\d+")) {
                    // Nếu dòng là số, đọc điểm và cập nhật vào Map
                    int diem = Integer.parseInt(line);
                    diemTheoThang.putIfAbsent(currentThang, 0);
                    diemTheoThang.put(currentThang, diemTheoThang.get(currentThang) + diem);
                }
            }
        }

        return diemTheoThang;
    }

    public static void IncAndCon(Do_Kho doKho, int line, NguoiDung nguoiDung, int type) throws FileNotFoundException, IOException {
        int soLan = soLanGanNhat(nguoiDung);
        ++soLan;
        int rand = randSo(CauHinh.SL_INC);
        QLCauHoi qlch = new QLCauHoi();
        if (type == 2) {
            qlch.docFileIncomplete();
        } else {
            qlch.docFileConversation();
        }
        List<CauHoi> kq = new ArrayList<>();
        kq = qlch.timCauHoi(doKho);
        int j = 1;
        while (kiemTra(line, rand)) {
            rand = randSo(CauHinh.SL_INC);
            j++;
            if (j == CauHinh.SL_INC) {
                System.out.println("Da het cau hoi");
                xoaDs(line);
                break;
            }
        }
        List<CauHoi> list = new ArrayList<>();
        int diem = 0;
        int temp = 0;
        String pad = null;
        for (CauHoi c : kq) {
            if (c.getSoThuTu() == rand) {
                c.hienThi(1);
                System.out.print("Ban chon phuong an:");
                String chon = CauHinh.SC.nextLine();

                pad = c.getPhuongAnDung().toString();
                temp = c.getDoKho().getDiemSo();
                list.add(c);
                if (pad.equalsIgnoreCase(chon)) {
                    diem += temp;
                }
            }
        }
        if (!list.isEmpty()) {
            System.out.println("============DAP AN============");
            list.forEach(c -> {
                c.hienThi(0);
                System.out.print("Phuong an dung: ");
                System.out.println(c.getPhuongAnDung());
                System.out.println("");
            });
        }

        ghiDiem(diem, soLan, nguoiDung);
    }

    public static List<Integer> docFileThongKe(NguoiDung nguoiDung) throws FileNotFoundException {
        String ten = nguoiDung.getHoTen();
        String linkFile = "src/main/java/com/ttb/baitap/file/" + ten;
        File f = new File(linkFile);

        List<Integer> diemList = new ArrayList<>();

        try ( Scanner sc = new Scanner(f)) {
            String line = sc.nextLine();
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                // Bỏ qua các dòng không chứa điểm số
                if (!line.matches("\\d+")) {
                    continue;
                }

                // Chuyển đổi dòng thành số nguyên và thêm vào danh sách
                int diem = Integer.parseInt(line);
                diemList.add(diem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi doc tep tin: " + e.getMessage());
            throw e; // Chuyển tiếp lỗi để xử lý ở lớp gọi
        }

        return diemList;
    }

}
