/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.so.trening;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import java.util.ArrayList;
import java.util.Date;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 *
 * @author Dejan
 */
public class SOUpdateTrening extends AbstractSO {

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
            throw new Exception("Maksimalan broj clanova je "
                    + trening.getMaxBrojClanova() + ". Vi ste uneli " + trening.getUcesca().size() + "!");
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
