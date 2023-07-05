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
public class Ucesce extends AbstractDomainObject {

    private Trening trening;
    private int rbUcesca;
    private String napomena;
    private Clan clan;

    public Ucesce(Trening trening, int rbUcesca, String napomena, Clan clan) {
        this.trening = trening;
        this.rbUcesca = rbUcesca;
        this.napomena = napomena;
        this.clan = clan;
    }

    public Ucesce() {
    }

    @Override
    public String nazivTabele() {
        return " Ucesce ";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return " JOIN TRENING T USING (TRENINGID) "
                + "JOIN CLAN C USING (CLANID) "
                + "JOIN KATEGORIJA K ON (K.KATEGORIJAID = T.KATEGORIJAID) "
                + "JOIN TRENER TR ON (TR.TRENERID = T.TRENERID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
                + "JOIN TEREN TE ON (TE.TERENID = T.TERENID) "
                + "JOIN POZICIJA P ON (P.POZICIJAID = C.POZICIJAID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Trener t = new Trener(rs.getLong("TrenerID"),
                    rs.getString("ImeTrenera"), rs.getString("PrezimeTrenera"),
                    rs.getInt("godineIskustva"), rs.getString("telefonTrenera"));

            Kategorija k = new Kategorija(rs.getLong("KategorijaID"),
                    rs.getString("NazivKategorije"));

            Teren te = new Teren(rs.getLong("TerenID"), rs.getString("NazivTerena"), rs.getDouble("Duzina"),
					rs.getDouble("Sirina"));
            
            Trening tr = new Trening(rs.getLong("treningID"),
                    rs.getTimestamp("datumVreme"),
                    rs.getInt("maxBrojClanova"), k, t, te, a, null);
            
            Pozicija p = new Pozicija(rs.getLong("PozicijaID"), rs.getString("NazivPozicije"));

            Clan c = new Clan(rs.getLong("clanID"), rs.getString("imeClana"),
                    rs.getString("prezimeClana"), rs.getString("email"),
                    rs.getDate("datumRodjenja"), rs.getString("telefonClana"), k, p);

            Ucesce u = new Ucesce(tr, rs.getInt("rbUcesca"), rs.getString("napomena"), c);

            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (treningID, rbUcesca, napomena, clanID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " treningID = " + trening.getTreningID();
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + trening.getTreningID() + "', '" + rbUcesca + "', "
                + "'" + napomena + "', '" + clan.getClanID() + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE T.TRENINGID = " + trening.getTreningID();
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public int getRbUcesca() {
        return rbUcesca;
    }

    public void setRbUcesca(int rbUcesca) {
        this.rbUcesca = rbUcesca;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

}
