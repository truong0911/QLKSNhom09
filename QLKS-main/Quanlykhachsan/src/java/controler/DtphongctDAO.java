/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.dtphong_ct;

/**
 *
 * @author HP
 */
public class DtphongctDAO extends DBConnext{
    public void themCTDatphong(dtphong_ct dtp){
        String sql = "insert into dtphong_ct(id_dp,id_p,songayo,dongia,thanhtien,ngay) values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dtp.getPd().getId());
            ps.setInt(2, dtp.getP().getId());
            ps.setInt(3, dtp.getSongayo());
            ps.setInt(4, dtp.getDongia());
            ps.setInt(5, dtp.getThanhtien());
            SimpleDateFormat df = new SimpleDateFormat("mm:HH dd/MM/yyyy");
            ps.setString(6, dtp.getNgay());
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<dtphong_ct> layTatCa(){
        ArrayList<dtphong_ct> list = new ArrayList<dtphong_ct>();
        
        String sql = "select * from dtphong_ct";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dtphong_ct dpct = new dtphong_ct();
                dpct.setId(rs.getInt("id"));
                PhongdatDAO pd = new PhongdatDAO();
                dpct.setPd(pd.layTheoId(rs.getInt("id_dp")));
                PhongDAO p = new PhongDAO();
                dpct.setP(p.layTheoId(rs.getInt("id_p")));
                dpct.setSongayo(rs.getInt("songayo"));
                dpct.setDongia(rs.getInt("dongia"));
                dpct.setThanhtien(rs.getInt("thanhtien"));
                dpct.setNgay(rs.getString("ngay")); 
                list.add(dpct);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<dtphong_ct> layTheoIdpd(int id){
        ArrayList<dtphong_ct> list = new ArrayList<>();
        String sql = "select * from dtphong_ct where id_dp =" + id;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dtphong_ct dpct = new dtphong_ct(); 
                dpct.setId(rs.getInt("id"));
                PhongdatDAO pd = new PhongdatDAO();
                dpct.setPd(pd.layTheoId(rs.getInt("id_dp")));
                PhongDAO p = new PhongDAO();
                dpct.setP(p.layTheoId(rs.getInt("id_p")));
                dpct.setSongayo(rs.getInt("songayo"));
                dpct.setDongia(rs.getInt("dongia"));
                dpct.setThanhtien(rs.getInt("thanhtien"));
                dpct.setNgay(rs.getString("ngay"));
                list.add(dpct);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public void update(dtphong_ct dp){
        String sql = "update dtphong_ct set id_dp=?,id_p=?,songayo=?,dongia=?,thanhtien=?,ngay=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dp.getPd().getId());
            ps.setInt(2, dp.getP().getId());
            ps.setInt(3, dp.getSongayo());
            ps.setInt(4, dp.getDongia());
            ps.setInt(5, dp.getThanhtien());
            ps.setString(6, dp.getNgay());
            ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        DtphongctDAO dpct = new DtphongctDAO();
        System.out.println(dpct.layTheoIdpd(1)); 
    }
}
