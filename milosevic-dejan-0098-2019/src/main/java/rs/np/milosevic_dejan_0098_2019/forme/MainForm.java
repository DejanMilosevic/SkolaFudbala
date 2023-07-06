package rs.np.milosevic_dejan_0098_2019.forme;

import rs.np.milosevic_dejan_0098_2019.FormClan.FormNoviClan;
import rs.np.milosevic_dejan_0098_2019.FormClan.FormPretragaClana;
import rs.np.milosevic_dejan_0098_2019.FormTrening.FormPretragaTreninga;
import rs.np.milosevic_dejan_0098_2019.domain.Administrator;
import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.domain.Kategorija;
import rs.np.milosevic_dejan_0098_2019.domain.Teren;
import rs.np.milosevic_dejan_0098_2019.domain.Trener;
import rs.np.milosevic_dejan_0098_2019.domain.Trening;
import rs.np.milosevic_dejan_0098_2019.domain.Ucesce;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import rs.np.milosevic_dejan_0098_2019.models.TableModelUcesca;
import rs.np.milosevic_dejan_0098_2019.so.clan.SOGetAllClan;
import rs.np.milosevic_dejan_0098_2019.so.kategorija.SOGetAllKategorija;
import rs.np.milosevic_dejan_0098_2019.so.teren.SOGetAllTeren;
import rs.np.milosevic_dejan_0098_2019.so.trener.SOGetAllTrener;
import rs.np.milosevic_dejan_0098_2019.so.trening.SOAddTrening;

/**
 * Predstavlja glavnu formu koja se otvara nakon sto se administrator uspesno
 * prijavi na sistem. Sadrzi komponente koje omogucavaju dodavanje novog
 * treninga, kao i meni sa opcijama za prelazak na ostale forme.
 * 
 * @author Dejan Milosevic
 * @since 1.1.0
 */
public class MainForm extends javax.swing.JFrame {

	/**
	 * Ulogovani administrator cije se ime i prezime prikazuje na vrhu forme
	 */
	Administrator ulogovani;

