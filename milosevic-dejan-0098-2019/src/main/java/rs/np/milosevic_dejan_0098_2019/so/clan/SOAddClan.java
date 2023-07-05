/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.so.clan;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import java.util.ArrayList;
import java.util.Date;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 *
 * @author Dejan
 */
public class SOAddClan extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }

        Clan c = (Clan) ado;
      
        System.out.println(c.getKategorija().getNazivKategorije());
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

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
