package com.ttb.baitap;

import java.util.List;

public class Conversation extends Incomplete {

    private String cauHoiPhu;

    public Conversation(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung, int soThuTu, String cauHoiPhu) {
        super(noiDung, phuongAn, doKho, phuongAnDung, soThuTu);
        this.cauHoiPhu = cauHoiPhu;
    }
    
    
    @Override
    public void hienThi(int n) {
        if(temp!=getSoThuTu()){
            dem=1;
            flag = true;
        }
        if (flag==true) {
            System.out.println(super.getNoiDung());
            flag = false;
            temp=getSoThuTu();
        }
        System.out.printf("%d.%s\n", dem++, cauHoiPhu);
        for (PhuongAn p : getPhuongAn()) {
            System.out.printf("   %s\n", p);
        }
    }


    /**
     * @return the cauHoiPhu
     */
    public String getCauHoiPhu() {
        return cauHoiPhu;
    }

    /**
     * @param cauHoiPhu the cauHoiPhu to set
     */
    public void setCauHoiPhu(String cauHoiPhu) {
        this.cauHoiPhu = cauHoiPhu;
    }

}
