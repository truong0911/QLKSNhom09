/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dtphong_dv;

/**
 *
 * @author HP
 */
public class DtphongdvDAO extends DBConnext{
    public void themDatdv(dtphong_dv dv){
        String sql = "insert into dtphong_dv(id_dp,id_p,id_dv,soluong,dongia,thanhtien,ngay) values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dv.getPd().getId());
            ps.setInt(2, dv.getP().getId());
            ps.setInt(3, dv.getDv().getId());
            ps.setInt(4, dv.getSoluong());
            ps.setInt(5, dv.getDongia());
            ps.setInt(6, dv.getThanhtien());
            ps.setString(7, dv.getNgay());
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<dtphong_dv> layTatCa(){
        ArrayList<dtphong_dv> list = new ArrayList<dtphong_dv>();
        String sql = "select * from dtphong_dv";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dtphong_dv dpdv = new dtphong_dv();
                PhongdatDAO pd = new PhongdatDAO();
                dpdv.setId(rs.getInt("id"));
                dpdv.setPd(pd.layTheoId(rs.getInt("id_dp")));
                PhongDAO p = new PhongDAO();
                dpdv.setP(p.layTheoId(rs.getInt("id_p")));
                DichvuDAO dv = new DichvuDAO();
                dpdv.setDv(dv.layTheoId(rs.getInt("id_dv")));
                dpdv.setSoluong(rs.getInt("soluong"));
                dpdv.setDongia(rs.getInt("dongia"));
                dpdv.setThanhtien(rs.getInt("thanhtien"));
                dpdv.setNgay(rs.getString("ngay"));
                list.add(dpdv);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<dtphong_dv> layTheoIddp(int id){
        ArrayList<dtphong_dv> list = new ArrayList<>();
        String sql = "select * from dtphong_dv where id_dp="+id;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dtphong_dv dpdv = new dtphong_dv();
                PhongdatDAO pd = new PhongdatDAO();
                dpdv.setId(rs.getInt("id"));
                dpdv.setPd(pd.layTheoId(rs.getInt("id_dp")));
                PhongDAO p = new PhongDAO();
                dpdv.setP(p.layTheoId(rs.getInt("id_p")));
                DichvuDAO dv = new DichvuDAO();
                dpdv.setDv(dv.layTheoId(rs.getInt("id_dv")));
                dpdv.setSoluong(rs.getInt("soluong"));
                dpdv.setDongia(rs.getInt("dongia"));
                dpdv.setThanhtien(rs.getInt("thanhtien"));
                dpdv.setNgay(rs.getString("ngay"));
                list.add(dpdv);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public void update(dtphong_dv dv){
        String sql = "update dtphong_dv set id_dp=?,id_p=?,id_dv=?,soluong=?,dongia=?,thanhtien=?,ngay=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dv.getPd().getId());
            ps.setInt(2, dv.getP().getId());
            ps.setInt(3, dv.getDv().getId());
            ps.setInt(4, dv.getSoluong());
            ps.setInt(5, dv.getDongia());
            ps.setInt(6, dv.getThanhtien());
            ps.setString(7, dv.getNgay());
            ps.executeUpdate();
            
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        DtphongdvDAO dpdv = new DtphongdvDAO();
        System.out.println(dpdv.layTheoIddp(1)); 
    }
}
