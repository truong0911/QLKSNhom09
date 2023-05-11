/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Loaiphong {
    private int id;
    private String tenloai;
    private int dongia;
    private int songuoi;
    private int sogiuong;

    public Loaiphong() {
    }

    public Loaiphong(int id, String tenloai, int dongia, int songuoi, int sogiuong) {
        this.id = id;
        this.tenloai = tenloai;
        this.dongia = dongia;
        this.songuoi = songuoi;
        this.sogiuong = sogiuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getSonguoi() {
        return songuoi;
    }

    public void setSonguoi(int songuoi) {
        this.songuoi = songuoi;
    }

    public int getSogiuong() {
        return sogiuong;
    }

    public void setSogiuong(int sogiuong) {
        this.sogiuong = sogiuong;
    }
    
    public String toString(){
        return "Loaiphong{id = " + id + ", tenloai = " + tenloai + ", dongia = " 
                + dongia + ", songuoi = " + songuoi + ", sogiuong = " + sogiuong + " }";
    }
}
