package rs.np.milosevic_dejan_0098_2019.so.login;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 * Predstavlja sistemsku operaciju koja omogucava administratoru da se uloguje
 * na sistem. Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOLogin extends AbstractSO {

	/**
	 * Objekat koji predstavlja ulogovanog administratora
	 */
	private Administrator ulogovani;

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Administrator
	 */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Administrator)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
		}
	}

	/**
	 * Poziva brokera baze podataka da izvrsi SELECT upit i vrati sve administratore
	 * iz baze podataka, a zatim proveri da li postoji medju njima onaj sa unetim
	 * podacima.
	 * 
	 * @throws Exception ako ne postoji administrator sa unetim podacima u bazi
	 *                   podataka
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {

		Administrator a = (Administrator) ado;

		ArrayList<Administrator> administratori = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance()
				.select(ado);

		for (Administrator administrator : administratori) {
			if (administrator.getUsername().equals(a.getUsername())
					&& administrator.getPassword().equals(a.getPassword())) {
				ulogovani = administrator;
				return;
			}
		}

		throw new Exception("Sistem ne moze da pronadje administratora sa zadatim podacima!");

	}

	/**
	 * Vraca ulogovanog administratora.
	 * 
	 * @return ulogovani administrator
	 */
	public Administrator getUlogovani() {
		return ulogovani;
	}

}
