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
import model.Phong;

/**
 *
 * @author HP
 */
public class PhongDAO extends DBConnext{
    public void themPhong(Phong p){
        String sql = "insert into phong(id_l,tenphong,status,deleted) values(?,?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getLp().getId());
            ps.setString(2, p.getTenphong());
            ps.setString(3, p.getStatus());
            ps.setInt(4, p.getDeleted()); 
            ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Phong> layTatCa(){
        ArrayList<Phong> list = new ArrayList<>();
        
        String sql = "select * from phong where deleted=0";
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setId(rs.getInt("id"));
                LoaiphongDAO lp = new LoaiphongDAO();
                p.setLp(lp.layTheoId(rs.getInt("id_l")));
                p.setTenphong(rs.getString("tenphong"));
                p.setStatus(rs.getString("status"));
                p.setDeleted(rs.getInt("deleted")); 
                list.add(p);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public Phong layTheoId(int id){
        Phong p = new Phong();
        String sql = "select * from phong where deleted=0 and id="+id;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                LoaiphongDAO lp = new LoaiphongDAO();
                p.setLp(lp.layTheoId(rs.getInt("id_l")));
                p.setTenphong(rs.getString("tenphong"));
                p.setStatus(rs.getString("status"));
                p.setDeleted(rs.getInt("deleted"));
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return p;
    }
    
    public void delete(int id){
        
        String sql="update phong set deleted=1 where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void datp(int id){
        
        String sql="update phong set status='action' where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void payp(int id){
        
        String sql="update phong set status='no action' where id=?";
        try{
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();
             
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void update(Phong p){
        String sql = "update phong set id_l=?,tenphong=?,status=?,deleted=? where id=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getLp().getId());
            ps.setString(2, p.getTenphong());
            ps.setString(3, p.getStatus());
            ps.setInt(4, p.getDeleted());
            ps.setInt(5, p.getId()); 
          
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        PhongDAO a = new PhongDAO();
        System.out.println(a.layTheoId(1)); 
    }
}
