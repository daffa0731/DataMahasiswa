/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pert3;
import pert3.daoData_absen;
import pert3.implementData_absen;
import pert3.data_absen;
import pert3.table_absen;
import pert3.view;

import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Daffa
 */
public class controllerData_absen {
      view ve;
    implementData_absen iD;
    List<data_absen> lb;

    public controllerData_absen(view ve) {
        this.ve = ve;
        iD = new daoData_absen();
        lb = iD.getAll();
    }

    public void reset(){
        ve.getText_nama().setText("");
        ve.getText_npm().setText("");
        ve.getText_kelas().setText("");
    }

    public void table(){
        lb = iD.getAll();
        table_absen ta = new table_absen(lb);
        ve.getTable_data().setModel(ta);
    }

    public void isiField(int row){
        ve.getText_nama().setText(lb.get(row).getNama());
        ve.getText_npm().setText(lb.get(row).getNPM());
        ve.getText_kelas().setText(lb.get(row).getKelas());
    }

    public void insert(){
        data_absen b = new data_absen();
        b.setNama(ve.getText_nama().getText());
        b.setNPM(ve.getText_npm().getText());
        b.setKelas(ve.getText_kelas().getText());

        iD.insert(b);
    }
}
