/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttb.baitap;

import static com.ttb.baitap.Main.ghiDiem;
import static com.ttb.baitap.Main.kiemTra;
import static com.ttb.baitap.Main.randSo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        QLCauHoi ql = new QLCauHoi();
        //ql.docFileConversation();
        //ql.docFileIncomplete();
        //ql.docFileMultipleChoice();
        //ql.hienThiDsCauHoi();
        // boolean b = checkAndInsertNumber(1,5);
//        System.out.println(a);
//        List<Integer> b = Inc();
//        System.out.println(b);
//        List<Integer> c = Con();
//        System.out.println(c);
        //  ghiFile(20);
        
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

//    public static void ghiFile(int diem) throws FileNotFoundException, IOException {
//        File f = new File("src/main/java/com/ttb/baitap/file/CauDaLam");
//        FileWriter fw = new FileWriter(f, true);
//        try(PrintWriter w = new PrintWriter(fw)){
//            w.println(); 
//                
//        }
//    }
}
