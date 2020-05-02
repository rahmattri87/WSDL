/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.form;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gxry
 */
public class FrmMain extends javax.swing.JFrame {

    FrmBarang frmbarang;
    FrmPelanggan frmpelanggan;
    FrmPenjualan frmpenjualan;
    Frmkwitansi frmkwitansi;
    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jbtnNew = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnPrint = new javax.swing.JButton();
        jdesktoppane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnuMaster = new javax.swing.JMenu();
        jmniBarang = new javax.swing.JMenuItem();
        jmniPelanggan = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmniPenjualan = new javax.swing.JMenuItem();
        jmniKwiTansi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jbtnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_newfile.gif"))); // NOI18N
        jbtnNew.setText("New");
        jbtnNew.setFocusable(false);
        jbtnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNew.setName("");
        jbtnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnNew);

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_save.gif"))); // NOI18N
        jbtnSave.setText("Save");
        jbtnSave.setFocusable(false);
        jbtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnSave);

        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_del.gif"))); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.setFocusable(false);
        jbtnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnDelete);

        jbtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.gif"))); // NOI18N
        jbtnPrint.setText("Print");
        jbtnPrint.setFocusable(false);
        jbtnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(jbtnPrint);

        jmnuMaster.setText("Master");
        jmnuMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnuMasterActionPerformed(evt);
            }
        });

        jmniBarang.setText("Barang");
        jmniBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniBarangActionPerformed(evt);
            }
        });
        jmnuMaster.add(jmniBarang);

        jmniPelanggan.setText("Pelanggan");
        jmniPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniPelangganActionPerformed(evt);
            }
        });
        jmnuMaster.add(jmniPelanggan);

        jMenuBar1.add(jmnuMaster);

        jMenu2.setText("Transaksi");

        jmniPenjualan.setText("Penjualan");
        jmniPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniPenjualanActionPerformed(evt);
            }
        });
        jMenu2.add(jmniPenjualan);

        jmniKwiTansi.setText("Kwitansi");
        jmniKwiTansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniKwiTansiActionPerformed(evt);
            }
        });
        jMenu2.add(jmniKwiTansi);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesktoppane)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdesktoppane, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmniBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniBarangActionPerformed
        // TODO add your handling code here:
        if (frmbarang == null) { 
            frmbarang = new FrmBarang(); 
        } 
        showForm(frmbarang);
    }//GEN-LAST:event_jmniBarangActionPerformed

    private void jmniPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniPelangganActionPerformed
        // TODO add your handling code here:
        if (frmpelanggan == null) { 
            frmpelanggan = new FrmPelanggan(); 
        } 
        showForm(frmpelanggan);
    }//GEN-LAST:event_jmniPelangganActionPerformed

    private void jbtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewActionPerformed
        // TODO add your handling code here:
        navformint = (NavigatorFormInt)  
        jdesktoppane.getSelectedFrame(); 
        navformint.newData();
    }//GEN-LAST:event_jbtnNewActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // TODO add your handling code here:
        navformint = (NavigatorFormInt)  
        jdesktoppane.getSelectedFrame(); 
        navformint.saveData();                
        JOptionPane.showMessageDialog(null, "Simpan Selesai");
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        // TODO add your handling code here:
        int jawaban =  JOptionPane.showConfirmDialog (null, "Delete This Data ?", "Delete ? ", JOptionPane.YES_NO_OPTION); 
        if (jawaban == JOptionPane.YES_OPTION ) { 
            navformint = (NavigatorFormInt)  
            jdesktoppane.getSelectedFrame(); 
            navformint.delete(); 
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintActionPerformed
        // TODO add your handling code here:
        navformint = (NavigatorFormInt)  
        jdesktoppane.getSelectedFrame(); 
        navformint.printData();
    }//GEN-LAST:event_jbtnPrintActionPerformed

    private void jmnuMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnuMasterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmnuMasterActionPerformed

    private void jmniPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniPenjualanActionPerformed
        // TODO add your handling code here:
        if (frmpenjualan == null) { 
            frmpenjualan = new FrmPenjualan(); 
        } 
        showForm(frmpenjualan);
    }//GEN-LAST:event_jmniPenjualanActionPerformed

    private void jmniKwiTansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniKwiTansiActionPerformed
        // TODO add your handling code here:
        if (frmkwitansi == null) { 
            frmkwitansi = new Frmkwitansi(); 
        } 
        showForm(frmkwitansi);
    }//GEN-LAST:event_jmniKwiTansiActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnNew;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JDesktopPane jdesktoppane;
    private javax.swing.JMenuItem jmniBarang;
    private javax.swing.JMenuItem jmniKwiTansi;
    private javax.swing.JMenuItem jmniPelanggan;
    private javax.swing.JMenuItem jmniPenjualan;
    private javax.swing.JMenu jmnuMaster;
    // End of variables declaration//GEN-END:variables

    NavigatorFormInt navformint ; 
  
    private void showForm(Object obj) { 
        JInternalFrame jf = null; 
        //jika objek merupakan JInternalFrame 
        if (obj instanceof JInternalFrame) { 
            jf = (JInternalFrame) obj; 
            //Apabila belum pernah ditampilkan maka ditambahkan pada 
            //jdesktoppane 
            if (!jf.isVisible()) { 
                jdesktoppane.add(jf); 
            } 
            //tampilkan objek JinternalFrame 
            jf.setVisible(true); 
            try {         
                jf.setMaximum(true); 
                jf.setSelected(true);     
            } catch (java.beans.PropertyVetoException e) { 
                e.printStackTrace(); 
            }         
        }         
    }
}
