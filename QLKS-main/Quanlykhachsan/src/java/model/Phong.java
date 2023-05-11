/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author  
 */
public class Phong {
    private int id;
    private Loaiphong lp;
    private String tenphong;
    private String status;
    private int deleted;

    public Phong() {
    }

    public Phong(int id, Loaiphong lp, String tenphong, String status, int deleted) {
        this.id = id;
        this.lp = lp;
        this.tenphong = tenphong;
        this.status = status;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Loaiphong getLp() {
        return lp;
    }

    public void setLp(Loaiphong lp) {
        this.lp = lp;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    
    public String toString(){
        return "Phong{ id = " + id + ", Loaiphong = " + lp + ", tenphong = " + 
                tenphong +", status = " + status + ", deleted=" + deleted + "}";
    }
}
