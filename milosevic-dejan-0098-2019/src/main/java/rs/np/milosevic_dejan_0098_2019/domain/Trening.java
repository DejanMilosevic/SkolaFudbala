/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dejan
 */
public class Trening extends AbstractDomainObject {

    private Long treningID;
    private Date datumVreme;
    private int maxBrojClanova;
    private Kategorija kategorija;
    private Trener trener;
    private Teren teren;
    private Administrator administrator;
    private ArrayList<Ucesce> ucesca;

    public Trening(Long treningID, Date datumVreme, int maxBrojClanova, Kategorija kategorija, Trener trener,
			Teren teren, Administrator administrator, ArrayList<Ucesce> ucesca) {
		this.treningID = treningID;
		this.datumVreme = datumVreme;
		this.maxBrojClanova = maxBrojClanova;
		this.kategorija = kategorija;
		this.trener = trener;
		this.teren = teren;
		this.administrator = administrator;
		this.ucesca = ucesca;
	}

	public Trening() {
    }

    @Override
    public String nazivTabele() {
        return " Trening ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " JOIN KATEGORIJA K ON (K.KATEGORIJAID = T.KATEGORIJAID) "
                + "JOIN TRENER TR ON (TR.TRENERID = T.TRENERID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
                + "JOIN TEREN TE ON (TE.TERENID = T.TERENID) ";
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

            lista.add(tr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVreme, maxBrojClanova, KategorijaID, trenerID, terenID, administratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " treningID = " + treningID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', "
                + " " + maxBrojClanova + ", " + kategorija.getKategorijaID() + ", "
                + trener.getTrenerID() + ", " + teren.getTerenID() + ", " + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "datumVreme = '" + new Timestamp(datumVreme.getTime()) 
                + "', terenID = " + teren.getTerenID();
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTreningID() {
        return treningID;
    }

    public void setTreningID(Long treningID) {
        this.treningID = treningID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public int getMaxBrojClanova() {
        return maxBrojClanova;
    }

    public void setMaxBrojClanova(int maxBrojClanova) {
        this.maxBrojClanova = maxBrojClanova;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }
    
    public Teren getTeren() {
        return teren;
    }

    public void setTeren(Teren teren) {
        this.teren = teren;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<Ucesce> getUcesca() {
        return ucesca;
    }

    public void setUcesca(ArrayList<Ucesce> ucesca) {
        this.ucesca = ucesca;
    }

}
