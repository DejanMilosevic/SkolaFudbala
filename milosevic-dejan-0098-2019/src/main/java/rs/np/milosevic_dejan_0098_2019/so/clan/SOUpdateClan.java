package rs.np.milosevic_dejan_0098_2019.so.clan;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju za izmenu postojeceg clana iz baze podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOUpdateClan extends AbstractSO {

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Clan, ako vec
	 *                   postoji clan sa unetom e-mail adresom, ako vec postoji clan
	 *                   sa unetim brojem telefona
	 */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Clan)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
		}

		Clan c = (Clan) ado;

		ArrayList<Clan> clanovi = (ArrayList<Clan>) (ArrayList<?>) DBBroker.getInstance().select(ado);

		for (Clan clan : clanovi) {
			if (!clan.getClanID().equals(c.getClanID())) {
				if (clan.getEmail().equals(c.getEmail())) {
					throw new Exception("Vec postoji clan sa tom email adresom!");
				}
				if (clan.getTelefonClana().equals(c.getTelefonClana())) {
					throw new Exception("Vec postoji clan sa tim brojem telefona!");
				}
			}
		}

	}

	/**
	 * Poziva brokera baze podataka da izvrsi UPDATE upit kojim se vrsi izmena
	 * postojeceg clana iz baze podataka.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		DBBroker.getInstance().update(ado);
	}

}
