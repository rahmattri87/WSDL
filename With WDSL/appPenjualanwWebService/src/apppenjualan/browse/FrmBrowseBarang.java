/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.browse;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import apppenjualan.data.Barang;
import apppenjualan.control.BarangController;
import apppenjualan.browsetool.FrmBrowse;
import apppenjualan.AppPenjualan;

/**
 *
 * @author Administrator
 */
public class FrmBrowseBarang extends FrmBrowse{
    
    BarangController brgjpa = new BarangController(AppPenjualan.emf);
    
    public FrmBrowseBarang() {
        columns = brgjpa.getColumns();
        init();
        retrieveData();
    }
    public FrmBrowseBarang(JTable jtable, int row, int col) {
        columns = brgjpa.getColumns();
        init();
        retrieveData();
        rowtable1 = row;
        coltable1 = col;
        jtableparam = jtable;
    } 
   
     public FrmBrowseBarang(TableModel tmodel, int row, int col) {
        columns = brgjpa.getColumns();
        init();
        retrieveData();
        rowtable1 = row;
        coltable1 = col;
        tmodelparam = tmodel;
    } 
    
    public void retrieveData () {
        super.retrieveData();
        
        Object[] data = new Object[tmodel.getColumnCount()]; 
        
        List<Barang> lbrg = brgjpa.findQuery(field, operator, value, field, sort, limit, firstresult);
             
        for (Barang brg : lbrg) {
            tmodel.addRow(data);
            tmodel.setValueAt(brg.getKodebarang(), tmodel.getRowCount() -1 , 0);
            tmodel.setValueAt(brg.getNamabarang(), tmodel.getRowCount() -1 , 1);
            tmodel.setValueAt(brg.getHargaStandard(), tmodel.getRowCount() -1 , 2);
        } 
        
        jtxtRecordFound.setText(lbrg.size()+"");
    }

}
