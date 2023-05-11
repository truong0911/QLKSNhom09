/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class KhachHang {
    private int id;
    private String hoten;
    private String sdt;
    private String diachi;
    private String cccd;
    private int deleted;

    public KhachHang() {
    }

    public KhachHang(int id, String hoten, String sdt, String diachi, String cccd, int deleted) {
        this.id = id;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.cccd = cccd;
        this.deleted = deleted;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    
    
    public String toString(){
        return "KhachHang{" + "id=" + id + ", hoten=" + hoten + ", sdt=" + sdt +
                ", diachi=" + diachi + ", cccd=" + cccd + ", deleted=" + deleted +"}";
    }
}
