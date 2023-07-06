package rs.np.milosevic_dejan_0098_2019.so.trening;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za dodavanje novog treninga u bazu podataka,
 * kao i svih ucesca na datom treningu. Implementira apstraktne metode iz
 * apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOAddTrening extends AbstractSO {

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Trening, ako je
	 *                   uneti maksimalan broj clanova manji od 1 ili veci od 10,
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

		if (trening.getMaxBrojClanova() < 1 || trening.getMaxBrojClanova() > 10) {
			throw new Exception("Maksimalan broj clanova mora biti izmedju 1 i 10!");
		}

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
			if (tr.getDatumVreme().getTime() == (trening.getDatumVreme().getTime())) {
				throw new Exception("U ovo vreme je vec zakazan trening!");
			}
		}
	}

	/**
	 * Poziva brokera baze podataka da izvrsi INSERT upit kojim se dodaje novi
	 * trening u bazu podataka.
	 * 
	 * Uz to, poziva se INSERT upit i za sva ucesca na datom treningu cime se ona
	 * takodje dodaju u bazu podataka.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		PreparedStatement ps = DBBroker.getInstance().insert(ado);

		ResultSet tableKeys = ps.getGeneratedKeys();
		tableKeys.next();
		Long treningID = tableKeys.getLong(1);

		Trening trening = (Trening) ado;
		trening.setTreningID(treningID);

		for (Ucesce ucesce : trening.getUcesca()) {
			ucesce.setTrening(trening);
			DBBroker.getInstance().insert(ucesce);
		}

	}

}
