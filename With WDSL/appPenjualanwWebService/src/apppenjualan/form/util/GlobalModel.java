/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package apppenjualan.form.util;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author wgata
 */
public class GlobalModel {

    public static void setColHeader(DefaultTableModel dtm, String[][] columns){
        for (int i=0;i<columns.length;i++){
            dtm.addColumn(columns[i][0]);
        }
    }

   
    public static void setCol (JTable jtable, String[][] columns) {
        for (int i=0;i<columns.length;i++){
            setColumnWidth(jtable, i, Integer.parseInt(columns[i][2]));
        }       
    }

    public static void setCol (JTable jtable, int[] columns) {
        for (int i=0;i<columns.length;i++){
            setColumnWidth(jtable, i,columns[i]);
        }       
    }
    
    public static void showTable(JTable jtable, DefaultTableModel dtm) {
            jtable.setModel(dtm);
    }
    
    public static void setColumnWidth(JTable jtable, Integer ColumnIdx,Integer Width){
       TableColumn column= jtable.getColumnModel().getColumn(ColumnIdx);
       column.setResizable(false);
       column.setMinWidth(0);
       column.setMaxWidth(Width);
       column.setPreferredWidth(Width);
    }    
    
    public static void clearRow (DefaultTableModel dtm) {
        int row = dtm.getRowCount();			
        while(row > 0){	
           row--;				
           dtm.removeRow(row);
        }
             
    }
    
    private void renderColumn(JTable jtable, Integer ColumnIdx,final Boolean RightAlignment, final Boolean CenterAlignment){
          jtable.getColumnModel().getColumn(ColumnIdx).setCellRenderer(new DefaultTableCellRenderer(){
          public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
            if (RightAlignment){
                setHorizontalAlignment(RIGHT);
            }
            if (CenterAlignment){
                setHorizontalAlignment(CENTER);
            }
            return super.getTableCellRendererComponent(table, value, isSelected,
                                                      hasFocus, row, column);
          }
        });       
    }
    
    
    public static  void selectCellTable(JTable  jtable , int row,int col){
        if(row!=-1 && col !=-1){
            jtable.setRowSelectionInterval(row,row);
            jtable.setColumnSelectionInterval(col,col);
        }
    }
    public static void scrollTableRowTo(JTable  jtable, int row){
            Rectangle rec = jtable.getCellRect(row, 0, true);
            jtable.scrollRectToVisible(rec);
    }
    
}
