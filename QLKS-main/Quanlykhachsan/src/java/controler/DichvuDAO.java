/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DichVu;

/**
 *
 * @author HP
 */
public class DichvuDAO extends DBConnext{
    public void themDichvu(DichVu d){
        String sql = "insert into dichvu(ten,gia,deleted) values(?,?,?)"; 
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getTen());
            ps.setInt(2,d.getGia());
            ps.setInt(3,d.getDeleted());
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<DichVu> layTatCa() {
        ArrayList<DichVu> list = new ArrayList<>();

        String sql = "select * from dichvu where deleted=0";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu tmp = new DichVu();
                tmp.setId(rs.getInt("id")); 
                tmp.setTen(rs.getString("ten"));
                tmp.setGia(rs.getInt("gia"));
                tmp.setDeleted(rs.getInt("deleted")); 
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public DichVu layTheoId(int idDV) {
        String sql = "select * from dichvu where deleted=0 and id=" + idDV;
        DichVu tmp = new DichVu();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tmp.setId(rs.getInt("id"));  
                tmp.setGia(rs.getInt("gia")); 
                tmp.setTen(rs.getString("ten"));
                tmp.setDeleted(rs.getInt("deleted")); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return tmp;
    }
    
    public ArrayList<DichVu> layTheoTen(String tenDv) {
        ArrayList<DichVu> list = new ArrayList<>();

        String sql = "select * from dichvu where ten like '%" + tenDv + "%'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DichVu tmp = new DichVu();
                tmp.setId(rs.getInt("id")); 
                tmp.setTen(rs.getString("ten"));
                tmp.setGia(rs.getInt("gia"));
                tmp.setDeleted(rs.getInt("deleted")); 
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public void delete(int idDV){
        
        String sql="update dichvu set deleted=1 where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,idDV);
            st.executeUpdate();
             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(DichVu p){
        String sql = "update dichvu set ten = ?,gia=?,deleted=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getTen());
          
            ps.setInt(2, p.getGia());
            ps.setInt(3, p.getDeleted());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        DichvuDAO a = new DichvuDAO();
        System.out.println(a.layTheoId(1)); 
    }
}
