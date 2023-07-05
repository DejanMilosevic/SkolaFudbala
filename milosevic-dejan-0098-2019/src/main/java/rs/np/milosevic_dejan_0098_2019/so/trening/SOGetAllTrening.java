/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.so.trening;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 *
 * @author Dejan
 */
public class SOGetAllTrening extends AbstractSO {

    private ArrayList<Trening> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> treninzi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Trening>) (ArrayList<?>) treninzi;
    }

    public ArrayList<Trening> getLista() {
        return lista;
    }

}
