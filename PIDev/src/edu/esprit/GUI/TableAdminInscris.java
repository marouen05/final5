/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.GUI;

import edu.esprit.DAO.ServiceDAO;
import edu.esprit.entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Majdi Chaabene
 */
public class TableAdminInscris extends AbstractTableModel {
    List<Service> maliste = new ArrayList<Service>();
    String[] header = {"Type","Lieux"};

    public TableAdminInscris() {
    maliste = new ServiceDAO().DisplayAllServicesinscris();
    }


    public int getRowCount() {
        return maliste.size();
    }

    public int getColumnCount() {
        return header.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return maliste.get(rowIndex).getType();
            case 1: return maliste.get(rowIndex).getLieux();
            default:
                return null;
        }
    }

        public String getColumnName(int column) {
        return header[column];
    }
    
    
}
