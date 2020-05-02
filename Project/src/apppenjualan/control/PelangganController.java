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

    public PelangganController(EntityManagerFactory emf) { 
        this.emf = emf; 
    } 
    private EntityManagerFactory emf = null; 
 
    public EntityManager getEntityManager() { 
        return emf.createEntityManager(); 
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
}