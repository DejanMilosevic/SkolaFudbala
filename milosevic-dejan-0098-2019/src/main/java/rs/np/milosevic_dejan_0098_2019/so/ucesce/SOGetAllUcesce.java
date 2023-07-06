package rs.np.milosevic_dejan_0098_2019.so.ucesce;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import java.util.ArrayList;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za ucitavanje svih ucesca na izabranom treningu iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOGetAllUcesce extends AbstractSO {

	/**
	 * Lista sa svim ucescima na izabranom treningu
	 */
    private ArrayList<Ucesce> lista;

    /**
     * @throws Exception ako prosledjeni objekat nije instanca klase Ucesce
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Ucesce)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ucesce!");
        }
    }

    /**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i rezultat upita postavlja u
	 * listu sa svim ucescima.
	 */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ucesca = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Ucesce>) (ArrayList<?>) ucesca;
    }

    /**
     * Vraca listu sa svim ucescima na izabranom treningu
     * 
     * @return lista sa svim ucescima na izabranom treningu
     */
    public ArrayList<Ucesce> getLista() {
        return lista;
    }

}
