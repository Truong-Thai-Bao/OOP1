package com.ttb.baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QLCauHoi {

    private List<CauHoi> ds;

    public QLCauHoi() {
        this.ds = new ArrayList<>();
    }

    public List<CauHoi> timCauHoi(String noiDung) {
        return ds.stream().filter(c -> c.getNoiDung().toLowerCase().contains(noiDung.toLowerCase())).collect(Collectors.toList());
    }

    public List<CauHoi> timCauHoi(Do_Kho doKho) {
        return ds.stream().filter(c -> c.getDoKho().equals(doKho)).collect(Collectors.toList());

    }

    public List<CauHoi> timCauHoi(DanhMuc danhMuc) {
        List<CauHoi> kq = new ArrayList<>();
        for (CauHoi c : ds) {
            if (((MultipleChoice) c).getDanhMuc().toString().toLowerCase().equals(danhMuc.toString().toLowerCase())) {
                kq.add(c);
            }
        }
        return kq;
    }

    public List<CauHoi> docFileMultipleChoice() throws FileNotFoundException {
        File f = new File("src/main/java/com/ttb/baitap/file/MultipleChoice");

        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                int stt = Integer.parseInt(sc.nextLine());
                String dm = sc.nextLine();
                //System.out.println(dm);
                String nd = sc.nextLine();
                List<PhuongAn> listPa = new ArrayList<>();
                String line = sc.nextLine();
                while (sc.hasNext()) {
                    listPa.add(new PhuongAn(line));
                    line = sc.nextLine();
                    //System.out.println(listPa);
                    if (line.isEmpty()) {
                        break;
                    }

                }
                line = sc.nextLine();
                String pad = line;
                //System.out.println(pad);
                Do_Kho doKho = Do_Kho.fromFileValue(Integer.parseInt(sc.nextLine()));
                //System.out.println(doKho);
                String gc = sc.nextLine();
                //System.out.println(gc);
                ds.add(new MultipleChoice(nd, listPa, doKho, new PhuongAn(pad),stt, new DanhMuc(dm), gc));
                //System.out.println(new PhuongAn(dm));
            }
        }
        return ds;
    }

    public List<CauHoi> docFileIncomplete() throws FileNotFoundException {
        File f = new File("src/main/java/com/ttb/baitap/file/Incomplete");
        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String firstLine = sc.nextLine(); // Đọc toàn bộ dòng đầu tiên
                String[] firstLineParts = firstLine.split(" ");

                int stt = Integer.parseInt(firstLineParts[0]);
                Do_Kho doKho = Do_Kho.fromFileValue(Integer.parseInt(firstLineParts[1]));
                // System.out.printf("\n%s\n%s",stt,doKho);

                StringBuilder content = new StringBuilder();
                while (sc.hasNextLine()) {
                    //System.out.println(content);

                    content.append(sc.nextLine()).append("\n");
                    if (sc.nextLine().trim().equals("#")) {
                        sc.nextLine();
                        break;
                    }

                }

                // In ra nội dung đã đọc
                //System.out.println(content);
                //System.out.println(sc.nextLine());
                while (sc.hasNextLine()) {
                    List<PhuongAn> listPa = new ArrayList<>();
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        if (line.trim().isEmpty()) {
                            break;
                        }

                        listPa.add(new PhuongAn(line));
                    }
                    String line = sc.nextLine();
                    String pad = line;
                    ds.add(new Incomplete(content.toString(), listPa, doKho, new PhuongAn(pad), stt));
                    if (sc.nextLine().trim().equals("@")) {
                        break;
                    }

                }

            }
        }
        return ds;
    }

    public List<CauHoi> docFileConversation() throws FileNotFoundException {
        File f = new File("src/main/java/com/ttb/baitap/file/Conversation");
        try ( Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                int stt = Integer.parseInt(sc.nextLine());
                Do_Kho doKho = Do_Kho.fromFileValue(Integer.parseInt(sc.nextLine()));
                //System.out.printf("%s\n%s\n",stt,doKho);
                StringBuilder content = new StringBuilder();
                String li = sc.nextLine();
                while (sc.hasNextLine()) {
                    if (li.trim().equals("#")) {
                        break;
                    }
                    content.append(li).append("\n");
                    li = sc.nextLine();
                }

                // In ra nội dung đã đọc
                // System.out.println(content);
                
                while (sc.hasNextLine()) {
                    li = sc.nextLine();
                    String cauHoiPhu = li;
                    //System.out.println(cauHoiPhu);
                    List<PhuongAn> listPa = new ArrayList<>();
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        if (line.trim().isEmpty()) {
                            break;
                        }

                        listPa.add(new PhuongAn(line));

                    }
                    li = sc.nextLine();
                    //System.out.println(listPa);
                    String pad = li;
                    ds.add(new Conversation(content.toString(), listPa, doKho, new PhuongAn(pad), stt, cauHoiPhu));
                    if (sc.nextLine().trim().equals("@")) {
                        break;
                    }
                }

            }
        }
        return ds;
    }

    public void hienThiDsCauHoi() {
        if(ds.isEmpty()){
            System.out.println("Danh sach cau hoi rong");
            return;
        }
        ds.forEach(c -> c.hienThi(1));
    }

    /**
     * @return the ds
     */
    public List<CauHoi> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<CauHoi> ds) {
        this.ds = ds;
    }
}
