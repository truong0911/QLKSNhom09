/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.NguoiDung;

/**
 *
 * @author HP
 */
public class NguoiDungDAO extends DBConnext{
    public void themNguoiDung(NguoiDung nd){
        String sql = "insert into users(hoten,giotinh,diachi,sdt,chucvu,cccd,username,password) values(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nd.getHoten());
            ps.setString(2, nd.getGioitinh());
            ps.setString(3, nd.getDiachi());
            ps.setString(4, nd.getSdt());
            ps.setString(5, nd.getChucvu());
            ps.setString(6, nd.getCccd());
            ps.setString(7, nd.getTkhoan());
            ps.setString(8, nd.getPwd());
            
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<NguoiDung> layTatCa() {
        ArrayList<NguoiDung> list = new ArrayList<>();

        String sql = "select * from users";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung tmp = new NguoiDung();
                tmp.setId(rs.getInt("id")); 
                tmp.setHoten(rs.getString("hoten")); 
                tmp.setGioitinh(rs.getString("giotinh"));
                tmp.setDiachi(rs.getString("diachi"));
                tmp.setSdt(rs.getString("sdt"));
                tmp.setChucvu(rs.getString("chucvu"));
                tmp.setCccd(rs.getString("cccd"));
                tmp.setTkhoan(rs.getString("username"));
                tmp.setPwd(rs.getString("password"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public NguoiDung layTheoId(int idNguoiDung) {
        String sql = "select * from users where id= " + idNguoiDung;
        NguoiDung tmp = new NguoiDung();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tmp.setId(rs.getInt("id"));
                tmp.setHoten(rs.getString("hoten")); 
                tmp.setGioitinh(rs.getString("giotinh"));
                tmp.setDiachi(rs.getString("diachi"));
                tmp.setSdt(rs.getString("sdt"));
                tmp.setChucvu(rs.getString("chucvu"));
                tmp.setCccd(rs.getString("cccd"));
                tmp.setTkhoan(rs.getString("username"));
                tmp.setPwd(rs.getString("password")); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return tmp;
    }
    
    public ArrayList<NguoiDung> layTheoTen(String nameNguoiDung) {
        ArrayList<NguoiDung> list = new ArrayList<>();

        String sql = "select * from users where hoten like '%" + nameNguoiDung +"%'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung tmp = new NguoiDung();
                tmp.setId(rs.getInt("id"));
                tmp.setHoten(rs.getString("hoten")); 
                tmp.setGioitinh(rs.getString("giotinh"));
                tmp.setDiachi(rs.getString("diachi"));
                tmp.setSdt(rs.getString("sdt"));
                tmp.setChucvu(rs.getString("chucvu"));
                tmp.setCccd(rs.getString("cccd"));
                tmp.setTkhoan(rs.getString("username"));
                tmp.setPwd(rs.getString("password")); 
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public NguoiDung check(String user,String pass){
        String sql = "select * from users where username=? and password=?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,user);
            st.setString(2,pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new NguoiDung(rs.getInt("id"),rs.getString("hoten"),rs.getString("giotinh"),rs.getString("diachi"),
                                    rs.getString("sdt"),rs.getString("chucvu"),rs.getString("cccd"),user,pass);
            }
        } catch(SQLException e){
            
        }
        return null;
    }
    
    public NguoiDung ktuser(String user){
        String sql = "select * from users where username=?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,user);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new NguoiDung(rs.getInt("id"),rs.getString("hoten"),rs.getString("giotinh"),rs.getString("diachi"),
                                    rs.getString("sdt"),rs.getString("chucvu"),rs.getString("cccd"),user,rs.getString("password"));
            }
        } catch(SQLException e){
            
        }
        return null;
    }
    
    public NguoiDung ktpass(String pass){
        String sql = "select * from users where password=?";
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new NguoiDung(rs.getInt("id"),rs.getString("hoten"),rs.getString("giotinh"),rs.getString("diachi"),
                                    rs.getString("sdt"),rs.getString("chucvu"),rs.getString("cccd"),rs.getString("taikhoan"),pass);
            }
        } catch(SQLException e){
            
        }
        return null;
    }
    
    public void delete(int idNguoiDung){
        
        String sql="delete from users where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,idNguoiDung);
            st.executeUpdate();             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(NguoiDung nd){
        String sql = "update users set hoten=?,giotinh=?,diachi=?,sdt=?,chucvu=?,cccd=?,username=?,password=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nd.getHoten());
            ps.setString(2, nd.getGioitinh());
            ps.setString(3, nd.getDiachi());
            ps.setString(4, nd.getSdt());
            ps.setString(5, nd.getChucvu());
            ps.setString(6, nd.getCccd());
            ps.setString(7, nd.getTkhoan());
            ps.setString(8, nd.getPwd());
            ps.setInt(9, nd.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        NguoiDungDAO a= new NguoiDungDAO();
        //NguoiDung b = new NguoiDung(3,"Nguyen Hoang Viet","Nam","Ha Dong","02345678","quản lý","030201040506","vietnh","12345678");
        //a.update(b); 
        NguoiDung c = a.check("PhucDT12","12345678");
        System.out.println(c); 
        Date date=new Date();   
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date); 
        System.out.println(c1.getTime().getTime()); 
        
        //a.delete(1); 
    }
}
