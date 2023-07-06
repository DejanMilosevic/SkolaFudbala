package rs.np.milosevic_dejan_0098_2019.so.kategorija;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Kategorija;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih kategorija iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllKategorija extends AbstractSO {
	
	/**
	 * Lista sa svim kategorijama
	 */
    private ArrayList<Kategorija> lista;

    /**
     * @throws Exception ako prosledjeni objekat nije instanca klase Kategorija
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Kategorija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kategorija!");
        }
    }

    /**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim kategorijama.
	 */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> kategorije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Kategorija>) (ArrayList<?>) kategorije;
    }

    /**
     * Vraca listu sa svim kategorijama
     * 
     * @return lista sa svim kategorijama
     */
    public ArrayList<Kategorija> getLista() {
        return lista;
    }

}
