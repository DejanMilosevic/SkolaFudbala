package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Predstavlja clana skole fudbala. 
 * Ima identifikator, ime, prezime, e-mail, datum rodjenja, broj telefona, kategoriju i poziciju na terenu.
 *
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 *
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Clan extends AbstractDomainObject {

	/**
	 * Identifikator clana kao Long
	 */
    private Long clanID;
    
    /**
     * Ime clana kao String
     */
    private String imeClana;
    
    /**
     * Prezime clana kao String
     */
    private String prezimeClana;
    
    /**
     * E-mail clana kao String
     */
    private String email;
    
    /**
     * Datum rodjenja clana kao Date
     */
    private Date datumRodjenja;
    
    /**
     * Broj telefona clana kao String
     */
    private String telefonClana;
    
    /**
     * Kategorija clana kao Kategorija
     */
    private Kategorija kategorija;
    
    /**
     * Pozicija na terenu clana kao Pozicija
     */
    private Pozicija pozicija;
    
    /**
     * Prazan konstruktor koji postavlja vrednosti atributa clana na podrazumevane.
     */
    public Clan() {
    }
    
    /**
     * Konstruktor koji postavlja vrednosti atributa clana na osnovu unetih parametara.
     * 
     * @param clanID vrednost za identifikator clana
     * @param imeClana vrednost za ime clana
     * @param prezimeClana vrednost za prezime clana
     * @param email vrednost za e-mail clana
     * @param datumRodjenja vrednost za datum rodjenja clana
     * @param telefonClana vrednost za broj telefona clana
     * @param kategorija vrednost za kategoriju clana
     * @param pozicija vrednost za poziciju clana
     */
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
    
    /**
     * Vraca identifikator clana.
     * 
     * @return identifikator clana kao Long
     */
    public Long getClanID() {
        return clanID;
    }

	/**
	 * Postavlja vrednost za identifikator clana.
	 * 
	 * @param clanID nova vrednost za identifikator clana
	 */
    public void setClanID(Long clanID) {
        this.clanID = clanID;
    }

    /**
     * Vraca ime clana.
     * 
     * @return ime clana kao String
     */
    public String getImeClana() {
        return imeClana;
    }

    /** 
     * Postavlja vrednost za ime clana.
     * 
     * @param imeClana nova vrednost za ime clana
     */
    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    /**
     * Vraca prezime clana.
     * 
     * @return prezime clana kao String
     */
    public String getPrezimeClana() {
        return prezimeClana;
    }

    /** 
     * Postavlja vrednost za prezime clana.
     * 
     * @param prezimeClana nova vrednost za prezime clana
     */
    public void setPrezimeClana(String prezimeClana) {
        this.prezimeClana = prezimeClana;
    }

    /**
     * Vraca e-mail clana.
     * 
     * @return e-mail clana kao String
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Postavlja vrednost za e-mail clana.
     * 
     * @param email nova vrednost za e-mail clana
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vraca datum rodjenja clana.
     * 
     * @return datum rodjenja clana kao Date
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    /** 
     * Postavlja vrednost za datum rodjenja clana.
     * 
     * @param datumRodjenja nova vrednost za datum rodjenja clana
     */
    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    /**
     * Vraca broj telefona clana.
     * 
     * @return broj telefona clana kao String
     */
    public String getTelefonClana() {
        return telefonClana;
    }

    /** 
     * Postavlja vrednost za datum rodjenja clana.
     * 
     * @param telefonClana nova vrednost za datum rodjenja clana
     */
    public void setTelefonClana(String telefonClana) {
        this.telefonClana = telefonClana;
    }

    /**
     * Vraca kategoriju clana.
     * 
     * @return kategorija clana kao Kategorija
     */
    public Kategorija getKategorija() {
        return kategorija;
    }

    /** 
     * Postavlja vrednost za kategorija clana.
     * 
     * @param kategorija nova vrednost za kategoriju clana
     */
    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    /**
     * Vraca poziciju clana na terenu.
     * 
     * @return poziciju clana na terenu kao Pozicija
     */
	public Pozicija getPozicija() {
		return pozicija;
	}

	/** 
	 * Postavlja vrednost za poziciju clana na terenu.
     * 
     * @param pozicija nova vrednost za poziciju clana na terenu
     */
	public void setPozicija(Pozicija pozicija) {
		this.pozicija = pozicija;
	}
	
	/**
	 * Vraca String sa imenom, prezimenom i kategorijom clana.
	 * 
	 * @return ime, prezime i kategoriju clana kao String
	 */
	@Override
    public String toString() {
        return imeClana + " " + prezimeClana + " (Kategorija: " + kategorija.getNazivKategorije() + ")"; 
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

}
