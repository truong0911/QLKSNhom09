/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author HP
 */
public class KhachHangDAO extends DBConnext{
    public void themKhachHang(KhachHang nd){
        String sql = "insert into khachhang(hoten,sdt,diachi,cccd,deleted) values(?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nd.getHoten());
            ps.setString(2, nd.getSdt());
            ps.setString(3, nd.getDiachi());
            ps.setString(4, nd.getCccd());
            ps.setInt(5, nd.getDeleted());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<KhachHang> layTatCa() {
        ArrayList<KhachHang> list = new ArrayList<>();

        String sql = "select * from khachhang where deleted=0";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang tmp = new KhachHang();
                tmp.setId(rs.getInt("id")); 
                tmp.setHoten(rs.getString("hoten")); 
                tmp.setSdt(rs.getString("sdt"));
                tmp.setDiachi(rs.getString("diachi"));
                tmp.setCccd(rs.getString("cccd"));
                tmp.setDeleted(rs.getInt("deleted")); 
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public KhachHang layTheoId(int idKhachHang) {
        String sql = "select * from khachhang where deleted=0 and id= " + idKhachHang;
        KhachHang tmp = new KhachHang();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tmp.setId(rs.getInt("id"));
                tmp.setHoten(rs.getString("hoten"));
                tmp.setSdt(rs.getString("sdt")); 
                tmp.setDiachi(rs.getString("diachi"));               
                tmp.setCccd(rs.getString("cccd"));
                tmp.setDeleted(rs.getInt("deleted")); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return tmp;
    }
    
    public ArrayList<KhachHang> layTheoTen(String nameKhachHang) {
        ArrayList<KhachHang> list = new ArrayList<>();

        String sql = "select * from khachhang where hoten like '%" + nameKhachHang +"%'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang tmp = new KhachHang();
                tmp.setId(rs.getInt("id")); 
                tmp.setHoten(rs.getString("hoten")); 
                tmp.setSdt(rs.getString("sdt"));
                tmp.setDiachi(rs.getString("diachi"));
                tmp.setCccd(rs.getString("cccd"));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public void delete(int idKhachHang){
        
        String sql="update khachhang set deleted = 1 where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,idKhachHang);
            st.executeUpdate();             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(KhachHang nd){
        String sql = "update khachhang set hoten = ?,diachi=?,sdt=?,cccd=?,deleted=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nd.getHoten());
          
            ps.setString(2, nd.getDiachi());
            ps.setString(3, nd.getSdt());
           
            ps.setString(4, nd.getCccd());
            ps.setInt(5, nd.getDeleted());
            ps.setInt(6, nd.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        KhachHangDAO a = new KhachHangDAO();
//        
        //System.out.println(a.layTheoTen("Bùi")); 
        ArrayList<KhachHang> l = a.layTheoTen("Hào");
        for(KhachHang i:l){
            System.out.println(i);
        }
        a.delete(1);
        
        //a.delete(2);
        //System.out.println(b);
    }
}
