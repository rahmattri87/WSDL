package apppenjualan; 
 
import apppenjualan.form.FrmMain; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence; 
 
public class AppPenjualan { 
 
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("appPenjualanPU"); 
    public static void main(String[] args) { 
        new FrmMain().setVisible(true); 
    } 
    
}