package com.ttb.baitap;

import java.util.List;

public class Incomplete extends CauHoi {

    protected static int dem = 1;
    protected int soThuTu;
    protected static boolean flag = true;
    protected static int temp = 1;

    public Incomplete() {
        super(null, null, null, null);
    }

    public Incomplete(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung, int soThuTu) {
        super(noiDung, phuongAn, doKho, phuongAnDung);
        this.soThuTu = soThuTu;
    }

    @Override
    public void hienThi(int n) {
        if(temp!=soThuTu)
            flag = true;
        if (flag==true) {
            System.out.println(super.getNoiDung());
            flag = false;
            temp=soThuTu;
        }
        
        for (PhuongAn p : getPhuongAn()) {
            if (n == 0) {
                System.out.printf("%s\t", p);
            } else {
                System.out.printf("%d. %s\t", dem, p);
            }
        }
        dem++;
        System.out.println();

    }

}
