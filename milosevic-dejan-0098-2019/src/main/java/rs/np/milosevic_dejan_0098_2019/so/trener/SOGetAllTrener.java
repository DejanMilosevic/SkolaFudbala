/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.so.trener;

import rs.np.milosevic_dejan_0098_2019.db.DBBroker;
import rs.np.milosevic_dejan_0098_2019.domain.AbstractDomainObject;
import rs.np.milosevic_dejan_0098_2019.domain.Trener;
import rs.np.milosevic_dejan_0098_2019.so.AbstractSO;
import java.util.ArrayList;

/**
 *
 * @author Dejan
 */
public class SOGetAllTrener extends AbstractSO {

    private ArrayList<Trener> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trener)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trener!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> treneri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Trener>) (ArrayList<?>) treneri;
    }

    public ArrayList<Trener> getLista() {
        return lista;
    }

}
