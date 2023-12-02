/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pert3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pert3.data_absen;
import pert3.koneksi;
/**
 *
 * @author Daffa
 */
public class daoData_absen implements implementData_absen {
    Connection c;
    final String insert = "insert into data_absen VALUES (?,?,?)";
    final String update = "update data_absen set name=?, npm=?, kelas=?";
    final String delete = "delete from data_absen where npm=?";
    final String select = "select * from data_absen";
    final String carinpm = "select * from data_absen where npm=?";
    
    public daoData_absen(){
        c = koneksi.connection();
    }
    
    @Override
    public void insert (data_absen a){
        PreparedStatement stm = null;
        try{
            stm = c.prepareStatement (insert);
            stm.setString(1, a.getNama());
            stm.setString(2, a.getNPM());
            stm.setString(3, a.getKelas());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while(rs.next()){
                a.setNama(rs.getString(2));
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                stm.close();
            }catch(Exception ex){
            ex.printStackTrace();
            }
        }
        
        
    }
    @Override
        public List<data_absen> getAll(){
         List<data_absen> lb =null;
         try{
             lb = new ArrayList<data_absen>();
             Statement stm = c.createStatement();
             ResultSet rs = stm.executeQuery(select);
             while(rs.next()){
                 data_absen da= new data_absen();
                 da.setNama(rs.getString("nama"));
                 da.setNPM(rs.getString("npm"));
                 da.setKelas(rs.getString("kelas"));
                 lb.add(da);
             }
             }catch(Exception ex){
                     Logger.getLogger(daoData_absen.class.getName()).log(Level.SEVERE, null,ex);
                     
             }
             return lb;
         
    }
}
