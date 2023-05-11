/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Loaiphong;

/**
 *
 * @author HP
 */
public class LoaiphongDAO extends DBConnext{
    public void themLoai(Loaiphong lp){
        String sql = "insert into loaiphong(tenloai,songuoi,sogiuong,dongia) values(?,?,?,?)";
        try{
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1,lp.getTenloai());
           ps.setInt(2,lp.getSonguoi());
           ps.setInt(3, lp.getSogiuong());
           ps.setInt(4, lp.getDongia());
           ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Loaiphong> layTatCa(){
        ArrayList<Loaiphong> list = new ArrayList<>();
        
        String sql = "select * from loaiphong";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Loaiphong lp = new Loaiphong();
                lp.setId(rs.getInt("id")); 
                lp.setTenloai(rs.getString("tenloai"));
                lp.setSonguoi(rs.getInt("songuoi"));
                lp.setSogiuong(rs.getInt("sogiuong"));
                lp.setDongia(rs.getInt("dongia"));
                list.add(lp);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public Loaiphong layTheoId(int id){
        Loaiphong lp = new Loaiphong();
        
        String sql = "select * from loaiphong where id =" + id;
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lp.setId(rs.getInt("id")); 
                lp.setTenloai(rs.getString("tenloai"));
                lp.setSonguoi(rs.getInt("songuoi"));
                lp.setSogiuong(rs.getInt("sogiuong"));
                lp.setDongia(rs.getInt("dongia"));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return lp;
    }
    
    public void delete(int id){
        
        String sql="delete from loaiphong where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(Loaiphong lp){
        String sql = "update loaiphong set tenloai = ?,songuoi=?,sogiuong=?,dongia=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lp.getTenloai());
          
            ps.setInt(2, lp.getSonguoi());
            ps.setInt(3, lp.getSogiuong());
           
            ps.setInt(4, lp.getDongia());
            ps.setInt(5, lp.getId()); 
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        LoaiphongDAO a = new LoaiphongDAO();
        System.out.println(a.layTheoId(1)); 
    }
    
}
