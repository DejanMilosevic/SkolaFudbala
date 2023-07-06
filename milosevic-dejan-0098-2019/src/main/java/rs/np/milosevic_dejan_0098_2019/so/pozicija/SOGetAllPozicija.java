package rs.np.milosevic_dejan_0098_2019.so.pozicija;

import java.util.ArrayList;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Pozicija;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih pozicija iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllPozicija extends AbstractSO{

	/**
	 * Lista sa svim pozicijama
	 */
	private ArrayList<Pozicija> lista;

	/**
     * @throws Exception ako prosledjeni objekat nije instanca klase Pozicija
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    /**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim pozicijama.
	 */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> pozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pozicija>) (ArrayList<?>) pozicije;
    }

    /**
     * Vraca listu sa svim pozicijama
     * 
     * @return lista sa svim pozicijama
     */
    public ArrayList<Pozicija> getLista() {
        return lista;
    }

}
