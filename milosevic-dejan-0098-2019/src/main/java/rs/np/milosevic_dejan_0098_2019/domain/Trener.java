/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dejan
 */
public class Trener extends AbstractDomainObject {
    
    private Long trenerID;
    private String imeTrenera;
    private String prezimeTrenera;
    private int godineIskustva;
    private String telefonTrenera;

    @Override
    public String toString() {
        return imeTrenera + " " + prezimeTrenera;
    }

    public Trener(Long trenerID, String imeTrenera, String prezimeTrenera, int godineIskustva, String telefonTrenera) {
        this.trenerID = trenerID;
        this.imeTrenera = imeTrenera;
        this.prezimeTrenera = prezimeTrenera;
        this.godineIskustva = godineIskustva;
        this.telefonTrenera = telefonTrenera;
    }

    public Trener() {
    }
    
    @Override
    public String nazivTabele() {
        return " Trener ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Trener t = new Trener(rs.getLong("TrenerID"),
                    rs.getString("ImeTrenera"), rs.getString("PrezimeTrenera"),
                    rs.getInt("godineIskustva"), rs.getString("telefonTrenera"));

            lista.add(t);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TrenerID = " + trenerID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(Long trenerID) {
        this.trenerID = trenerID;
    }

    public String getImeTrenera() {
        return imeTrenera;
    }

    public void setImeTrenera(String imeTrenera) {
        this.imeTrenera = imeTrenera;
    }

    public String getPrezimeTrenera() {
        return prezimeTrenera;
    }

    public void setPrezimeTrenera(String prezimeTrenera) {
        this.prezimeTrenera = prezimeTrenera;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }

    public String getTelefonTrenera() {
        return telefonTrenera;
    }

    public void setTelefonTrenera(String telefonTrenera) {
        this.telefonTrenera = telefonTrenera;
    }
    
}
