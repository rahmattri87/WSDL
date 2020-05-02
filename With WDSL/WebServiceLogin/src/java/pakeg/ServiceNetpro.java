/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pakeg;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Administrator
 */
@WebService()
public class ServiceNetpro {
private String[] data = new String[2];
    /**
     * Web service operation
     */
    @WebMethod(operationName = "coba")
    public String coba() {
        //TODO write your implementation code here:
        return "a";

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cari")
    public String[] cari(@WebParam(name = "nick") String nick) {
        Koneksi k = new Koneksi();
        ResultSet rs = null;
        String sql = "select * from daftarprofil where nickname='"+nick+"'";
        rs = k.getData(sql);
        try {
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                //data[2] = rs.getString(3);
                //data[3] = rs.getString(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNetpro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    @WebMethod(operationName = "login")
    public String[] login(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        Koneksi k = new Koneksi();
        ResultSet rs = null;
        //String sql = "select * from daftarprofil where nickname='"+nick+"'";
        String sql = "SELECT * FROM USER WHERE kd_user = '" + user + "' AND PASSWORD = '" + password  + "'";
        rs = k.getData(sql);
        try {
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNetpro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
