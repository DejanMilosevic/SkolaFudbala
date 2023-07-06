package rs.np.milosevic_dejan_0098_2019.so.administrator;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import java.util.ArrayList;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih administratora iz baze
 * podataka. Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllAdministrator extends AbstractSO {

	/**
	 * Lista sa svim administratorima
	 */
	private ArrayList<Administrator> lista;

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Administrator
	 */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Administrator)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
		}
	}

	/**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim administratorima.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		ArrayList<AbstractDomainObject> administratori = DBBroker.getInstance().select(ado);
		lista = (ArrayList<Administrator>) (ArrayList<?>) administratori;
	}

	/**
	 * Vraca listu sa svim administratorima.
	 * 
	 * @return lista sa svim administratorima
	 */
	public ArrayList<Administrator> getLista() {
		return lista;
	}

}