	/**
	 * Konstruktor koji kreira formu. Inicijalizuje komponente forme, i postavlja
	 * njenu lokaciju i naslov.
	 * 
	 * @param ulogovani administrator koji se ulogovao na sistem
	 */
	public MainForm(Administrator ulogovani) {
		initComponents();
		setLocationRelativeTo(null);
		this.ulogovani = ulogovani;
		lblUlogovani.setText("Ulogovani administrator: " + ulogovani);
		setTitle("Klijentska forma");
		popuniTerene();
		popuniKategorije();
		popuniTrenere();
		tblUcesca.setModel(new TableModelUcesca());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		lblUlogovani = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		cmbTeren = new javax.swing.JComboBox<Object>();
		txtDatumVreme = new javax.swing.JFormattedTextField();
		cmbKategorija = new javax.swing.JComboBox();
		cmbTrener = new javax.swing.JComboBox();
		txtMaxBrojClanova = new javax.swing.JFormattedTextField();
		jPanel2 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		cmbClan = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtNapomena = new javax.swing.JTextArea();
		btnDodajUcesce = new javax.swing.JButton();
		btnObrisiUcesce = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblUcesca = new javax.swing.JTable();
		btnSacuvaj = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu6 = new javax.swing.JMenu();
		miNoviClan = new javax.swing.JMenuItem();
		miPretragaClana = new javax.swing.JMenuItem();
		jMenu7 = new javax.swing.JMenu();
		miPretragaTreninga = new javax.swing.JMenuItem();
		jMenu8 = new javax.swing.JMenu();
		miOdjava = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblUlogovani.setText("Ulogovani");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos treninga"));

		jLabel1.setText("Teren:");

		jLabel2.setText("Datum i vreme:");

		jLabel3.setText("Kategorija:");

		jLabel4.setText("Trener:");

		jLabel5.setText("Max broj clanova:");
		cmbTeren.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		txtDatumVreme.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm"))));
		txtDatumVreme.setText("10.08.2023 10:00");

		cmbKategorija.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cmbKategorija.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				cmbKategorijaItemStateChanged(evt);
			}
		});

		cmbTrener.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		txtMaxBrojClanova.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
		txtMaxBrojClanova.setText("5");

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos ucesca"));

		jLabel6.setText("Clan:");

		jLabel7.setText("Napomena:");

		cmbClan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		txtNapomena.setColumns(20);
		txtNapomena.setRows(5);
		jScrollPane1.setViewportView(txtNapomena);

		btnDodajUcesce.setBackground(new java.awt.Color(0, 0, 102));
		btnDodajUcesce.setForeground(new java.awt.Color(255, 255, 255));
		btnDodajUcesce.setText("Dodaj ucesce");
		btnDodajUcesce.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDodajUcesceActionPerformed(evt);
			}
		});

		btnObrisiUcesce.setBackground(new java.awt.Color(153, 0, 0));
		btnObrisiUcesce.setForeground(new java.awt.Color(255, 255, 255));
		btnObrisiUcesce.setText("Obrisi ucesce");
		btnObrisiUcesce.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnObrisiUcesceActionPerformed(evt);
			}
		});

		tblUcesca
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(tblUcesca);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane2)
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel6).addGap(55, 55, 55)
								.addComponent(cmbClan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel7).addGap(18, 18, 18)
								.addComponent(jScrollPane1))
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addComponent(btnDodajUcesce, javax.swing.GroupLayout.PREFERRED_SIZE, 294,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnObrisiUcesce, javax.swing.GroupLayout.PREFERRED_SIZE, 294,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(cmbClan, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(2, 2, 2)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnDodajUcesce).addComponent(btnObrisiUcesce))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)));

		btnSacuvaj.setBackground(new java.awt.Color(0, 102, 0));
		btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
		btnSacuvaj.setForeground(new java.awt.Color(255, 255, 255));
		btnSacuvaj.setText("Sacuvaj trening");
		btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSacuvajActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel5).addGap(18, 18, 18)
								.addComponent(txtMaxBrojClanova))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)
										.addComponent(jLabel4))
								.addGap(31, 31, 31)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(cmbTeren, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(txtDatumVreme, javax.swing.GroupLayout.DEFAULT_SIZE, 518,
												Short.MAX_VALUE)
										.addComponent(cmbKategorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(cmbTrener, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(193, 193, 193)
						.addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 247,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(cmbTeren, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtDatumVreme,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(cmbKategorija,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cmbTrener, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(txtMaxBrojClanova,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnSacuvaj,
								javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(8, Short.MAX_VALUE)));

		jMenu6.setText("Clan");

		miNoviClan.setText("Novi clan");
		miNoviClan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miNoviClanActionPerformed(evt);
			}
		});
		jMenu6.add(miNoviClan);

		miPretragaClana.setText("Pretraga clana");
		miPretragaClana.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miPretragaClanaActionPerformed(evt);
			}
		});
		jMenu6.add(miPretragaClana);

		jMenuBar1.add(jMenu6);

		jMenu7.setText("Trening");

		miPretragaTreninga.setText("Pretraga treninga");
		miPretragaTreninga.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miPretragaTreningaActionPerformed(evt);
			}
		});
		jMenu7.add(miPretragaTreninga);

		jMenuBar1.add(jMenu7);

		jMenu8.setText("Odjava");

		miOdjava.setText("Odjavi se");
		miOdjava.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miOdjavaActionPerformed(evt);
			}
		});
		jMenu8.add(miOdjava);

		jMenuBar1.add(jMenu8);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUlogovani))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(lblUlogovani)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void miNoviClanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miNoviClanActionPerformed
		new FormNoviClan(this, true).setVisible(true);
	}// GEN-LAST:event_miNoviClanActionPerformed

	private void miPretragaClanaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miPretragaClanaActionPerformed
		new FormPretragaClana(this, true).setVisible(true);
	}// GEN-LAST:event_miPretragaClanaActionPerformed

	private void miPretragaTreningaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miPretragaTreningaActionPerformed
		new FormPretragaTreninga(this, true).setVisible(true);
	}// GEN-LAST:event_miPretragaTreningaActionPerformed

	private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miOdjavaActionPerformed
		int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da " + "se odjavite sa sistema?",
				"Konfirmacija", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.NO_OPTION) {
			return;
		}

		if (result == JOptionPane.YES_OPTION) {
			new LoginForma().setVisible(true);
			this.dispose();
		}
	}// GEN-LAST:event_miOdjavaActionPerformed

	private void btnDodajUcesceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDodajUcesceActionPerformed

		Clan c = (Clan) cmbClan.getSelectedItem();
		String napomena = txtNapomena.getText();

		Ucesce u = new Ucesce(null, -1, napomena, c);

		TableModelUcesca tm = (TableModelUcesca) tblUcesca.getModel();

		if (tm.postojiClan(u.getClan())) {
			JOptionPane.showMessageDialog(this, "Vec ste uneli ovog clana za ovaj trening!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		tm.dodajUcesce(u);

	}// GEN-LAST:event_btnDodajUcesceActionPerformed

	private void btnObrisiUcesceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnObrisiUcesceActionPerformed

		int row = tblUcesca.getSelectedRow();

		if (row >= 0) {
			TableModelUcesca tm = (TableModelUcesca) tblUcesca.getModel();
			tm.obrisiUcesce(row);
		}

	}// GEN-LAST:event_btnObrisiUcesceActionPerformed

	private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSacuvajActionPerformed

		try {
			if (txtDatumVreme.getText().isEmpty() || txtMaxBrojClanova.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!", "Upozorenje",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			Teren teren = (Teren) cmbTeren.getSelectedItem();
			Kategorija kategorija = (Kategorija) cmbKategorija.getSelectedItem();
			Trener trener = (Trener) cmbTrener.getSelectedItem();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			Date datumVreme = sdf.parse(txtDatumVreme.getText());
			int maxBrojClanova = Integer.parseInt(txtMaxBrojClanova.getText());

			TableModelUcesca tm = (TableModelUcesca) tblUcesca.getModel();

			Trening trening = new Trening(null, datumVreme, maxBrojClanova, kategorija, trener, teren, ulogovani,
					tm.getLista());

			(new SOAddTrening()).templateExecute(trening);
			resetujFormu();
			JOptionPane.showMessageDialog(this, "Sistem je kreirao trening!", "Obavestenje",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira trening: " + ex.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}// GEN-LAST:event_btnSacuvajActionPerformed

	private void cmbKategorijaItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cmbKategorijaItemStateChanged

		if (cmbKategorija.getSelectedItem() != null) {
			Kategorija kategorija = (Kategorija) cmbKategorija.getSelectedItem();
			popuniClanove(kategorija);
		}

	}// GEN-LAST:event_cmbKategorijaItemStateChanged

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDodajUcesce;
	private javax.swing.JButton btnObrisiUcesce;
	private javax.swing.JButton btnSacuvaj;
	private javax.swing.JComboBox cmbClan;
	private javax.swing.JComboBox cmbKategorija;
	private javax.swing.JComboBox cmbTeren;
	private javax.swing.JComboBox cmbTrener;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblUlogovani;
	private javax.swing.JMenuItem miNoviClan;
	private javax.swing.JMenuItem miOdjava;
	private javax.swing.JMenuItem miPretragaClana;
	private javax.swing.JMenuItem miPretragaTreninga;
	private javax.swing.JTable tblUcesca;
	private javax.swing.JFormattedTextField txtDatumVreme;
	private javax.swing.JFormattedTextField txtMaxBrojClanova;
	private javax.swing.JTextArea txtNapomena;
	// End of variables declaration//GEN-END:variables

	/**
	 * Poziva sistemsku operaciju za ucitavanje svih terena iz baze podataka i
	 * popunjava combo box ucitanim vrednostima.
	 */
	public void popuniTerene() {
		try {
			SOGetAllTeren so = new SOGetAllTeren();
			so.templateExecute(new Teren());

			ArrayList<Teren> tereni = so.getLista();

			cmbTeren.removeAllItems();
			for (Teren t : tereni) {
				cmbTeren.addItem(t);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Poziva sistemsku operaciju za ucitavanje svih kategorija iz baze podataka i
	 * popunjava combo box ucitanim vrednostima.
	 */
	public void popuniKategorije() {
		try {
			SOGetAllKategorija so = new SOGetAllKategorija();
			so.templateExecute(new Kategorija());

			ArrayList<Kategorija> kategorije = so.getLista();

			cmbKategorija.removeAllItems();

			for (Kategorija kategorija : kategorije) {
				cmbKategorija.addItem(kategorija);
			}

		} catch (Exception ex) {
			Logger.getLogger(FormNoviClan.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Poziva sistemsku operaciju za ucitavanje svih trenera iz baze podataka i
	 * popunjava combo box ucitanim vrednostima.
	 */
	private void popuniTrenere() {
		try {
			SOGetAllTrener so = new SOGetAllTrener();
			so.templateExecute(new Trener());

			ArrayList<Trener> treneri = so.getLista();

			cmbTrener.removeAllItems();

			for (Trener trener : treneri) {
				cmbTrener.addItem(trener);
			}

		} catch (Exception ex) {
			Logger.getLogger(FormNoviClan.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Poziva sistemsku operaciju za ucitavanje svih clanova iz baze podataka koji
	 * pripadaju kategoriji unetoj kao parametar i popunjava combo box ucitanim
	 * vrednostima.
	 * 
	 * @param kategorija kategorija ciji clanovi se ucitavaju iz baze
	 */
	public void popuniClanove(Kategorija kategorija) {
		try {
			SOGetAllClan so = new SOGetAllClan();

			Clan c = new Clan();
			c.setKategorija(kategorija);

			so.templateExecute(c);

			ArrayList<Clan> clanovi = so.getLista();

			cmbClan.removeAllItems();

			for (Clan clan : clanovi) {
				cmbClan.addItem(clan);
			}

		} catch (Exception ex) {
			Logger.getLogger(FormNoviClan.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Resetuje formu na pocetne vrednosti.
	 */
	private void resetujFormu() {
		txtDatumVreme.setText("");
		txtMaxBrojClanova.setText("");
		txtNapomena.setText("");
		tblUcesca.setModel(new TableModelUcesca());
	}

}
