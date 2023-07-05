package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Teren extends AbstractDomainObject {
	private Long terenID;
	private String nazivTerena;
	private double duzina;
	private double sirina;

	public Teren(Long terenID, String nazivTerena, double duzina, double sirina) {
		super();
		this.terenID = terenID;
		this.nazivTerena = nazivTerena;
		this.duzina = duzina;
		this.sirina = sirina;
	}

	public Teren() {
	}
	
	@Override
	public String toString() {
		return nazivTerena;
	}

	@Override
	public String nazivTabele() {
		return " Teren ";
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
			Teren t = new Teren(rs.getLong("TerenID"), rs.getString("NazivTerena"), rs.getDouble("Duzina"),
					rs.getDouble("Sirina"));
			
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
		return " TerenID = " + terenID;
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
	
	public Long getTerenID() {
		return terenID;
	}

	public void setTerenID(Long terenID) {
		this.terenID = terenID;
	}

	public String getNazivTerena() {
		return nazivTerena;
	}

	public void setNazivTerena(String nazivTerena) {
		this.nazivTerena = nazivTerena;
	}

	public double getDuzina() {
		return duzina;
	}

	public void setDuzina(double duzina) {
		this.duzina = duzina;
	}

	public double getSirina() {
		return sirina;
	}

	public void setSirina(double sirina) {
		this.sirina = sirina;
	}

}
