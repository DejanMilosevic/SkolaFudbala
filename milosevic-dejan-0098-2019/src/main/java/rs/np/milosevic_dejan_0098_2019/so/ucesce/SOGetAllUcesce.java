/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.so.ucesce;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import java.util.ArrayList;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;

/**
 *
 * @author Dejan
 */
public class SOGetAllUcesce extends AbstractSO {

    private ArrayList<Ucesce> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Ucesce)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ucesce!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ucesca = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Ucesce>) (ArrayList<?>) ucesca;
    }

    public ArrayList<Ucesce> getLista() {
        return lista;
    }

}
