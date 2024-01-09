package com.ttb.baitap;

import java.util.List;

public class Incomplete extends CauHoi {

    protected static int dem=1;
    protected int soThuTu;

    protected static int temp = 1;

    public Incomplete() {
        super(null, null, null, null);
    }

    public Incomplete(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung, int soThuTu) {
        super(noiDung, phuongAn, doKho, phuongAnDung);
        this.soThuTu = soThuTu;
    }


    @Override
    public void hienThi() {
        if (soThuTu == temp) {
            System.out.println(super.getNoiDung());
            temp++;
        }
        for (PhuongAn p : getPhuongAn()) {
            System.out.printf("%d. %s\t", dem, p);
        }
        dem++;
        System.out.println();

    }

}
