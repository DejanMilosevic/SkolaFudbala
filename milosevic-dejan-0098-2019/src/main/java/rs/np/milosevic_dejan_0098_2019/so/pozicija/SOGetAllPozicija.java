package rs.np.milosevic_dejan_0098_2019.so.pozicija;

import java.util.ArrayList;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Pozicija;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

public class SOGetAllPozicija extends AbstractSO{

	private ArrayList<Pozicija> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> pozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pozicija>) (ArrayList<?>) pozicije;
    }

    public ArrayList<Pozicija> getLista() {
        return lista;
    }

}
