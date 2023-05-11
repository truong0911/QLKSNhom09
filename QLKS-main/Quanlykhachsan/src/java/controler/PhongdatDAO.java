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
import java.util.Date;
import model.PhongDat;

/**
 *
 * @author HP
 */
public class PhongdatDAO extends DBConnext{
    public void themPhongdat(PhongDat pd){
        String sql ="insert into datphong(id_kh,Ngaydat,Ngaytra,Songuoio,status) values(?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pd.getKh().getId());
            ps.setString(2, pd.getNgaydat());
            ps.setString(3, pd.getNgaytra());
            ps.setInt(4, pd.getSongaythuco());
            ps.setInt(5, pd.getStatus());
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<PhongDat> layTatCa(){
        ArrayList<PhongDat> list = new ArrayList<>();
        
        String sql = "select * from datphong";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhongDat pd = new PhongDat();
                pd.setId(rs.getInt("id"));
                KhachHangDAO kh = new KhachHangDAO();
                pd.setKh(kh.layTheoId(rs.getInt("id_kh")));
                pd.setNgaydat(rs.getString("Ngaydat"));
                pd.setNgaytra(rs.getString("Ngaytra"));
                pd.setSongaythuco(rs.getInt("Songuoio"));
                pd.setStatus(rs.getInt("status")); 
                list.add(pd);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public PhongDat layTheoId(int id){
        PhongDat pd = new PhongDat();
        String sql = "select * from datphong where id=" + id;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pd.setId(rs.getInt("id"));
                KhachHangDAO kh = new KhachHangDAO();
                pd.setKh(kh.layTheoId(rs.getInt("id_kh")));
                pd.setNgaydat(rs.getString("Ngaydat"));
                pd.setNgaytra(rs.getString("Ngaytra"));
                pd.setSongaythuco(rs.getInt("Songuoio"));
                pd.setStatus(rs.getInt("status")); 
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return pd;
    }
    
    public void update(PhongDat pd){
        String sql = "update datphong set id_kh=?,Ngaydat=?,Ngaytra=?,Songuoio=?,created_at=?,updated_at=?,status=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pd.getKh().getId());
            ps.setString(2, pd.getNgaydat());
            ps.setString(3, pd.getNgaytra());
            ps.setInt(4, pd.getSongaythuco());
            ps.setInt(7, pd.getStatus()); 
            ps.setInt(8, pd.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void pay(int id){
        
        String sql="update datphong set status=1 where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<PhongDat> layTheoNgay(String ngaydat,String ngaytra){
        ArrayList<PhongDat> list = new ArrayList<>();
        
        String sql = "select * from datphong where Ngaytra between '"+ngaydat+"' and'"+ngaytra+"'";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhongDat pd = new PhongDat();
                pd.setId(rs.getInt("id"));
                KhachHangDAO kh = new KhachHangDAO();
                pd.setKh(kh.layTheoId(rs.getInt("id_kh")));
                pd.setNgaydat(rs.getString("Ngaydat"));
                pd.setNgaytra(rs.getString("Ngaytra"));
                pd.setSongaythuco(rs.getInt("Songuoio"));
                pd.setStatus(rs.getInt("status")); 
                list.add(pd);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        PhongdatDAO p = new PhongdatDAO();
        System.out.println(p.layTheoId(1));  
    }
}
