package rs.np.milosevic_dejan_0098_2019.so.trening;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import java.util.ArrayList;
import java.util.Date;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za izmenu postojeceg treninga iz baze
 * podataka, kao i svih ucesca na datom treningu. Implementira apstraktne metode
 * iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOUpdateTrening extends AbstractSO {

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Trening, ako je
	 *                   ako uneti datum i vreme treninga nisu u buducnosti, ako
	 *                   trening nema nijedno ucesce, ako je uneti broj ucesca veci
	 *                   od unetog maksimalnog broja clanova, ako vec postoji
	 *                   trening sa unetim datumom i vremenom
	 */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Trening)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
		}

		Trening trening = (Trening) ado;

		if (!trening.getDatumVreme().after(new Date())) {
			throw new Exception("Datum i vreme treninga moraju biti posle danasnjeg datuma!");
		}

		if (trening.getUcesca().size() < 1) {
			throw new Exception("Trening mora imati barem jedno ucesce!");
		}

		if (trening.getMaxBrojClanova() < trening.getUcesca().size()) {
			throw new Exception("Maksimalan broj clanova je " + trening.getMaxBrojClanova() + ". Vi ste uneli "
					+ trening.getUcesca().size() + "!");
		}

		ArrayList<Trening> treninzi = (ArrayList<Trening>) (ArrayList<?>) DBBroker.getInstance().select(trening);

		for (Trening tr : treninzi) {
			if (!tr.getTreningID().equals(trening.getTreningID())) {
				if (tr.getDatumVreme().getTime() == (trening.getDatumVreme().getTime())) {
					throw new Exception("U ovo vreme je vec zakazan trening!");
				}
			}
		}

	}

	/**
	 * Poziva brokera baze podataka da izvrsi UPDATE upit kojim se vrsi izmena
	 * postojeceg treninga iz baze podataka.
	 * 
	 * Takodje, poziva se i najpre DELETE upit kojim se brisu sva ucesca za
	 * izmenjeni trening, a zatim i INSERT upit da bi se dodala ucesca tako
	 * izmenjenog treninga.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		DBBroker.getInstance().update(ado);

		Trening trening = (Trening) ado;

		DBBroker.getInstance().delete(trening.getUcesca().get(0));

		for (Ucesce ucesce : trening.getUcesca()) {
			DBBroker.getInstance().insert(ucesce);
		}
	}

}
