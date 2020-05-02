package apppenjualan.control; 
 
import apppenjualan.data.Barang; 
import java.io.Serializable; 
import javax.persistence.Query; 
import javax.persistence.EntityNotFoundException; 
import javax.persistence.criteria.CriteriaQuery; 
import javax.persistence.criteria.Root; 
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
 
public class BarangController implements Serializable { 
    public BarangController(EntityManagerFactory emf) { 
        this.emf = emf; 
    } 
    private EntityManagerFactory emf = null; 
 
    public EntityManager getEntityManager() { 
	return emf.createEntityManager(); 
    } 
 
    public void create(Barang barang) throws Exception { 
	EntityManager em = null; 
	try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.persist(barang); 
            em.getTransaction().commit(); 
	} catch (Exception ex) { 
            if (findBarang(barang.getKodebarang()) != null) { 
                throw new Exception("Barang " + barang + " already exists.", ex); 
            } 
            throw ex; 
	} finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    }
	
    public void edit(Barang barang) throws Exception { 
        EntityManager em = null; 
	try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.merge(barang); 
            em.getTransaction().commit(); 
        } catch (Exception ex) { 
            String msg = ex.getLocalizedMessage(); 
            if (msg == null || msg.length() == 0) { 
                String id = barang.getKodebarang(); 
		if (findBarang(id) == null) { 
                    throw new Exception("The barang with id " + id + " no longer exists."); 
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
            Barang barang; 
            try { 
		barang = em.getReference(Barang.class, id); 
		barang.getKodebarang(); 
            } catch (EntityNotFoundException enfe) { 
		throw new Exception("The barang with id " + id + " no longer exists.", enfe); 
            } 
            em.remove(barang); 
            em.getTransaction().commit(); 
	} finally { 
            if (em != null) { 
		em.close(); 
            } 
	} 
    }

    public Barang findBarang(String id) { 
        EntityManager em = getEntityManager(); 
        try { 
            return em.find(Barang.class, id); 
        } finally { 
            em.close(); 
        } 
    } 
}