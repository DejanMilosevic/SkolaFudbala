package rs.np.milosevic_dejan_0098_2019.so.clan;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 * Predstavlja sistemsku operaciju za dodavanje novog clana u bazu podataka.
 * Implementira apstraktne metode iz apstraktne klase AbstractSO.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class SOAddClan extends AbstractSO {

	/**
	 * @throws Exception ako prosledjeni objekat nije instanca klase Clan, ako uneti
	 *                   datum rodjenja clana nije u proslosti, ako vec postoji clan
	 *                   sa unetom e-mail adresom, ako vec postoji clan sa unetim
	 *                   brojem telefona
	 */
	@Override
	protected void validate(AbstractDomainObject ado) throws Exception {
		if (!(ado instanceof Clan)) {
			throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
		}

		Clan c = (Clan) ado;

		if (!c.getDatumRodjenja().before(new Date())) {
			throw new Exception("Datum rodjenja mora biti u proslosti!");
		}

		ArrayList<Clan> clanovi = (ArrayList<Clan>) (ArrayList<?>) DBBroker.getInstance().select(new Clan());

		for (Clan clan : clanovi) {
			if (clan.getEmail().equals(c.getEmail())) {
				throw new Exception("Vec postoji clan sa tom email adresom!");
			}
			if (clan.getTelefonClana().equals(c.getTelefonClana())) {
				throw new Exception("Vec postoji clan sa tim brojem telefona!");
			}
		}
	}

	/**
	 * Poziva brokera baze podataka da izvrsi INSERT upit kojim se dodaje novi clan
	 * u bazu podataka.
	 */
	@Override
	protected void execute(AbstractDomainObject ado) throws Exception {
		DBBroker.getInstance().insert(ado);
	}

	/**
	 * Serijalizuje unetog clana u JSON format.
	 * 
	 * @param clan koji se serijalizuje
	 * 
	 * @return String sa unetim clanom u JSON formatu.
	 */
	public String serijalizujJSON(Clan clan){
		String json = "";
		
		try(FileWriter out = new FileWriter("src/test/resources/clan.json")){
			Gson gson = new Gson();
			
			json = gson.toJson(clan);
			
			out.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}

}
