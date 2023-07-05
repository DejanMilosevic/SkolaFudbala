package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pozicija extends AbstractDomainObject{
	private Long pozicijaID;
	private String nazivPozicije;

	public Pozicija(Long pozicijaID, String nazivPozicije) {
		this.pozicijaID = pozicijaID;
		this.nazivPozicije = nazivPozicije;
	}
	
	public Pozicija() {
	}

	@Override
	public String toString() {
		return nazivPozicije;
	}

	@Override
	public String nazivTabele() {
		return " Pozicija ";
	}

	@Override
	public String alijas() {
		return " p ";
	}

	@Override
	public String join() {
		return "";
	}

	@Override
	public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();
		
		while(rs.next()) {
			Pozicija p = new Pozicija(rs.getLong("PozicijaID"), rs.getString("NazivPozicije"));
			
			lista.add(p);
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
		return " PozicijaID = " + pozicijaID;
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

	public Long getPozicijaID() {
		return pozicijaID;
	}

	public void setPozicijaID(Long pozicijaID) {
		this.pozicijaID = pozicijaID;
	}

	public String getNazivPozicije() {
		return nazivPozicije;
	}

	public void setNazivPozicije(String nazivPozicije) {
		this.nazivPozicije = nazivPozicije;
	}
	
	
	
	
	
}
