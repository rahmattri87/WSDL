/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.browse;

import java.util.List;
import apppenjualan.data.Pelanggan;
import apppenjualan.control.PelangganController;
import apppenjualan.browsetool.FrmBrowse;
import apppenjualan.AppPenjualan;

/**
 *
 * @author Administrator
 */
public class FrmBrowsePelanggan extends FrmBrowse{
    
    PelangganController pljpa = new PelangganController(AppPenjualan.emf);
    
    public FrmBrowsePelanggan() {
        columns = pljpa.getColumns();
        init();
        retrieveData();
    }

    public void retrieveData () {

        super.retrieveData();
        
        Object[] data = new Object[tmodel.getColumnCount()]; 
        
        List<Pelanggan> lplg = pljpa.findQuery(field, operator, value, field, sort, limit, firstresult);
             
        for (Pelanggan plg : lplg) {
            tmodel.addRow(data);
            tmodel.setValueAt(plg.getKodepelanggan(), tmodel.getRowCount() -1 , 0);
            tmodel.setValueAt(plg.getNamapelanggan(), tmodel.getRowCount() -1 , 1);
        } 
        
        jtxtRecordFound.setText(lplg.size()+"");
    }    
    
}
