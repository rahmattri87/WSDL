/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pakeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class Koneksi {

    private String dbuser="root";
    private String dbpasswd="P@ssw0rd";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;

    public Koneksi(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
    }

    catch(Exception e){
        JOptionPane.showMessageDialog(null, ""+e.getMessage(),"JDBC Driver Error",JOptionPane.WARNING_MESSAGE);
    }

    try {
        con= DriverManager.getConnection("jdbc:mysql://localhost/penjualan",dbuser,dbpasswd);
        stmt = con.createStatement();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, ""+e.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
        }
    }

    public ResultSet getData (String SQLString){

    try{
       rs = stmt.executeQuery(SQLString);

    }

    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "Error:"+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
    }

    return rs;
    }

    public int query(String SQLString)
    {
        int i=0;
        try{
           stmt.executeUpdate(SQLString);
           i=1;
        }

        catch (Exception e)
        {
            JOptionPane.showMessageDialog (null,"Error:"+e.getMessage(),"Communication Error",JOptionPane.WARNING_MESSAGE);
        }
        return i;
    }

}