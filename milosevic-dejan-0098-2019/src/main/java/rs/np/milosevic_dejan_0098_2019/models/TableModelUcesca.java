/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.models;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import rs.np.milosevic_dejan_0098_2019.so.ucesce.SOGetAllUcesce;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dejan
 */
public class TableModelUcesca extends AbstractTableModel {

    private ArrayList<Ucesce> lista;
    private String[] kolone = {"Rb", "Clan", "Napomena"};
    private int rb = 0;

    public TableModelUcesca() {
        lista = new ArrayList<>();
    }

    public TableModelUcesca(Trening t) {
        try {
        	SOGetAllUcesce so = new SOGetAllUcesce();

            Ucesce u = new Ucesce();
            u.setTrening(t);

            so.templateExecute(u);
            
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelUcesca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Ucesce u = lista.get(row);

        switch (column) {
            case 0:
                return u.getRbUcesca();
            case 1:
                return u.getClan();
            case 2:
                return u.getNapomena();

            default:
                return null;
        }
    }

    public void dodajUcesce(Ucesce u) {
        rb = lista.size();
        u.setRbUcesca(++rb);
        lista.add(u);
        fireTableDataChanged();
    }

    public void obrisiUcesce(int row) {
        lista.remove(row);

        rb = 0;
        for (Ucesce ucesce : lista) {
            ucesce.setRbUcesca(++rb);
        }

        fireTableDataChanged();
    }

    public boolean postojiClan(Clan clan) {
        for (Ucesce ucesce : lista) {
            if (ucesce.getClan().getClanID().equals(clan.getClanID())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Ucesce> getLista() {
        return lista;
    }

}
