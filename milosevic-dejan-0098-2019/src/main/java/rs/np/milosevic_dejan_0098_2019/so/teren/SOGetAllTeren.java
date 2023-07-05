package rs.np.milosevic_dejan_0098_2019.so.teren;

import java.util.ArrayList;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Teren;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

public class SOGetAllTeren extends AbstractSO {

	private ArrayList<Teren> lista;
	
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Teren)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Teren!");
		}
	}

	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		ArrayList<AbstractDomainObject> tereni = DBBroker.getInstance().select(ado);
		lista = (ArrayList<Teren>) (ArrayList<?>) tereni;
	}

	public ArrayList<Teren> getLista() {
		return lista;
	}

}
