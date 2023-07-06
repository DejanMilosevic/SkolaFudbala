package rs.np.milosevic_dejan_0098_2019.models;

import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.so.trening.SOGetAllTrening;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Predstavlja klasu koja kreira model tabele treninga. Koristi se pri pretrazi
 * treninga.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class TableModelTreninzi extends AbstractTableModel implements Runnable {

	/**
	 * Lista sa treninzima
	 */
	private ArrayList<Trening> lista;

	/**
	 * Nazivi kolona u tabeli kao String
	 */
	private String[] kolone = { "ID", "Teren", "Trener", "Kategorija", "Datum i vreme", "Maksimalan br. clanova" };

	/**
	 * Parametar na osnovu koga se vrsi pretraga treninga kao String
	 */
	private String parametar = "";

	/**
	 * Konstruktor koji poziva sistemsku operaciju za ucitavanje svih treninga iz
	 * baze podataka i prikazuje ih u tabeli.
	 */
	public TableModelTreninzi() {
		try {
			SOGetAllTrening so = new SOGetAllTrening();
			so.templateExecute(new Trening());
			lista = so.getLista();
		} catch (Exception ex) {
			Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
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
		Trening t = lista.get(row);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		switch (column) {
		case 0:
			return t.getTreningID();
		case 1:
			return t.getTeren();
		case 2:
			return t.getTrener();
		case 3:
			return t.getKategorija();
		case 4:
			return sdf.format(t.getDatumVreme());
		case 5:
			return t.getMaxBrojClanova();

		default:
			return null;
		}
	}

	/**
	 * Vraca trening koji se nalazi u izabranom redu tabele.
	 * 
	 * @param row broj izabranog reda u tabeli
	 * 
	 * @return trening koji se nalazi u izabranom redu tabele
	 */
	public Trening getSelectedTrening(int row) {
		return lista.get(row);
	}

	/**
	 * Osvezava stanje tabele na svakih 10 sekundi.
	 */
	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(10000);
				refreshTable();
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Postavlja vrednost parametra na osnovu na kojeg se vrsi pretraga treninga.
	 * 
	 * @param parametar nova vrednost na osnovu koje se vrsi pretraga treninga
	 */
	public void setParametar(String parametar) {
		this.parametar = parametar;
		refreshTable();
	}

	/**
	 * Azurira stanje tabele treninga nakon unosenja parametra za pretragu ili
	 * izmene, odnosno brisanja odredjenog treninga.
	 * 
	 * Poziva sistemsku operaciju za ucitavanje svih treninga iz baze podataka, a
	 * zatim proverava da li je unesen parametar. Ukoliko jeste, poredi ime i
	 * prezime trenera ili naziv terena svakog treninga u bazi sa vrednoscu
	 * parametra i ubacuje u tabelu samo one clanove kod kojih postoji podudaranje.
	 */
	public void refreshTable() {
		try {
			SOGetAllTrening so = new SOGetAllTrening();
			so.templateExecute(new Trening());
			lista = so.getLista();
			if (!parametar.equals("")) {
				ArrayList<Trening> novaLista = new ArrayList<>();
				for (Trening t : lista) {
					if (t.getTeren().getNazivTerena().contains(parametar.toLowerCase())
							|| t.getTrener().getImeTrenera().toLowerCase().contains(parametar.toLowerCase())
							|| t.getTrener().getPrezimeTrenera().toLowerCase().contains(parametar.toLowerCase())
							|| (t.getTrener().getImeTrenera() + " " + t.getTrener().getPrezimeTrenera()).toLowerCase()
									.contains(parametar.toLowerCase())) {
						novaLista.add(t);
					}
				}
				lista = novaLista;
			}

			fireTableDataChanged();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
