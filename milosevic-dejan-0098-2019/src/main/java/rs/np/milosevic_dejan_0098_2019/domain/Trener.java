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
 * Predstavlja trenera koji ce voditi trening. Ima identifikator, ime, prezime,
 * broj godina iskustva i broj telefona.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Trener extends AbstractDomainObject {

	/**
	 * Identifikator trenera kao Long
	 */
	private Long trenerID;

	/**
	 * Ime trenera kao String
	 */
	private String imeTrenera;

	/**
	 * Prezime trenera kao String
	 */
	private String prezimeTrenera;

	/**
	 * Broj godina iskustva kao ceo broj
	 */
	private int godineIskustva;

	/**
	 * Broj telefona trenera kao String
	 */
	private String telefonTrenera;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa trenera na
	 * podrazumevane.
	 */
	public Trener() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa trenera na osnovu unetih
	 * parametara.
	 * 
	 * @param trenerID       vrednost za identifikator trenera
	 * @param imeTrenera     vrednost za ime trenera
	 * @param prezimeTrenera vrednost za prezime trenera
	 * @param godineIskustva vrednost za broj godina iskustva trenera
	 * @param telefonTrenera vrednost za broj telefona trenera
	 */
	public Trener(Long trenerID, String imeTrenera, String prezimeTrenera, int godineIskustva, String telefonTrenera) {
		this.trenerID = trenerID;
		this.imeTrenera = imeTrenera;
		this.prezimeTrenera = prezimeTrenera;
		this.godineIskustva = godineIskustva;
		this.telefonTrenera = telefonTrenera;
	}

	/**
	 * Vraca identifikator trenera.
	 * 
	 * @return identifikator trenera kao Long
	 */
	public Long getTrenerID() {
		return trenerID;
	}

	/**
	 * Postavlja vrednost za identifikator terena.
	 * 
	 * @param trenerID nova vrednost za identifikator terena
	 */
	public void setTrenerID(Long trenerID) {
		this.trenerID = trenerID;
	}

	/**
	 * Vraca ime trenera.
	 * 
	 * @return ime trenera kao String
	 */
	public String getImeTrenera() {
		return imeTrenera;
	}

	/**
	 * Postavlja vrednost za ime trenera.
	 * 
	 * @param imeTrenera nova vrednost za ime trenera
	 */
	public void setImeTrenera(String imeTrenera) {
		this.imeTrenera = imeTrenera;
	}

	/**
	 * Vraca prezime trenera.
	 * 
	 * @return prezime trenera kao String
	 */
	public String getPrezimeTrenera() {
		return prezimeTrenera;
	}

	/**
	 * Postavlja vrednost za prezime trenera.
	 * 
	 * @param prezimeTrenera nova vrednost za prezime trenera
	 */
	public void setPrezimeTrenera(String prezimeTrenera) {
		this.prezimeTrenera = prezimeTrenera;
	}

	/**
	 * Vraca broj godina iskustva.
	 * 
	 * @return broj godina iskustva kao ceo broj
	 */
	public int getGodineIskustva() {
		return godineIskustva;
	}

	/**
	 * Postavlja vrednost za broj godina iskustva.
	 * 
	 * @param godineIskustva nova vrednost za broj godina iskustva
	 */
	public void setGodineIskustva(int godineIskustva) {
		this.godineIskustva = godineIskustva;
	}

	/**
	 * Vraca broj telefona trenera.
	 * 
	 * @return broj telefona trenera kao String
	 */
	public String getTelefonTrenera() {
		return telefonTrenera;
	}

	/**
	 * Postavlja vrednost za broj telefona trenera.
	 * 
	 * @param telefonTrenera nova vrednost za broj telefona trenera
	 */
	public void setTelefonTrenera(String telefonTrenera) {
		this.telefonTrenera = telefonTrenera;
	}

	/**
	 * Vraca String sa imenom i prezimenom trenera.
	 * 
	 * @return ime i prezime trenera kao String
	 */
	@Override
	public String toString() {
		return imeTrenera + " " + prezimeTrenera;
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
			Trener t = new Trener(rs.getLong("TrenerID"), rs.getString("ImeTrenera"), rs.getString("PrezimeTrenera"),
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
}
