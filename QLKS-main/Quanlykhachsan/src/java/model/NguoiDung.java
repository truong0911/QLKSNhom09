/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class NguoiDung {
    private int id;
    private String hoten;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private String chucvu;
    private String cccd;
    private String tkhoan;
    private String pwd;

    public NguoiDung() {
    }

    public NguoiDung(int id, String hoten, String gioitinh, String diachi, String sdt, String chucvu, String cccd, String tkhoan, String pwd) {
        this.id = id;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.cccd = cccd;
        this.tkhoan = tkhoan;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getTkhoan() {
        return tkhoan;
    }

    public void setTkhoan(String tkhoan) {
        this.tkhoan = tkhoan;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String toString(){
        return "NguoiDung{" + "id=" + id + ",hoten=" + hoten + ", gioitinh=" + gioitinh + ",diachi=" + diachi+
                ", sdt=" + sdt + ", chucvu=" + chucvu + ", cccd=" + cccd + ", tkhoan=" + tkhoan + ", pass=" + pwd + "}";
    }
}
