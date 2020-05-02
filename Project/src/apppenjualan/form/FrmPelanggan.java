/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.form;

import apppenjualan.AppPenjualan;
import apppenjualan.control.PelangganController;
import apppenjualan.data.Pelanggan;
import com.mysql.jdbc.Connection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.DriverManager;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gxry
 */
public class FrmPelanggan extends javax.swing.JInternalFrame implements NavigatorFormInt {

    PelangganController plgctrl = new PelangganController(AppPenjualan.emf); 
    Pelanggan plg = new Pelanggan();
    /**
     * Creates new form FrmBarang
     */
    public FrmPelanggan() {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtNamaPelanggan = new javax.swing.JTextField();
        jtxtKodePelanggan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAlamat = new javax.swing.JTextArea();

        setTitle("Master Pelanggan");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pelanggan");

        jLabel2.setText("Kode Pelanggan:");

        jLabel3.setText("Nama Pelanggan:");

        jLabel4.setText("Alamat:");

        jtxtKodePelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtKodePelangganKeyPressed(evt);
            }
        });

        jtxtAlamat.setColumns(20);
        jtxtAlamat.setRows(5);
        jScrollPane1.setViewportView(jtxtAlamat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNamaPelanggan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtKodePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtKodePelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtKodePelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtKodePelangganKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            findData(); 
        }
    }//GEN-LAST:event_jtxtKodePelangganKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jtxtAlamat;
    private javax.swing.JTextField jtxtKodePelanggan;
    private javax.swing.JTextField jtxtNamaPelanggan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clearData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        jtxtNamaPelanggan.setText(""); 
        jtxtNamaPelanggan.setText("");
        jtxtAlamat.setText("");
    }

    @Override
    public void newData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        jtxtKodePelanggan.setText(""); 
        clearData(); 
        jtxtKodePelanggan.requestFocus();
    }

    @Override
    public void saveData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!jtxtKodePelanggan.getText().trim().equals("")) { 
            plg = plgctrl.findPelanggan(jtxtKodePelanggan.getText());             
            if (plg == null) { 
                //jika barang tidak diketemukan maka tambah data 
                plg = new Pelanggan(); 
                setData(); 
                try { 
                    plgctrl.create(plg); 
                } catch (Exception ex) {} 
                JOptionPane.showMessageDialog(null, "Penambahan Data Selesai"); 
            } else { 
                //jika barang diketemukan maka update data 
                setData(); 
                try { 
                    plgctrl.edit(plg); 
                } catch (Exception ex) {}                 
                JOptionPane.showMessageDialog(null, "Simpan Selesai"); 
            } 
        } else { 
            JOptionPane.showMessageDialog(null, "Kode Pelanggan Tidak Boleh Kosong"); 
        }
    }

    @Override
    public void setData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        plg.setNamapelanggan(jtxtNamaPelanggan.getText()); 
        plg.setKodepelanggan(jtxtKodePelanggan.getText());
        plg.setAlamat(jtxtAlamat.getText());
    }

    @Override
    public void delete() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try { 
            plgctrl.destroy(jtxtKodePelanggan.getText());
            JOptionPane.showMessageDialog(null, "Penghapusan Selesai"); 
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog( null, "Penghapusan tidak bisa karena " + ex.getMessage()); 
        } 
        clearData();
    }

    @Override
    public void findData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //karena Pak Windu tidak memberikan code-nya, jadi saya coba buat sendiri
        plg = plgctrl.findPelanggan(jtxtKodePelanggan.getText());
        showData();
        
    }

    @Override
    public void showData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //karena Pak Windu tidak memberikan code-nya, jadi saya coba buat sendiri
        jtxtNamaPelanggan.setText(plg.getNamapelanggan());
        jtxtAlamat.setText(plg.getAlamat());
    }

    @Override
    public void printData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        EntityManager em = null;     
        try { 
            em = AppPenjualan.emf.createEntityManager(); 
            em.getTransaction().begin();
            
            //code dibawah ini adalah milik Pak Windu, namun error di Netbeans saya
            //kemungkinan karena Lib Eclipselink (JPA) yang saya pakai
            
            /*Connection connect = em.unwrap(Connection.class);*/
            
            //namun code diatas, dapat diakali dengan teknik di bawah ini
            //saya kurang tau juga, apakah code di bawah ini adalah menggunakan metode persistence atau tidak
            //tapi yang penting jalan toh... :D
            //salam imut dulu ahhh...
            Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan", "root", "P@ssw0rd");
            
            File file = new File("");  
            String sourcefilename = file.getAbsolutePath() + "\\src\\apppenjualan\\report\\Pelanggan.jasper"; 
 
            JasperPrint jprint = JasperFillManager.fillReport(sourcefilename, new HashMap(), connect); 
            JasperViewer viewer = new JasperViewer(jprint, false); 
            viewer.setFitPageZoomRatio(); 
            viewer.setVisible(true); 
 
            em.getTransaction().commit(); 
            connect.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Tidak Bisa Print : " + e.getMessage());         
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        }
    }
}