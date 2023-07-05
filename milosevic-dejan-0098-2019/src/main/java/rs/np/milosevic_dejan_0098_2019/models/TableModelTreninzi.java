/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.models;

import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.so.trening.SOGetAllTrening;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dejan
 */
public class TableModelTreninzi extends AbstractTableModel implements Runnable {

    private ArrayList<Trening> lista;
    private String[] kolone = {"ID", "Teren", "Trener", "Kategorija", "Datum i vreme", "Maksimalan br. clanova"};
    private String parametar = "";

    public TableModelTreninzi() {
        try {
        	SOGetAllTrening so = new SOGetAllTrening();
            so.templateExecute(new Trening());
            lista = so.getLista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
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
        Trening t = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        switch (column) {
            case 0:
                return t.getTreningID();
            case 1:
                return t.getTeren();
            case 2:
                return t.getTrener();
            case 3:
                return t.getKategorija();
            case 4:
                return sdf.format(t.getDatumVreme());
            case 5:
                return t.getMaxBrojClanova();

            default:
                return null;
        }
    }

    public Trening getSelectedTrening(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
        	SOGetAllTrening so = new SOGetAllTrening();
            so.templateExecute(new Trening());
            lista = so.getLista();
            if (!parametar.equals("")) {
                ArrayList<Trening> novaLista = new ArrayList<>();
                for (Trening t : lista) {
                    if (t.getTeren().getNazivTerena().contains(parametar.toLowerCase())
                        || t.getTrener().getImeTrenera().toLowerCase().contains(parametar.toLowerCase())
                        || t.getTrener().getPrezimeTrenera().toLowerCase().contains(parametar.toLowerCase())
                        || (t.getTrener().getImeTrenera() + " " + t.getTrener().getPrezimeTrenera()).toLowerCase().
                            contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
