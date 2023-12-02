/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pert3;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daffa
 */
public class table_absen extends AbstractTableModel {
    List<data_absen> lb;
    
    public table_absen( List<data_absen> lb){
        this.lb=lb;
    }
    
    @Override
    public int getRowCount(){
        return lb.size();
    }
    
    @Override
    public int getColumnCount(){
        return 3;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return"nama";
            case 1:
                return"npm";
            case 2:
                return"kelas";
            default:
                return null;
        }
    
    }
    
    
    @Override
    public Object getValueAt(int row, int column){
        switch(column){
            case 0:
                return lb.get(row).getNama();
            case 1:
                return lb.get(row).getNPM();
            case 2:
                return lb.get(row).getKelas();
            default:
                return null;
        }
    
    }
}
