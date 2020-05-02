/*
 * FrmBrowse.java
 *
 * Created on December 22, 2008, 11:00 AM
 * 
 * FrmBrowse is POPUP Form to Filter Data From Collection
 * 
 * How To :
 * 1. Find array Column In Collection, and change to field/data you want to browse
 * 
 *   Sample : 
        private String[][] column = {
                                {Mastergroup.PRIMARYKEY, Mastergroup.PRIMARYKEY, "200"}, 
                                {Mastergroup.PRIMARYKEY, Mastergroup.PRIMARYKEY, "500"}
        };
 * 
 * 2. From Browse can be used with JTextField, JTable, TableModel
 * 
 * 3. If you input JInternalFrame as Parameter, 
        it will automatically run method searcData on Form
 * 
 */

package apppenjualan.browsetool;


import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author  windu
 */
public class FrmBrowse extends javax.swing.JDialog {

    
    protected DefaultTableModel tmodel=new BdModel();    
    protected BrowseColumnModelCol colModel=new BrowseColumnModelCol();
    
    
    protected JTextField first = null;
    protected JTextField second = null;
    protected JTextField third = null;
    protected JTextField fourth = null;
       
    protected int firstresult = 0;    
    protected int limit = 101;
    
    protected boolean replace = true;
    
    protected String[][] columns = {
        {"1", "Satu", "100"},
        {"2", "Dua", "200"},
        {"3", "Tiga", "200"},
        {"4", "Empat", "200"}
    };
    protected JTable jtableparam;
    protected TableModel tmodelparam;
    protected int coltable1 = 0;
    protected int rowtable1 = 0;
    
    
    protected String field; 
    protected String operator ;
    protected String value;                 
    protected String sort;

    
    /** Creates new form frmBrowse */


    public FrmBrowse() {
        initComponents();
        
    }
    
    protected void init() {
        setFieldInCombo();
        setColHeader();
        setColWidth();         
    }


    public void setFirstValue(JTextField first) {
        this.first = first;
    }

      
    public void setSecondValue(JTextField second) {
        this.second = second;
    }

    public void setThirdValue(JTextField third) {
        this.third = third;
    }

    public void setFourthValue(JTextField fourth) {
        this.fourth = fourth;
    }
    
    private void setFieldInCombo(){

        for (int i= 0; i < columns.length; i++ ) {
            colModel.Insert();
            colModel.getColModel().setColName(columns[i][0]);
            colModel.getColModel().setColDesc(columns[i][1]);
            colModel.getColModel().setColWidth(Integer.parseInt(columns[i][2]));
            colModel.add(colModel.getColModel());
        }

        for(int i=0;i<colModel.size();i++){
            jcmbField.addItem(colModel.get(i).getColDesc());
       }
    }
    
    private void setColHeader(){
        for (int i=0;i<colModel.size();i++){
            tmodel.addColumn(colModel.get(i).getColDesc());
        }
    }
    private void setColWidth(){
        for (int i=0;i<colModel.size();i++){
            if (colModel.get(i).getColWidth()>0){
                setColumnWidth(i,colModel.get(i).getColWidth());
            }
        }
    }
    
    public void retrieveData () {
        field = colModel.get(jcmbField.getSelectedIndex()).getColName();
        operator = jcmbOperator.getSelectedItem()+"";
        value = jtxtValue.getText();                 
        if (operator.equalsIgnoreCase("like")) value = "%" + value + "%";
        sort = jchkDesc.isSelected() ? "Desc" : "Asc";    
       
        clearData();
    }
    
    protected void setColumnWidth(Integer ColumnIdx,Integer Width){
       TableColumn column=jtblBrowse.getColumnModel().getColumn(ColumnIdx);
       column.setMinWidth(0);
       column.setMaxWidth(Width);
       column.setPreferredWidth(Width);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnSelect = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jlblRecordsFound = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcmbOperator = new javax.swing.JComboBox();
        jcmbField = new javax.swing.JComboBox();
        btnsearch = new javax.swing.JButton();
        jtxtValue = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblBrowse = new javax.swing.JTable();
        jbtnMore = new javax.swing.JButton();
        jchkDesc = new javax.swing.JCheckBox();
        jchkAutoFind = new javax.swing.JCheckBox();
        jtxtRecordFound = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jbtnSelect.setText("Select");
        jbtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jlblRecordsFound.setText("Number of Records Found : ");

        jLabel1.setText("Search In Field");

        jLabel2.setText("Seach Methode");

        jcmbOperator.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "like", "=", ">", "<" }));

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jtxtValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtValueActionPerformed(evt);
            }
        });
        jtxtValue.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtxtValuePropertyChange(evt);
            }
        });
        jtxtValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtValueKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtValueKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtValueKeyTyped(evt);
            }
        });
        jtxtValue.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtxtValueVetoableChange(evt);
            }
        });

        jLabel3.setText("Search Key");

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        jtblBrowse.setAutoCreateRowSorter(true);
        jtblBrowse.setModel(tmodel);
        jtblBrowse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtblBrowse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBrowseMouseClicked(evt);
            }
        });
        jtblBrowse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtblBrowseKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblBrowse);

        jbtnMore.setText("More");
        jbtnMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMoreActionPerformed(evt);
            }
        });

        jchkDesc.setSelected(true);
        jchkDesc.setText("Desc");

        jchkAutoFind.setSelected(true);
        jchkAutoFind.setText("Auto");

        jtxtRecordFound.setEditable(false);
        jtxtRecordFound.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jbtnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblRecordsFound)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtRecordFound, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(jbtnMore))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtValue, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcmbField, javax.swing.GroupLayout.Alignment.LEADING, 0, 172, Short.MAX_VALUE)
                                    .addComponent(jcmbOperator, 0, 172, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jchkDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jchkAutoFind, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnsearch))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcmbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchkDesc)
                    .addComponent(jchkAutoFind))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcmbOperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSelect)
                    .addComponent(jbtnCancel)
                    .addComponent(jlblRecordsFound)
                    .addComponent(jbtnMore)
                    .addComponent(jtxtRecordFound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectActionPerformed
      selectRow();
}//GEN-LAST:event_jbtnSelectActionPerformed


