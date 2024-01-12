package com.ttb.baitap;

import java.util.List;

public class Incomplete extends CauHoi {

    protected static boolean flag = true;
    protected static int temp = 1;
    protected static int dem=1;
    public Incomplete() {
        super(null, null, null, null,0);
    }

    public Incomplete(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung, int soThuTu) {
        super(noiDung, phuongAn, doKho, phuongAnDung,soThuTu);
    }

    @Override
    public void hienThi(int n) {
        System.out.println();
        if(temp!=getSoThuTu()){
            flag = true;
            dem=1;
        }
        if (flag==true) {
            System.out.println(super.getNoiDung());
            flag = false;
            temp=getSoThuTu();
        }
        if(n!=0)
            System.out.printf("%d. ",dem);
        for (PhuongAn p : getPhuongAn()) {
                System.out.printf("%s\t", p);
        }
        ++dem;
        System.out.println();

    }

}
