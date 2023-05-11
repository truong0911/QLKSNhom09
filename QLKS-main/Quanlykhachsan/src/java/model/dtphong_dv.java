/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class dtphong_dv {
    private int id;
    private PhongDat pd;
    private Phong p;
    private DichVu dv;
    private int soluong;
    private int dongia;
    private int thanhtien;
    private String ngay;

    public dtphong_dv() {
    }

    public dtphong_dv(int id, PhongDat pd, Phong p, DichVu dv, int soluong, int dongia, int thanhtien, String ngay) {
        this.id = id;
        this.pd = pd;
        this.p = p;
        this.dv = dv;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhongDat getPd() {
        return pd;
    }

    public void setPd(PhongDat pd) {
        this.pd = pd;
    }

    public Phong getP() {
        return p;
    }

    public void setP(Phong p) {
        this.p = p;
    }

    public DichVu getDv() {
        return dv;
    }

    public void setDv(DichVu dv) {
        this.dv = dv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
    
    public String toString(){
        return "dtphong_dv{ id = " + id + ", PhongDat = " +pd + ", Phong = " + p + ", DichVu = " + dv +
                ", soluong = " + soluong + ", dongia = " + dongia + ", thanhtien = " + thanhtien + ", ngay = " + ngay + "}"; 
    }
}
