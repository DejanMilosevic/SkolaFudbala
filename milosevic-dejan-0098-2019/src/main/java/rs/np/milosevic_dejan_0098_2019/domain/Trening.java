package rs.np.milosevic_dejan_0098_2019.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Predstavlja trening koji ce se odrzati. Ima identifikator, datum i vreme kada
 * ce se odrzati, maksimalan broj clanova, kategoriju, trenera, teren,
 * administratora koji zakazuje, menja ili otkazuje trening, kao i ucesca
 * clanova na treningu.
 * 
 * Nasledjuje apstraktnu domensku klasu AbstractDomainObject i implementira sve
 * njene apstraktne metode.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class Trening extends AbstractDomainObject {

	/**
	 * Identifikator treninga kao Long
	 */
	private Long treningID;

	/**
	 * Datum i vreme odrzavanja treninga kao Date
	 */
	private Date datumVreme;

	/**
	 * Maksimalan broj clanova na treningu kao ceo broj
	 */
	private int maxBrojClanova;

	/**
	 * Kategoriju treninga kao Kategorija
	 */
	private Kategorija kategorija;

	/**
	 * Trener koji ce voditi trening kao Trener
	 */
	private Trener trener;

	/**
	 * Teren na kojem ce se odrzati trening kao Teren
	 */
	private Teren teren;

	/**
	 * Administrator koji zakazuje, menja ili otkazuje trening kao Administrator
	 */
	private Administrator administrator;

	/**
	 * Ucesca clanova na treningu kao lista
	 */
	private ArrayList<Ucesce> ucesca;

	/**
	 * Prazan konstruktor koji postavlja vrednosti atributa treninga na
	 * podrazumevane.
	 */
	public Trening() {
	}

	/**
	 * Konstruktor koji postavlja vrednosti atributa treninga na osnovu unetih
	 * parametara.
	 * 
	 * @param treningID      vrednost za identifikator treninga
	 * @param datumVreme     vrednost za datum i vreme odrzavanja treninga
	 * @param maxBrojClanova vrednost za maksimalan broj clanova na treningu
	 * @param kategorija     vrednost za kategoriju treninga
	 * @param trener         vrednost za trenera koji ce voditi trening
	 * @param teren          vrednost za teren na kojem ce se odrzati trening
	 * @param administrator  vrednost za administratora koji zakazuje trening
	 * @param ucesca         vrednost za ucesca clanova na treningu
	 */
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

	/**
	 * Vraca identifikator treninga.
	 * 
	 * @return identifikator treninga kao Long
	 */
	public Long getTreningID() {
		return treningID;
	}

	/**
	 * Postavlja vrednost za identifikator treninga.
	 * 
	 * @param treningID nova vrednost za identifikator treninga
	 */
	public void setTreningID(Long treningID) {
		this.treningID = treningID;
	}

	/**
	 * Vraca datum i vreme odrzavanja treninga.
	 * 
	 * @return datum i vreme odrzavanja treninga kao Date
	 */
	public Date getDatumVreme() {
		return datumVreme;
	}

	/**
	 * Postavlja vrednost za datum i vreme odrzavanja treninga.
	 * 
	 * @param datumVreme nova vrednost za datum i vreme odrzavanja treninga
	 */
	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}

	/**
	 * Vraca maksimalan broj clanova na treningu.
	 * 
	 * @return maksimalan broj clanova na treningu kao ceo broj
	 */
	public int getMaxBrojClanova() {
		return maxBrojClanova;
	}

	/**
	 * Postavlja vrednost za maksimalan broj clanova na treningu.
	 * 
	 * @param maxBrojClanova nova vrednost za maksimalan broj clanova na treningu
	 */
	public void setMaxBrojClanova(int maxBrojClanova) {
		this.maxBrojClanova = maxBrojClanova;
	}

	/**
	 * Vraca kategoriju treninga.
	 * 
	 * @return kategoriju trening kao Kategorija
	 */
	public Kategorija getKategorija() {
		return kategorija;
	}

	/**
	 * Postavlja vrednost za kategoriju treninga.
	 * 
	 * @param kategorija nova vrednost za kategoriju treningu
	 */
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	/**
	 * Vraca trenera koji ce voditi trening.
	 * 
	 * @return trenera koji ce voditi trening kao Trener
	 */
	public Trener getTrener() {
		return trener;
	}

	/**
	 * Postavlja vrednost za trenera koji ce voditi trening.
	 * 
	 * @param trener nova vrednost za trenera koji ce voditi trening
	 */
	public void setTrener(Trener trener) {
		this.trener = trener;
	}

	/**
	 * Vraca teren na kojem ce se odrzati trening.
	 * 
	 * @return teren na kojem ce se odrzati trening kao Teren
	 */
	public Teren getTeren() {
		return teren;
	}

	/**
	 * Postavlja vrednost za teren na kojem ce se odrzati trening.
	 * 
	 * @param teren nova vrednost za teren na kojem ce se odrzati trening
	 */
	public void setTeren(Teren teren) {
		this.teren = teren;
	}

	/**
	 * Vraca administratora koji zakazuje, menja ili otkazuje trening.
	 * 
	 * @return administrator koji zakazuje, menja ili otkazuje trening kao
	 *         Administrator
	 */
	public Administrator getAdministrator() {
		return administrator;
	}

	/**
	 * Postavlja vrednost za administratora treninga.
	 * 
	 * @param administrator nova vrednost za administratora treninga
	 */
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	/**
	 * Vraca listu sa ucescima clanova na treningu.
	 * 
	 * @return lista sa ucescima clanova na treningu
	 */
	public ArrayList<Ucesce> getUcesca() {
		return ucesca;
	}

	/**
	 * Postavlja listu sa ucescima clanova na treningu.
	 * 
	 * @param ucesca nova vrednost za listu sa ucescima clanova na treningu
	 */
	public void setUcesca(ArrayList<Ucesce> ucesca) {
		this.ucesca = ucesca;
	}
	
	/**
	 * Vraca String sa svim podacima o treningu.
	 * 
	 * @return svi podaci o treningu kao String
	 */
	@Override
	public String toString() {
		return "Trening [treningID=" + treningID + ", datumVreme=" + datumVreme + ", maxBrojClanova=" + maxBrojClanova
				+ ", kategorija=" + kategorija + ", trener=" + trener + ", teren=" + teren + ", administrator="
				+ administrator + ", ucesca=" + ucesca + "]";
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
			Administrator a = new Administrator(rs.getLong("AdministratorID"), rs.getString("Ime"),
					rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));

			Trener t = new Trener(rs.getLong("TrenerID"), rs.getString("ImeTrenera"), rs.getString("PrezimeTrenera"),
					rs.getInt("godineIskustva"), rs.getString("telefonTrenera"));

			Kategorija k = new Kategorija(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));

			Teren te = new Teren(rs.getLong("TerenID"), rs.getString("NazivTerena"), rs.getDouble("Duzina"),
					rs.getDouble("Sirina"));

			Trening tr = new Trening(rs.getLong("treningID"), rs.getTimestamp("datumVreme"),
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
		return "'" + new Timestamp(datumVreme.getTime()) + "', " + " " + maxBrojClanova + ", "
				+ kategorija.getKategorijaID() + ", " + trener.getTrenerID() + ", " + teren.getTerenID() + ", "
				+ administrator.getAdministratorID();
	}

	@Override
	public String vrednostiZaUpdate() {
		return "datumVreme = '" + new Timestamp(datumVreme.getTime()) + "', terenID = " + teren.getTerenID();
	}

	@Override
	public String uslov() {
		return "";
	}
}
