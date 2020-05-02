package apppenjualan.control; 
 
import apppenjualan.data.Barang;
import apppenjualan.data.Faktur; 
import java.io.Serializable; 
import javax.persistence.Query; 
import javax.persistence.EntityNotFoundException; 
import javax.persistence.criteria.CriteriaQuery; 
import javax.persistence.criteria.Root; 
import apppenjualan.data.Fakturdetail; 
import java.text.DecimalFormat; 
import java.util.Collection; 
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
 
public class FakturController implements Serializable { 
 
    public FakturController(EntityManagerFactory emf) { 
        this.emf = emf; 
    } 
    private EntityManagerFactory emf = null; 
 
    public EntityManager getEntityManager() { 
        return emf.createEntityManager(); 
    }
    
    public void create(Faktur faktur) throws Exception { 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.persist(faktur); 
            
            Collection<Fakturdetail> lstfakturdetail = faktur.getFakturdetailCollection(); 
            for (Fakturdetail fd : lstfakturdetail) { 
                em.persist(fd); 
                //kurangi stok barang dari transaksi 
                Barang brg = fd.getKodeBarang(); 
                if (brg != null) { 
                    brg.setStok(brg.getStok() - fd.getQty()); 
                    em.merge(brg); 
                } 
            } 
            
            em.getTransaction().commit();  
        } catch (Exception ex) { 
            if (findFaktur(faktur.getNomorFaktur()) != null) { 
                throw new Exception("Faktur " + faktur + " already exists.", ex); 
            } 
            throw ex; 
        } finally { 
            if (em != null) {
                em.close(); 
            } 
        } 
    }
    
    public void edit(Faktur faktur) throws Exception { 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 

            //stok barang  
            Faktur ffind = findFaktur(faktur.getNomorFaktur()); 
            if (ffind != null) { 
                for (Fakturdetail fdfind : ffind.getFakturdetailCollection()) { 
                    //Tambahin Stok Barang dari data sebelumnya 
                    Barang brg = fdfind.getKodeBarang(); 
                    if (brg != null) { 
                        brg.setStok(brg.getStok() + fdfind.getQty()); 
                        em.merge(brg); 
                    } 
                } 
            } 
            
            em.merge(faktur); 
            
            Collection<Fakturdetail> lstfakturdetail = faktur.getFakturdetailCollection(); 
            for (Fakturdetail fd : lstfakturdetail) { 
                //Kurangin Stok Barang dari Transaksi 
                Barang brg = em.find(Barang.class,  
                fd.getKodeBarang().getKodebarang()); 
                brg.setStok(brg.getStok() - fd.getQty()); 
                
                em.merge(brg); 
                if (fd.getId() != null) { 
                    em.merge(fd);          
                } else { 
                    em.persist(fd); 
                } 
            } 
             
            em.getTransaction().commit(); 
        } catch (Exception ex) { 
            String msg = ex.getLocalizedMessage(); 
            if (msg == null || msg.length() == 0) { 
                String id = faktur.getNomorFaktur(); 
                if (findFaktur(id) == null) { 
                    throw new Exception("The faktur with id " + id + " no longer exists."); 
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
            Faktur faktur; 
            try { 
                faktur = em.getReference(Faktur.class, id); 
                faktur.getNomorFaktur(); 
            } catch (EntityNotFoundException enfe) { 
                throw new Exception("The faktur with id " + id + " no longer exists.", enfe); 
            } 
            em.remove(faktur); 
            
            Collection<Fakturdetail> lstfakturdetail = faktur.getFakturdetailCollection(); 
            for (Fakturdetail fd : lstfakturdetail) { 
                Barang brg = fd.getKodeBarang(); 
                brg.setStok(brg.getStok() + fd.getQty()); 
                em.remove(fd);                 
            } 
            
            em.getTransaction().commit(); 
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    }
    
    public List<Faktur> findFakturEntities() { 
        return findFakturEntities(true, -1, -1); 
    } 
 
    public List<Faktur> findFakturEntities (int maxResults, int firstResult) { 
        return findFakturEntities (false, maxResults, firstResult); 
    }
    
    private List<Faktur> findFakturEntities(boolean all, int maxResults, int firstResult) { 
        EntityManager em = getEntityManager(); 
        try { 
            CriteriaQuery cq =  
            em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Faktur.class)); 
            Query q = em.createQuery(cq); 
            if (!all) { 
                q.setMaxResults(maxResults); 
                q.setFirstResult(firstResult); 
            } 
            return q.getResultList(); 
        } finally { 
            em.close(); 
        } 
    }
    
    public Faktur findFaktur(String id) { 
        EntityManager em = getEntityManager(); 
        try { 
            return em.find(Faktur.class, id); 
        } finally { 
            em.close(); 
        } 
    } 
 
    public int getFakturCount() { 
        EntityManager em = getEntityManager(); 
        try { 
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); 
            Root<Faktur> rt = cq.from(Faktur.class); 
            cq.select(em.getCriteriaBuilder().count(rt)); 
            Query q = em.createQuery(cq); 
            return ((Long) q.getSingleResult()).intValue(); 
        } finally { 
            em.close(); 
        } 
    }
    
    public String createNomorFaktur() { 
        String nomorfaktur = "F0001"; 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            Query q = em.createQuery ("SELECT f FROM Faktur f Order By f.nomorFaktur Desc "); 
 
            q.setMaxResults(1); 
            Faktur f = (Faktur) q.getSingleResult(); 
            
            if (f != null){ 
                DecimalFormat nfF0000 = new DecimalFormat("F0000"); 
                String nomor =  f.getNomorFaktur().substring(1); 
                nomorfaktur = nfF0000.format(Double.parseDouble(nomor) + 1); 
             }
        } finally { 
            em.close(); 
        }         
        return nomorfaktur; 
    } 
    
    
}