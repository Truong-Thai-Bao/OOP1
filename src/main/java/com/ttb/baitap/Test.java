/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttb.baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        boolean b = checkAndInsertNumber(3,5);
//        System.out.println(a);
//        List<Integer> b = Inc();
//        System.out.println(b);
//        List<Integer> c = Con();
//        System.out.println(c);
    }

       public static boolean checkAndInsertNumber(int lineNumber, int targetNumber) throws IOException {
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
            writeContentToFile(content.toString());

            return content.toString().contains(String.valueOf(targetNumber));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + "src/main/java/com/ttb/baitap/file/CauDaLam");
            return false;
        }
    }

    private static void writeContentToFile(String content) throws IOException {
        try (FileWriter writer = new FileWriter(new File("src/main/java/com/ttb/baitap/file/CauDaLam"))) {
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
}
