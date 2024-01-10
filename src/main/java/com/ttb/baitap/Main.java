package com.ttb.baitap;

import com.ttb.baitap.CauHinh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                                qlch.docFileIncomplete();
                                do {
                                    System.out.println("        1. Xem danh sach cau hoi");
                                    System.out.println("        2. Tim cau hoi");
                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                    choice22 = Integer.parseInt(CauHinh.SC.nextLine());
                                    switch (choice22) {
                                        case 1 -> {
                                            qlch.hienThiDsCauHoi();
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
                                qlch.docFileConversation();
                                do {
                                    System.out.println("        1. Xem danh sach cau hoi");
                                    System.out.println("        2. Tim cau hoi");
                                    System.out.print("Nhap lua chon cua ban (0 de thoat): ");
                                    choice23 = Integer.parseInt(CauHinh.SC.nextLine());
                                    switch (choice23) {
                                        case 1 -> {
                                            qlch.hienThiDsCauHoi();
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
                                                        qlch.docFileConversation();
                                                        System.out.println("Nhap noi dung can tim");
                                                        kq = qlch.timCauHoi(CauHinh.SC.nextLine());
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
                                System.out.println("Nhap so luong cau hoi");
                                int n = Integer.parseInt(CauHinh.SC.nextLine());
                                QLCauHoi ds = new QLCauHoi();
                                kq = ds.docFileMultipleChoice();
                                int rand = randSo(10);
                                for (int i = 0; i < n; i++) {
                                    while(kiemTra(1,rand))
                                        rand = randSo(10);
                                    
                                }
                                break;
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

    public static void hienThiDs(List<CauHoi> kq) {
        if (kq.isEmpty()) {
            System.out.println("Khong tim thay ket qua");
            return;
        }
        kq.forEach(c -> c.hienThi(0));
    }

    public static boolean kiemTra(int lineNumber, int targetNumber) throws IOException {
        try (Scanner scanner = new Scanner(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
            StringBuilder content = new StringBuilder();
            int currentLineNumber = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (currentLineNumber == lineNumber) {
                    boolean containsTargetNumber = false;
                    String[] numbers = line.split("\\s+");

                    for (String numberString : numbers) {
                        try {
                            int currentNumber = Integer.parseInt(numberString);
                            content.append(currentNumber).append(" ");
                            if (currentNumber == targetNumber) {
                                containsTargetNumber = true;
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid number format: " + numberString);
                        }
                    }

                    if (!containsTargetNumber) {
                        // Nếu không tìm thấy số, thêm targetNumber vào dòng đó
                        content.append(targetNumber).append(" ");
                    }
                } else {
                    content.append(line).append(System.lineSeparator());
                }

                currentLineNumber++;
            }

            // Ghi lại nội dung vào file
            Chen(content.toString());

            return content.toString().contains(String.valueOf(targetNumber));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + "src/main/java/com/ttb/baitap/file/CauDaLam");
            return false;
        }
    }

    private static void Chen(String content) throws IOException {
        try (FileWriter writer = new FileWriter(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
            writer.write(content);
        }
    }
    
    public static int randSo(int n) {
        Random random = new Random();
        return random.nextInt(n) + 1;
    }
}
