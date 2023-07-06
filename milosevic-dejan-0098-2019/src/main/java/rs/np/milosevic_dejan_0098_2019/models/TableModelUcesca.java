package rs.np.milosevic_dejan_0098_2019.models;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import rs.np.milosevic_dejan_0098_2019.so.ucesce.SOGetAllUcesce;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Predstavlja klasu koja kreira model tabele ucesca clanova na izabranom
 * treningu. Koristi se pri dodavanju ili izmeni treninga u bazi podataka.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class TableModelUcesca extends AbstractTableModel {

	/**
	 * Lista sa ucescima clanova na izabranom treningu
	 */
	private ArrayList<Ucesce> lista;

	/**
	 * Nazivi kolona u tabeli kao String
	 */
	private String[] kolone = { "Rb", "Clan", "Napomena" };

	/**
	 * Redni broj ucesca kao ceo broj
	 */
	private int rb = 0;

	/**
	 * Prazan konstruktor koji inicijalizuje listu sa ucescima.
	 */
	public TableModelUcesca() {
		lista = new ArrayList<>();
	}

	/**
	 * Konstruktor koji poziva sistemsku operaciju za ucitavanje svih ucesca clanova
	 * na treningu unetog kao parametar.
	 * 
	 * @param t trening iz baze podataka za koji se ucitavaju sva ucesca
	 */
	public TableModelUcesca(Trening t) {
		try {
			SOGetAllUcesce so = new SOGetAllUcesce();

			Ucesce u = new Ucesce();
			u.setTrening(t);

			so.templateExecute(u);

			lista = so.getLista();
		} catch (Exception ex) {
			Logger.getLogger(TableModelUcesca.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Vraca broj redova u tabeli.
	 */
	@Override
	public int getRowCount() {
		return lista.size();
	}

	/**
	 * Vraca broj kolona u tabeli.
	 */
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	/**
	 * Vraca naziv i-te kolone tabele.
	 * 
	 * @param i broj kolone tabele
	 */
	@Override
	public String getColumnName(int i) {
		return kolone[i];
	}

	/**
	 * Vraca vrednost polja u tabeli.
	 * 
	 * @param row red tabele u kojoj se nalazi polje
	 * @param column kolona tabele u kojoj se nalazi polje
	 * 
	 * @return vrednost polja u tabeli kao Object
	 */
	@Override
	public Object getValueAt(int row, int column) {
		Ucesce u = lista.get(row);

		switch (column) {
		case 0:
			return u.getRbUcesca();
		case 1:
			return u.getClan();
		case 2:
			return u.getNapomena();

		default:
			return null;
		}
	}

	/**
	 * Dodaje ucesce u tabelu i azurira je.
	 * 
	 * @param u ucesce koje se dodaje u tabelu
	 */
	public void dodajUcesce(Ucesce u) {
		rb = lista.size();
		u.setRbUcesca(++rb);
		lista.add(u);
		fireTableDataChanged();
	}

	/**
	 * Brise ucesce iz tabele i azurira je.
	 * 
	 * @param row red tabele ucesca koji se brise
	 */
	public void obrisiUcesce(int row) {
		lista.remove(row);

		rb = 0;
		for (Ucesce ucesce : lista) {
			ucesce.setRbUcesca(++rb);
		}

		fireTableDataChanged();
	}

	/**
	 * Proverava da li u tabeli ucesca postoji clan koji je unet kao parametar.
	 * 
	 * @param clan clan cije se ucesce na izabranom treningu proverava
	 * 
	 * @return true - ako postoji uneti clan u tabeli ucesca, false - ako ne postoji
	 */
	public boolean postojiClan(Clan clan) {
		for (Ucesce ucesce : lista) {
			if (ucesce.getClan().getClanID().equals(clan.getClanID())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vraca listu ucesca na izabranom treningu.
	 * 
	 * @return lista ucesca na izabranom treningu
	 */
	public ArrayList<Ucesce> getLista() {
		return lista;
	}

}
