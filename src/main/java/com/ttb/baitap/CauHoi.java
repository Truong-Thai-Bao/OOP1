package com.ttb.baitap;


import java.util.List;


public abstract class CauHoi {

    private String noiDung;
    private List<PhuongAn> phuongAn;
    private Do_Kho doKho;
    private PhuongAn phuongAnDung;
    private int soThuTu;
    
    public abstract void hienThi(int n);

    public CauHoi(String noiDung, List<PhuongAn> phuongAn, Do_Kho doKho, PhuongAn phuongAnDung, int soThuTu) {
        this.noiDung = noiDung;
        this.phuongAn = phuongAn;
        this.doKho = doKho;
        this.phuongAnDung = phuongAnDung;
        this.soThuTu = soThuTu;
    }

    
    
       
    
    
    /**
     * @return the noiDung
     */
    public String getNoiDung() {
        return noiDung;
    }

    /**
     * @param noiDung the noiDung to set
     */
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    /**
     * @return the phuonAn
     */
    

    /**
     * @return the doKho
     */
    public Do_Kho getDoKho() {
        return doKho;
    }

    /**
     * @param doKho the doKho to set
     */
    public void setDoKho(Do_Kho doKho) {
        this.doKho = doKho;
    }

    /**
     * @return the phuongAn
     */
    public List<PhuongAn> getPhuongAn() {
        return phuongAn;
    }

    /**
     * @param phuongAn the phuongAn to set
     */
    public void setPhuongAn(List<PhuongAn> phuongAn) {
        this.phuongAn = phuongAn;
    }

    /**
     * @return the phuongAnDung
     */
    public PhuongAn getPhuongAnDung() {
        return phuongAnDung;
    }

    /**
     * @param phuongAnDung the phuongAnDung to set
     */
    public void setPhuongAnDung(PhuongAn phuongAnDung) {
        this.phuongAnDung = phuongAnDung;
    }

    /**
     * @return the soThuTu
     */
    public int getSoThuTu() {
        return soThuTu;
    }

    /**
     * @param soThuTu the soThuTu to set
     */
    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    /**
     * @return the phuongAn
     */
    


   

    

}
