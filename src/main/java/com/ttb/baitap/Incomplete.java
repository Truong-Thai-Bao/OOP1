package com.ttb.baitap;


import java.util.List;

public class Incomplete extends CauHoi {

    private static int dem;
    private int soThuTu;
    
    private static int temp=1;
    public Incomplete() {
        super(null, null, null, null);
    }

    public Incomplete(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung,int soThuTu) {
        super(noiDung, phuongAn, doKho, phuongAnDung);
        this.soThuTu= soThuTu;
    }

    

    @Override
    public void phuongAn() {
        
    }

    @Override
    public void hienThi() {
        if(this.soThuTu==temp){
            System.out.println(super.getNoiDung());
            temp++;
        }
        System.out.println(super.getPhuongAn());
    }

    
	
}
