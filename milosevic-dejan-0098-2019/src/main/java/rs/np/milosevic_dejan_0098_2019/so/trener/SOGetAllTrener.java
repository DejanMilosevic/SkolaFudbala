package rs.np.milosevic_dejan_0098_2019.so.trener;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trener;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih trenera iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllTrener extends AbstractSO {

	/**
	 * Lista sa svim trenerima
	 */
    private ArrayList<Trener> lista;

    /**
     * @throws Exception ako prosledjeni objekat nije instanca klase Teren
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trener)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trener!");
        }
    }

    /**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim trenerima.
	 */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> treneri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Trener>) (ArrayList<?>) treneri;
    }

    /**
     * Vraca listu sa svim trenerima
     * 
     * @return lista sa svim trenerima
     */
    public ArrayList<Trener> getLista() {
        return lista;
    }

}
