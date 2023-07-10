package rs.np.milosevic_dejan_0098_2019.so.trening;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za brisanje postojeceg treninga iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SODeleteTrening extends AbstractSO {

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
	 * Poziva brokera baze podataka da izvrsi DELETE upit kojim se brise postojeci trening
	 * iz baze podataka.
	 */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
