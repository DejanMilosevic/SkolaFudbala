package rs.np.milosevic_dejan_0098_2019.models;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.so.clan.SOGetAllClan;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Predstavlja klasu koja kreira model tabele clanova skole fudbala. Koristi se
 * pri pretrazi clanova.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class TableModelClanovi extends AbstractTableModel implements Runnable {

	/**
	 * Lista sa clanovima skole fudbala
	 */
	private ArrayList<Clan> lista;

	/**
	 * Nazivi kolona u tabeli kao String
	 */
	private String[] kolone = { "ID", "Ime", "Prezime", "Kategorija", "Email", "Telefon", "Pozicija" };

	/**
	 * Parametar na osnovu koga se vrsi pretraga clanova kao String
	 */
	private String parametar = "";

	/**
	 * Konstruktor koji poziva sistemsku operaciju za ucitavanje svih clanova iz
	 * baze podataka i prikazuje ih u tabeli.
	 */
	public TableModelClanovi() {
		try {
			SOGetAllClan so = new SOGetAllClan();
			so.templateExecute(new Clan());
			lista = so.getLista();
		} catch (Exception ex) {
			Logger.getLogger(TableModelClanovi.class.getName()).log(Level.SEVERE, null, ex);
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
		Clan c = lista.get(row);

		switch (column) {
		case 0:
			return c.getClanID();
		case 1:
			return c.getImeClana();
		case 2:
			return c.getPrezimeClana();
		case 3:
			return c.getKategorija();
		case 4:
			return c.getEmail();
		case 5:
			return c.getTelefonClana();
		case 6:
			return c.getPozicija();
		default:
			return null;
		}
	}

	/**
	 * Vraca clana koji se nalazi u izabranom redu tabele.
	 * 
	 * @param row broj izabranog reda u tabeli
	 * 
	 * @return clan koji se nalazi u izabranom redu tabele
	 */
	public Clan getSelectedClan(int row) {
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
			Logger.getLogger(TableModelClanovi.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Postavlja vrednost parametra na osnovu na kojeg se vrsi pretraga clanova.
	 * 
	 * @param parametar nova vrednost na osnovu koje se vrsi pretraga clanova
	 */
	public void setParametar(String parametar) {
		this.parametar = parametar;
		refreshTable();
	}

	/**
	 * Azurira stanje tabele clanova nakon unosenja parametra za pretragu ili
	 * izmene, odnosno brisanja odredjenog clana.
	 * 
	 * Poziva sistemsku operaciju za ucitavanje svih clanova iz baze podataka, a
	 * zatim proverava da li je unesen parametar. Ukoliko jeste, poredi ime i
	 * prezime svakog clana u bazi sa vrednoscu parametra i ubacuje u tabelu samo
	 * one clanove kod kojih postoji podudaranje.
	 */
	public void refreshTable() {
		try {
			SOGetAllClan so = new SOGetAllClan();
			so.templateExecute(new Clan());
			lista = so.getLista();
			if (!parametar.equals("")) {
				ArrayList<Clan> novaLista = new ArrayList<>();
				for (Clan c : lista) {
					if (c.getImeClana().toLowerCase().contains(parametar.toLowerCase())
							|| c.getPrezimeClana().toLowerCase().contains(parametar.toLowerCase())
							|| (c.getImeClana() + " " + c.getPrezimeClana()).toLowerCase()
									.contains(parametar.toLowerCase())) {
						novaLista.add(c);
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