protected void selectRow() {
   Integer irow;
       
   if (jtblBrowse.getRowCount()>0){
      irow=jtblBrowse.getSelectedRow();
      if (irow<0){
          irow=0;
       } 
              
      if (jtableparam != null) {
        jtableparam.setValueAt(tmodel.getValueAt(irow,0).toString(), rowtable1, coltable1);             
      }else if (tmodelparam != null) {
        if (replace) {
            tmodelparam.setValueAt(tmodel.getValueAt(irow,0).toString(), rowtable1, coltable1);
        }else {
            if(tmodelparam.getValueAt(rowtable1, coltable1) == null || tmodelparam.getValueAt(rowtable1, coltable1).equals("")){
                tmodelparam.setValueAt(tmodel.getValueAt(irow,0).toString(), rowtable1, coltable1);                
            } else {
                tmodelparam.setValueAt(tmodelparam.getValueAt(rowtable1, coltable1) + ";" + tmodel.getValueAt(irow,0).toString(), rowtable1, coltable1);                                
            }            
        }
        
      }else{
           if (first != null ) {
               first.setText(tmodel.getValueAt(irow,0).toString());
           }
           if (second != null ) {
               second.setText(tmodel.getValueAt(irow,1).toString());
           }

           if (tmodel.getColumnCount() > 2) {
               if (third != null) {
                    third.setText(tmodel.getValueAt(irow,2).toString());
               } 
               if (fourth != null) {
                   fourth.setText(tmodel.getValueAt(irow,3).toString());
               }
           }
      }
   }

   setVisible(false); 

}
private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    setVisible(false); 
}//GEN-LAST:event_jbtnCancelActionPerformed

private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed

            retrieveData();//GEN-LAST:event_btnsearchActionPerformed
  
}

private void jtxtValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtValueActionPerformed

}//GEN-LAST:event_jtxtValueActionPerformed

private void jtxtValuePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtxtValuePropertyChange

    

}//GEN-LAST:event_jtxtValuePropertyChange

private void jtxtValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtValueKeyPressed

   if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        retrieveData();                                         
   }
}//GEN-LAST:event_jtxtValueKeyPressed

private void jtxtValueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtValueKeyReleased
    if(jchkAutoFind.isSelected() && !jtxtValue.getText().trim().equals("") ) {
        retrieveData();                                         
    }
}//GEN-LAST:event_jtxtValueKeyReleased

private void jtxtValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtValueKeyTyped

}//GEN-LAST:event_jtxtValueKeyTyped

private void jtxtValueVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtxtValueVetoableChange

}//GEN-LAST:event_jtxtValueVetoableChange

private void jtblBrowseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblBrowseMouseClicked
    
      if (evt.getClickCount() == 2){
         selectRow();
      }
    
}//GEN-LAST:event_jtblBrowseMouseClicked

private void jtblBrowseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblBrowseKeyPressed

}//GEN-LAST:event_jtblBrowseKeyPressed

private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed

}//GEN-LAST:event_jScrollPane1KeyPressed

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    this.setLocationRelativeTo(null);
    
}//GEN-LAST:event_formWindowOpened

private void jbtnMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMoreActionPerformed

    firstresult = firstresult + 100;
    this.retrieveData();

}//GEN-LAST:event_jbtnMoreActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBrowse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JButton jbtnCancel;
    protected javax.swing.JButton jbtnMore;
    protected javax.swing.JButton jbtnSelect;
    protected javax.swing.JCheckBox jchkAutoFind;
    protected javax.swing.JCheckBox jchkDesc;
    protected javax.swing.JComboBox jcmbField;
    protected javax.swing.JComboBox jcmbOperator;
    public javax.swing.JLabel jlblRecordsFound;
    public javax.swing.JTable jtblBrowse;
    protected javax.swing.JTextField jtxtRecordFound;
    protected javax.swing.JTextField jtxtValue;
    // End of variables declaration//GEN-END:variables

    protected void clearData() {
        int row = tmodel.getRowCount();			
        while(row > 0){	
            row--;				
            tmodel.removeRow(row);
        }	
          
    }

}
