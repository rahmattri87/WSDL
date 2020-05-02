/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.form;

import apppenjualan.AppPenjualan;
import apppenjualan.control.BarangController;
import apppenjualan.data.Barang;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
//import java.sql.Connection;
//import java.sql.DriverManager;
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
public class FrmBarang extends javax.swing.JInternalFrame implements NavigatorFormInt {

    BarangController brgctrl = new BarangController(AppPenjualan.emf); 
    Barang brg = new Barang();
    
    /**
     * Creates new form FrmBarang
     */
    public FrmBarang() {
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
        jLabel5 = new javax.swing.JLabel();
        jtxtHargaStandard = new javax.swing.JTextField();
        jtxtStok = new javax.swing.JTextField();
        jtxtNamaBarang = new javax.swing.JTextField();
        jtxtKodeBarang = new javax.swing.JTextField();

        setTitle("Master Barang");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Barang");

        jLabel2.setText("Kode Barang:");

        jLabel3.setText("Nama Barang:");

        jLabel4.setText("Stok:");

        jLabel5.setText("Harga Standard:");

        jtxtHargaStandard.setText("0");

        jtxtStok.setText("0");

        jtxtKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtKodeBarangKeyPressed(evt);
            }
        });

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
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtHargaStandard, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jtxtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtHargaStandard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtKodeBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtKodeBarangKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            findData(); 
        }
    }//GEN-LAST:event_jtxtKodeBarangKeyPressed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jtxtHargaStandard;
    private javax.swing.JTextField jtxtKodeBarang;
    private javax.swing.JTextField jtxtNamaBarang;
    private javax.swing.JTextField jtxtStok;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clearData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        jtxtNamaBarang.setText(""); 
        jtxtStok.setText("0"); 
        jtxtHargaStandard.setText("0");
    }

    @Override
    public void newData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        jtxtKodeBarang.setText(""); 
        clearData(); 
        jtxtKodeBarang.requestFocus();
    }

    @Override
    public void saveData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        if (!jtxtKodeBarang.getText().trim().equals("")) { 
            brg = brgctrl.findBarang(jtxtKodeBarang.getText());             
            if (brg == null) { 
                //jika barang tidak diketemukan maka tambah data 
                brg = new Barang(); 
                setData(); 
                try { 
                    brgctrl.create(brg); 
                } catch (Exception ex) {} 
                JOptionPane.showMessageDialog(null, "Penambahan Data Selesai"); 
            } else { 
                //jika barang diketemukan maka update data 
                setData(); 
                try { 
                    brgctrl.edit(brg); 
                } catch (Exception ex) {}                 
                JOptionPane.showMessageDialog(null, "Simpan Selesai"); 
            } 
        } else { 
            JOptionPane.showMessageDialog(null, "Kode Barang Tidak Boleh Kosong"); 
        }
    }

    @Override
    public void setData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        brg.setKodebarang(jtxtKodeBarang.getText()); 
        brg.setNamabarang(jtxtNamaBarang.getText()); 
        try { 
            brg.setStok(Integer.parseInt(jtxtStok.getText())); 
        } catch(Exception e) { 
            brg.setStok(0); 
        } 
        try { 
            brg.setHargaStandard( 
            Double.parseDouble(jtxtHargaStandard.getText())); 
        } catch(Exception e) { 
            brg.setHargaStandard(0D); 
        }
    }

    @Override
    public void delete() {
        //throw new UnsupportedOperationException("Not supported yet.");
        try { 
            brgctrl.destroy(jtxtKodeBarang.getText());
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
        brg = brgctrl.findBarang(jtxtKodeBarang.getText());
        showData();
    }

    @Override
    public void showData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //karena Pak Windu tidak memberikan code-nya, jadi saya coba buat sendiri
        jtxtKodeBarang.setText(brg.getKodebarang());
        jtxtNamaBarang.setText(brg.getNamabarang());
        jtxtStok.setText(brg.getStok().toString());
        jtxtHargaStandard.setText(brg.getHargaStandard().toString());
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
            
            Connection connect = em.unwrap(Connection.class);
            
            //namun code diatas, dapat diakali dengan teknik di bawah ini
            //saya kurang tau juga, apakah code di bawah ini adalah menggunakan metode persistence atau tidak
            //tapi yang penting jalan toh... :D
            //salam imut dulu ahhh...
            //Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan", "root", "P@ssw0rd");
            
            File file = new File("");  
            String sourcefilename = file.getAbsolutePath() + "\\src\\apppenjualan\\report\\Barang.jasper"; 
 
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

    @Override
    public void moveFirst() {
        //throw new UnsupportedOperationException("Not supported yet.");
        brg = brgctrl.moveFirst();
        showData();
    }

    @Override
    public void movePrevious() {
        //throw new UnsupportedOperationException("Not supported yet.");
        brg = brgctrl.movePrevious(jtxtKodeBarang.getText());
        showData();
    }

    @Override
    public void moveNext() {
        //throw new UnsupportedOperationException("Not supported yet.");
        brg = brgctrl.moveNext(jtxtKodeBarang.getText());
        showData();
    }

    @Override
    public void moveLast() {
        //throw new UnsupportedOperationException("Not supported yet.");
        brg = brgctrl.moveLast();
        showData();
    }
}
