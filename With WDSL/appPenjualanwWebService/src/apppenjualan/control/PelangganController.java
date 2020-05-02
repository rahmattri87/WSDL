package apppenjualan.control; 
 
import java.io.Serializable; 
import javax.persistence.Query; 
import javax.persistence.EntityNotFoundException; 
import javax.persistence.criteria.CriteriaQuery; 
import javax.persistence.criteria.Root; 
import apppenjualan.data.Pelanggan; 
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
 
public class PelangganController implements Serializable { 
    private String[][] columns = {
        {"kodepelanggan", "Kode Pelanggan", "200"},
        {"namapelanggan", "Nama Pelanggan", "300"},
        {"alamat", "Alamat", "300"}
    };
    
    public PelangganController(EntityManagerFactory emf) { 
        this.emf = emf; 
    } 
    private EntityManagerFactory emf = null; 
 
    public EntityManager getEntityManager() { 
        return emf.createEntityManager(); 
    }
    public String[][] getColumns() {
        return columns;
    }
    public void create(Pelanggan pelanggan) throws Exception, Exception {
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.persist(pelanggan); 
            em.getTransaction().commit(); 
        } catch (Exception ex) { 
            if (findPelanggan(pelanggan.getKodepelanggan()) != null) { 
                throw new Exception("Pelanggan " + pelanggan + " already exists.", ex); 
            } 
            throw ex; 
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    }
    
    public void edit(Pelanggan pelanggan) throws Exception { 
        EntityManager em = null;
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.merge(pelanggan); 
            em.getTransaction().commit(); 
        } catch (Exception ex) { 
            String msg = ex.getLocalizedMessage(); 
            if (msg == null || msg.length() == 0) { 
                String id = pelanggan.getKodepelanggan(); 
                if (findPelanggan(id) == null) { 
                    throw new Exception("The pelanggan with id " + id + " no longer exists."); 
                } 
            } 
            throw ex; 
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    }
    
    public List<Pelanggan> findQuery(String field, String operator, String value, String orderby, String sort, int limit, int firstResult ){

        EntityManager em = getEntityManager();
        try{
            
            String sql = "select p from Pelanggan p where p." + field + " " + operator +  " '" + value + "' order by p." + orderby + " " + sort;
    
            //System.out.println(sql);
            Query qry = em.createQuery(sql);
            qry.setMaxResults(limit);
            qry.setFirstResult(firstResult);
            return qry.getResultList();
        }finally{
            em.close();
        }  
    }
    
    public void destroy(String id) throws Exception { 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            Pelanggan pelanggan; 
            try { 
                pelanggan = em.getReference(Pelanggan.class, id); 
                pelanggan.getKodepelanggan(); 
            } catch (EntityNotFoundException enfe) { 
                throw new Exception("The pelanggan with id " + id + " no longer exists.", enfe); 
            } 
            em.remove(pelanggan); 
            em.getTransaction().commit(); 
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    }
    
    public Pelanggan findPelanggan(String id) { 
        EntityManager em = getEntityManager(); 
        try { 
            return em.find(Pelanggan.class, id); 
        } finally { 
            em.close(); 
        } 
    }
    
    public Pelanggan moveFirst() {
        EntityManager em = getEntityManager();
        try {
            
            String sql = "select p from Pelanggan p order by p.kodepelanggan  ";
            Query qry = em.createQuery(sql);
            qry.setMaxResults(1);
            
            return (Pelanggan) qry.getSingleResult();            
        } finally {
            em.close();
        }
    }

    public Pelanggan moveLast() {
        EntityManager em = getEntityManager();
        try {
            
            String sql = "select p from Pelanggan p order by p.kodepelanggan  desc ";
            Query qry = em.createQuery(sql);
            qry.setMaxResults(1);
            
            return (Pelanggan) qry.getSingleResult();            
        } finally {
            em.close();
        }
    }
    
    public Pelanggan findQuerySingle(String field, String operator, String value, String orderby, String sort){
        EntityManager em = getEntityManager();
        try{
            String sql = "select p from Pelanggan p where p." + field + " " + operator +  " '" + value + "' order by p." + orderby + " " + sort;
    
            //System.out.println(sql);
            Query qry = em.createQuery(sql);
            qry.setMaxResults(1);
            return (Pelanggan) qry.getSingleResult();            
        } finally {
            em.close();
        }
    }
    
    public Pelanggan movePrevious(String value){
        Pelanggan brg = new Pelanggan();
        
        try {
            brg = findQuerySingle("kodepelanggan", "<", value, "kodepelanggan", "desc");
        } catch (Exception e) {
            brg = moveFirst();
        } 
        
        return brg;        
    }
    
    public Pelanggan moveNext(String value){
        Pelanggan brg = new Pelanggan();
        
        try {
            brg = findQuerySingle("kodepelanggan", ">", value, "kodepelanggan", "asc");
        } catch (Exception e) {
            brg = moveLast();
        } 
        
        return brg;        
    }
}