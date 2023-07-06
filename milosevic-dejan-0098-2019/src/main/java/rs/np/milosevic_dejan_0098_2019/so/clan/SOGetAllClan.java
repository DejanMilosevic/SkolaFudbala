package rs.np.milosevic_dejan_0098_2019.so.clan;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih ili odredjenih clanova iz
 * baze podataka. Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllClan extends AbstractSO {

	/**
	 * Lista sa clanovima
	 */
	private ArrayList<Clan> lista;

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Clan
	 */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Clan)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
		}
	}

	/**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja
	 * u listu sa svim clanovima.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		ArrayList<AbstractDomainObject> clanovi = DBBroker.getInstance().select(ado);
		lista = (ArrayList<Clan>) (ArrayList<?>) clanovi;
	}

	/**
	 * Vraca listu sa clanovima
	 * 
	 * @return lista sa clanovima
	 */
	public ArrayList<Clan> getLista() {
		return lista;
	}

}
