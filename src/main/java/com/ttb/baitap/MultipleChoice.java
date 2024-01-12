package com.ttb.baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MultipleChoice extends CauHoi {

    private DanhMuc danhMuc;
    private String ghiChu;
    private static int dem = 1;

    public MultipleChoice() {
        super(null, null, null, null, 0);
    }

    public MultipleChoice(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung, int soThuTu, DanhMuc danhMuc, String ghiChu) {
        super(noiDung, phuongAn, doKho, phuongAnDung, soThuTu);
        this.danhMuc = danhMuc;
        this.ghiChu = ghiChu;
    }

    @Override
    public void hienThi(int n) {
        if (n == 0) {
            System.out.printf("%s\n", super.getNoiDung());
        } else {
            System.out.printf("%d. %s\n", dem++, super.getNoiDung());
        }
        for (PhuongAn p : super.getPhuongAn()) {
            System.out.printf("%s\t", p);
        }
        System.out.println();
        System.out.println();
    }

    /**
     * @return the danhMuc
     */
    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
