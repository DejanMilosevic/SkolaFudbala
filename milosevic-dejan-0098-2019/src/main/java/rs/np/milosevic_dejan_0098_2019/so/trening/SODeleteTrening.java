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

/**
 *
 * @author Dejan
 */
public class SODeleteTrening extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Trening)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Trening!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}