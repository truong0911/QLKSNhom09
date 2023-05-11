/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class DichVu {
    private int id;
    private String ten;
    private int gia;
    private int deleted;

    public DichVu() {
    }

    public DichVu(int id, String ten, int gia, int deleted) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    
    public String toString(){
        return "DichVu{" + "id=" + id + ", ten=" + ten + ", gia=" + gia + ", deleted=" + deleted +"}";
    }
}
