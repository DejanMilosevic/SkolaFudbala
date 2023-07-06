package rs.np.milosevic_dejan_0098_2019.so.teren;

import java.util.ArrayList;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Teren;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih terena iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllTeren extends AbstractSO {

	/**
	 * Lista sa svim terenima
	 */
	private ArrayList<Teren> lista;
	
	/**
     * @throws Exception ako prosledjeni objekat nije instanca klase Teren
     */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Teren)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Teren!");
		}
	}

	/**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim terenima.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		ArrayList<AbstractDomainObject> tereni = DBBroker.getInstance().select(ado);
		lista = (ArrayList<Teren>) (ArrayList<?>) tereni;
	}
	
	/**
     * Vraca listu sa svim terenima
     * 
     * @return lista sa svim terenima
     */
	public ArrayList<Teren> getLista() {
		return lista;
	}

}
