/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttb.baitap;

//import static com.ttb.baitap.Main.ghiDiem;
import static com.ttb.baitap.Main.ghiDiem;
import static com.ttb.baitap.Main.IncAndCon;
import static com.ttb.baitap.Main.kiemTra;
import static com.ttb.baitap.Main.randSo;
import static com.ttb.baitap.Main.xoaDs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        QLCauHoi ql = new QLCauHoi();
        //  ql.docFileConversation();
        //ql.docFileIncomplete();
        //ql.docFileMultipleChoice();
        //  ql.hienThiDsCauHoi();
        // boolean b = checkAndInsertNumber(1,5);
//        System.out.println(a);
//        List<Integer> b = Inc();
//        System.out.println(b);
//        List<Integer> c = Con();
//        System.out.println(c);
        //kiemTra(3, 4);
        //kiemTraVaChenTrongFile(2, 3);
        //  ghiFile(20);
//        int choice32;
        //List<CauHoi> kq = new ArrayList<>();
//        
//        int rand = randSo(2);
//        int diem = 0;
//        int j = 1;
//        String pad = null;
        //List<CauHoi> list = new ArrayList<>();
//        do {
//            System.out.println("Chon do kho");
//            System.out.println("    1. De");
//            System.out.println("    2. Trung binh");
//            System.out.println("    3. Kho");
//            System.out.print("Nhap lua chon cua ban (0 de thoat): ");
//            choice32 = Integer.parseInt(CauHinh.SC.nextLine());
//            switch (choice32) {
//                case 3 -> {
//                    QLCauHoi qlch = new QLCauHoi();
//                    qlch.docFileIncomplete();
//                    kq = qlch.timCauHoi(Do_Kho.KHO);
//                    while (kiemTra(2, rand)) {
//                        rand = randSo(2);
//                        j++;
//                        if (j == 2) {
//                            System.out.println("Da het cau hoi");
//                            return;
//                        }
//                    }
//                    for (CauHoi c : kq) {
//                        if (c.getSoThuTu() == rand) {
//                            c.hienThi(1);
//                            System.out.print("Ban chon phuong an:");
//                            String chon = CauHinh.SC.nextLine();
//                            if (chon.equalsIgnoreCase(pad)) 
//                                ghiDiem(diem);
//                            
//                            pad = c.getPhuongAnDung().toString();
//                            diem = c.getDoKho().getDiemSo();
//                            list.add(c);
//                        }
//                    }
//                    list.forEach(c -> {
//                        c.hienThi(0);
//                        System.out.print("Phuong an dung: ");
//                        System.out.println(c.getPhuongAnDung());
//                        System.out.println("");
//                    });
//                    break;
//                }
//
//            }
//
//        } while (choice32 != 0);
//        int rand = randSo(CauHinh.SL_CON);
//        int j = 1;
//        int diem = 0;
//        String pad = null;
//        QLCauHoi qlch = new QLCauHoi();
//        qlch.docFileConversation();
//        kq = qlch.timCauHoi(Do_Kho.TRUNG_BINH);
//        while (kiemTra(3, rand)) {
//            rand = randSo(CauHinh.SL_CON);
//            j++;
//            if (j == CauHinh.SL_CON) {
//                System.out.println("Da het cau hoi");
//                return;
//            }
//        }
//       
//        for (CauHoi c : kq) {
//            if (c.getSoThuTu() == rand) {
//                c.hienThi(1);
//                System.out.print("Ban chon phuong an:");
//                String chon = CauHinh.SC.nextLine();
//                if (chon.equalsIgnoreCase(pad)) {
//                    ghiDiem(diem);
//                }
//
//                pad = c.getPhuongAnDung().toString();
//                diem = c.getDoKho().getDiemSo();
//                list.add(c);
//            }
//        }
//        System.out.println("============DAP AN============");
//        list.forEach(c -> {
//            c.hienThi(0);
//            System.out.print("Phuong an dung: ");
//            System.out.println(c.getPhuongAnDung());
//            System.out.println("");
//        });
        //ghiDiem(2,3);
        //System.out.println(readNearLastIntegerFromFile("src/main/java/com/ttb/baitap/file/ThongKeLuyenTap"));
        //xoaDsDaLam(2);
        //IncAndCon(Do_Kho.KHO, 2, nguoiDung);
    }

    public static int soLanGanNhat(String filePath) throws FileNotFoundException {
        ArrayList<Integer> integers = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNext()) {
                String token = sc.next();
                try {
                    int number = Integer.parseInt(token);
                    integers.add(number);
                } catch (NumberFormatException e) {
                    // Nếu không phải số nguyên, bỏ qua
                }
            }
        }

        // Nếu có ít nhất 2 số nguyên trong mảng, trả về số gần cuối
        if (integers.size() >= 2) {
            return integers.get(integers.size() - 2);
        } else {
            // Nếu không đủ số nguyên, có thể xử lý theo ý của bạn (throw exception, trả về giá trị mặc định, etc.)
            throw new RuntimeException("Không đủ số nguyên trong file.");
        }
    }

    public static boolean kiemTraVaChen(int x, List<Integer> dong) {
        if (dong.contains(x)) {
            // Nếu x đã tồn tại trong dòng, trả về false
            return false;
        } else {
            // Nếu x không tồn tại trong dòng, chèn x vào dòng và trả về false
            dong.add(x);
            return true;
        }
    }

    public static void kiemTraVaChenTrongFile(int soDong, int x) {
        List<List<Integer>> danhSachDong = new ArrayList<>();

        // Đọc dữ liệu từ tệp tin vào danhSachDong
        try ( BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/java/com/ttb/baitap/file/CauDaLam")))) {
            for (int i = 0; i < soDong; i++) {
                String line = reader.readLine();
                if (line != null) {
                    String[] tokens = line.split(" ");
                    List<Integer> dong = new ArrayList<>();
                    for (String token : tokens) {
                        dong.add(Integer.parseInt(token));
                    }
                    danhSachDong.add(dong);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean ketQua = kiemTraVaChen(x, danhSachDong.get(soDong - 1));

        // Ghi dữ liệu vào tệp tin
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/java/com/ttb/baitap/file/CauDaLam")))) {
            for (List<Integer> dong : danhSachDong) {
                for (Integer so : dong) {
                    writer.write(so + " ");
                }
                writer.newLine(); // Xuống dòng sau mỗi dòng
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ketQua) {
            System.out.println(x + " chưa tồn tại trong dòng cuối cùng. Đã chèn thành công.");
        } else {
            System.out.println(x + " đã tồn tại trong dòng cuối cùng. Không thực hiện chèn.");
        }
    }

    public static boolean checkAndInsertNumber(int lineNumber, int targetNumber) throws IOException {
        try ( Scanner scanner = new Scanner(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
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
            writeContentToFile(content.toString());

            return content.toString().contains(String.valueOf(targetNumber));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + "src/main/java/com/ttb/baitap/file/CauDaLam");
            return false;
        }
    }

    private static void writeContentToFile(String content) throws IOException {
        try ( FileWriter writer = new FileWriter(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
            writer.write(content);
        }
    }

    public static List<Integer> Inc() throws FileNotFoundException {
        List<Integer> numbers = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            if (sc.hasNextLine()) {
                String line = sc.nextLine().trim(); // Đọc hàng đầu và loại bỏ khoảng trắng thừa
                if (!line.isEmpty()) {
                    Scanner lineScanner = new Scanner(line); // Sử dụng Scanner mới cho hàng đầu đã đọc
                    while (lineScanner.hasNextInt()) {
                        int number = lineScanner.nextInt();
                        numbers.add(number);
                    }
                } else {
                    return null; // Trả về null nếu hàng đầu rỗng
                }
            }

            return numbers;
        }
    }

    public static List<Integer> Con() throws FileNotFoundException {
        List<Integer> numbers = new ArrayList<>();

        try ( Scanner sc = new Scanner(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
            if (sc.hasNextLine()) {
                sc.nextLine();
                sc.nextLine();
            }
            if (sc.hasNextLine()) {
                String line = sc.nextLine().trim(); // Đọc hàng đầu và loại bỏ khoảng trắng thừa
                if (!line.isEmpty()) {
                    Scanner lineScanner = new Scanner(line); // Sử dụng Scanner mới cho hàng đầu đã đọc
                    while (lineScanner.hasNextInt()) {
                        int number = lineScanner.nextInt();
                        numbers.add(number);
                    }
                } else {
                    return null; // Trả về null nếu hàng đầu rỗng
                }
            }

            return numbers;
        }
    }

    public static void ghiFile(int diem) {
        // Đường dẫn của file cần ghi
        String tenFile = "src/main/java/com/ttb/baitap/file/ThongKeLuyenTap"; // Thay đổi đường dẫn và tên file tùy ý

        try {
            // Đọc nội dung từ file
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String[] lines = new String[6]; // Mảng lưu trữ 6 dòng

            // Đọc dòng từ file và lưu vào mảng
            for (int i = 0; i < 6; i++) {
                lines[i] = br.readLine();
            }

            // Đóng đối tượng đọc file
            br.close();
            if (lines[5].trim().isEmpty()) // Ghi giá trị mới vào dòng thứ 6
            {
                lines[5] = Integer.toString(diem);
            } else {
                lines[5] = Integer.toString(diem + Integer.parseInt(lines[5]));
            }

            // Ghi lại toàn bộ nội dung vào file
            BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

            // Đóng đối tượng ghi file
            bw.close();

            System.out.println("Ghi thành công vào file.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
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

    
//    public static void ghiFile(int diem) throws FileNotFoundException, IOException {
//        File f = new File("src/main/java/com/ttb/baitap/file/CauDaLam");
//        FileWriter fw = new FileWriter(f, true);
//        try(PrintWriter w = new PrintWriter(fw)){
//            w.println(); 
//                
//        }
//    }
}
