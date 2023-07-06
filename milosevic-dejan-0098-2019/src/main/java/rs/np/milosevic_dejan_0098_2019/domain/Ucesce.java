package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja ucesce clana na treningu. Ima informaciju o treningu na kojem je
 * ostvareno ucesce, redni broj, napomenu u vezi clana, kao i informaciju o
 * clanu koji ostvaruje ucesce na treningu.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Ucesce extends AbstractDomainObject {

	/**
	 * Trening na kojem je ostvareno ucesce kao Trening
	 */
	private Trening trening;

	/**
	 * Redni broj ucesca kao ceo broj
	 */
	private int rbUcesca;

	/**
	 * Napomena vezana za eventualnu povredu clana koji ostvaruje ucesce kao String
	 */
	private String napomena;

	/**
	 * Clan koji ostvaruje ucesce na treningu kao Clan
	 */
	private Clan clan;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa ucesca na podrazumevane.
	 */
	public Ucesce() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa ucesca na osnovu unetih
	 * parametara.
	 * 
	 * @param trening  vrednost za trening na kojem je ostvareno ucesce
	 * @param rbUcesca vrednost za redni broj ucesca
	 * @param napomena vrednost za napomenu ucesca
	 * @param clan     vrednost za clana koji ostvaruje ucesce
	 */
	public Ucesce(Trening trening, int rbUcesca, String napomena, Clan clan) {
		this.trening = trening;
		this.rbUcesca = rbUcesca;
		this.napomena = napomena;
		this.clan = clan;
	}

	/**
	 * Vraca trening na kojem je ostvareno ucesce.
	 * 
	 * @return trening na kojem je ostvareno ucesce kao Trening
	 */
	public Trening getTrening() {
		return trening;
	}

	/**
	 * Postavlja vrednost za trening na kojem je ostvareno ucesce.
	 * 
	 * @param trening nova vrednost za trening na kojem je ostvareno ucesce
	 */
	public void setTrening(Trening trening) {
		this.trening = trening;
	}

	/**
	 * Vraca redni broj ucesca.
	 * 
	 * @return redni broj ucesca kao ceo broj
	 */
	public int getRbUcesca() {
		return rbUcesca;
	}

	/**
	 * Postavlja vrednost za redni broj ucesca.
	 * 
	 * @param rbUcesca nova vrednost za redni broj ucesca
	 */
	public void setRbUcesca(int rbUcesca) {
		this.rbUcesca = rbUcesca;
	}

	/**
	 * Vraca napomenu vezanu za eventualnu povredu clana koji ostvaruje ucesce.
	 * 
	 * @return napomena ucesca kao String
	 */
	public String getNapomena() {
		return napomena;
	}

	/**
	 * Postavlja vrednost napomene vezane za eventualnu povredu clana koji ostvaruje
	 * ucesce.
	 * 
	 * Napomena moze kao vrednost imati i prazan String ukoliko clan nema nikakvu
	 * povredu.
	 * 
	 * @param napomena nova vrednost za napomenu ucesca
	 */
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	/**
	 * Vraca clana koji ostvaruje ucesce na treningu.
	 * 
	 * @return clan koji ostvaruje ucesce na treningu kao Clan
	 */
	public Clan getClan() {
		return clan;
	}

	/**
	 * Postavlja vrednost za clana koji ostvaruje ucesce na treningu.
	 * 
	 * @param clan nova vrednost za clana koji ostvaruje ucesce na treningu
	 */
	public void setClan(Clan clan) {
		this.clan = clan;
	}

	/**
	 * Vraca String sa svim podacima o ucescu clana na treningu.
	 * 
	 * @return svi podaci o ucescu clana na treningu kao String
	 */
	@Override
	public String toString() {
		return "Ucesce [trening=" + trening + ", rbUcesca=" + rbUcesca + ", napomena=" + napomena + ", clan=" + clan
				+ "]";
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
		return " JOIN TRENING T USING (TRENINGID) " + "JOIN CLAN C USING (CLANID) "
				+ "JOIN KATEGORIJA K ON (K.KATEGORIJAID = T.KATEGORIJAID) "
				+ "JOIN TRENER TR ON (TR.TRENERID = T.TRENERID) "
				+ "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
				+ "JOIN TEREN TE ON (TE.TERENID = T.TERENID) " + "JOIN POZICIJA P ON (P.POZICIJAID = C.POZICIJAID)";
	}

	@Override
	public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();

		while (rs.next()) {
			Administrator a = new Administrator(rs.getLong("AdministratorID"), rs.getString("Ime"),
					rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));

			Trener t = new Trener(rs.getLong("TrenerID"), rs.getString("ImeTrenera"), rs.getString("PrezimeTrenera"),
					rs.getInt("godineIskustva"), rs.getString("telefonTrenera"));

			Kategorija k = new Kategorija(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));

			Teren te = new Teren(rs.getLong("TerenID"), rs.getString("NazivTerena"), rs.getDouble("Duzina"),
					rs.getDouble("Sirina"));

			Trening tr = new Trening(rs.getLong("treningID"), rs.getTimestamp("datumVreme"),
					rs.getInt("maxBrojClanova"), k, t, te, a, null);

			Pozicija p = new Pozicija(rs.getLong("PozicijaID"), rs.getString("NazivPozicije"));

			Clan c = new Clan(rs.getLong("clanID"), rs.getString("imeClana"), rs.getString("prezimeClana"),
					rs.getString("email"), rs.getDate("datumRodjenja"), rs.getString("telefonClana"), k, p);

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
		return "'" + trening.getTreningID() + "', '" + rbUcesca + "', " + "'" + napomena + "', '" + clan.getClanID()
				+ "'";
	}

	@Override
	public String vrednostiZaUpdate() {
		return "";
	}

	@Override
	public String uslov() {
		return " WHERE T.TRENINGID = " + trening.getTreningID();
	}
}
