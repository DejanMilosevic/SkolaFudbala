/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.milosevic_dejan_0098_2019.FormClan;

import rs.np.milosevic_dejan_0098_2019.domain.Clan;
import rs.np.milosevic_dejan_0098_2019.forme.MainForm;
import javax.swing.JOptionPane;
import rs.np.milosevic_dejan_0098_2019.models.TableModelClanovi;

/**
 *
 * @author Dejan
 */
public class FormPretragaClana extends javax.swing.JDialog {

    public FormPretragaClana(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        TableModelClanovi model = new TableModelClanovi();
        Thread th = new Thread(model);
        th.start();
        tblClanovi.setModel(model);
        setTitle("Pretraga clana");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClanovi = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraga (ime i prezime):");

        tblClanovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblClanovi);

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnDetalji.setBackground(new java.awt.Color(0, 0, 102));
        btnDetalji.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalji.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalji.setText("Detalji clana");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String param = txtPretraga.getText();
        ((TableModelClanovi) tblClanovi.getModel()).setParametar(param);
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed

        int row = tblClanovi.getSelectedRow();

        if (row >= 0) {
            Clan c = ((TableModelClanovi) tblClanovi.getModel()).getSelectedClan(row);
            JOptionPane.showMessageDialog(this, "Sistem je ucitao clana.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            new FormDetaljiClana(this, rootPaneCheckingEnabled, c).setVisible(true);
        }

    }//GEN-LAST:event_btnDetaljiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClanovi;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    void refreshTable() {
        TableModelClanovi tm = (TableModelClanovi) tblClanovi.getModel();
        tm.refreshTable();
    }

    void popuniKategorije() {
        MainForm mf = (MainForm) getParent();
        mf.popuniKategorije();
    }

}