package rs.np.milosevic_dejan_0098_2019.so.trening;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih treninga iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllTrening extends AbstractSO {

	/**
	 * Lista sa svim treninzima
	 */
    private ArrayList<Trening> lista;

    /**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Trening
	 */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
    }

    /**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim treninzima.
	 */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> treninzi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Trening>) (ArrayList<?>) treninzi;
    }

    /**
     * Vraca listu sa svim treninzima
     * 
     * @return lista sa svim treninzima
     */
    public ArrayList<Trening> getLista() {
        return lista;
    }

}
