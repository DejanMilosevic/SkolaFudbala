/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dejan
 */
public class Clan extends AbstractDomainObject {

    private Long clanID;
    private String imeClana;
    private String prezimeClana;
    private String email;
    private Date datumRodjenja;
    private String telefonClana;
    private Kategorija kategorija;
    private Pozicija pozicija;

    @Override
    public String toString() {
        return imeClana + " " + prezimeClana + " (Kategorija: " + kategorija.getNazivKategorije() + ")"; 
    }
    
    public Clan(Long clanID, String imeClana, String prezimeClana, String email, Date datumRodjenja,
			String telefonClana, Kategorija kategorija, Pozicija pozicija) {
		this.clanID = clanID;
		this.imeClana = imeClana;
		this.prezimeClana = prezimeClana;
		this.email = email;
		this.datumRodjenja = datumRodjenja;
		this.telefonClana = telefonClana;
		this.kategorija = kategorija;
		this.pozicija = pozicija;
	}

	public Clan() {
    }

    @Override
    public String nazivTabele() {
        return " Clan ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return " JOIN KATEGORIJA K ON (K.KATEGORIJAID = C.KATEGORIJAID) "
        		+ "JOIN POZICIJA P ON (P.POZICIJAID = C.POZICIJAID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Kategorija k = new Kategorija(rs.getLong("KategorijaID"),
                    rs.getString("NazivKategorije"));
            
            Pozicija p = new Pozicija(rs.getLong("PozicijaID"), rs.getString("NazivPozicije"));

            Clan c = new Clan(rs.getLong("clanID"), rs.getString("imeClana"),
                    rs.getString("prezimeClana"), rs.getString("email"),
                    rs.getDate("datumRodjenja"), rs.getString("telefonClana"), k, p);

            lista.add(c);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (imeClana, prezimeClana, email, datumRodjenja, telefonClana, kategorijaID, pozicijaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " clanID = " + clanID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeClana + "', '" + prezimeClana + "', "
                + "'" + email + "', '" + new java.sql.Date(datumRodjenja.getTime()) + "', "
                + "'" + telefonClana + "', " + kategorija.getKategorijaID() + ", " + pozicija.getPozicijaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " email = '" + email + "', telefonClana = '" + telefonClana + "', "
                + "kategorijaID = " + kategorija.getKategorijaID() + ", "
                + "pozicijaID = " + pozicija.getPozicijaID();
    }

    @Override
    public String uslov() {
        if (kategorija == null) {
            return "";
        }
        return " WHERE K.KATEGORIJAID = " + kategorija.getKategorijaID();
    }

    public Long getClanID() {
        return clanID;
    }

    public void setClanID(Long clanID) {
        this.clanID = clanID;
    }

    public String getImeClana() {
        return imeClana;
    }

    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    public String getPrezimeClana() {
        return prezimeClana;
    }

    public void setPrezimeClana(String prezimeClana) {
        this.prezimeClana = prezimeClana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTelefonClana() {
        return telefonClana;
    }

    public void setTelefonClana(String telefonClana) {
        this.telefonClana = telefonClana;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

	public Pozicija getPozicija() {
		return pozicija;
	}

	public void setPozicija(Pozicija pozicija) {
		this.pozicija = pozicija;
	}
    

}
