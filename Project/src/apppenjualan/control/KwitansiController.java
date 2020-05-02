package apppenjualan.control; 
 
import apppenjualan.data.Barang;
import java.io.Serializable; 
import javax.persistence.Query; 
import javax.persistence.EntityNotFoundException; 
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root; 
import apppenjualan.data.Faktur; 
import apppenjualan.data.Kwitansi; 
import java.text.DecimalFormat;
import java.util.List; 
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.swing.JOptionPane;
 
public class KwitansiController implements Serializable { 
    
    public KwitansiController(EntityManagerFactory emf) { 
        this.emf = emf; 
    } 
    private EntityManagerFactory emf = null; 
 
    public EntityManager getEntityManager() { 
        return emf.createEntityManager(); 
    } 
 
    public void create(Kwitansi kwitansi) throws Exception { 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.persist(kwitansi); 
            em.getTransaction().commit(); 
        } catch (Exception ex) { 
            if (findKwitansi(kwitansi.getNomorKwitansi())!=null) { 
                throw new Exception("Kwitansi " + kwitansi + " already exists.", ex); 
            } 
            throw ex; 
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    } 
 
    public void edit(Kwitansi kwitansi) throws Exception { 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            em.getTransaction().begin(); 
            em.merge(kwitansi); 
            em.getTransaction().commit(); 
        } catch (Exception ex) { 
            String msg = ex.getLocalizedMessage(); 
            if (msg == null || msg.length() == 0) { 
                String id = kwitansi.getNomorKwitansi(); 
                if (findKwitansi(id) == null) { 
                    throw new Exception("The kwitansi with id " + id + " no longer exists."); 
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
            Kwitansi kwitansi; 
            try { 
                kwitansi = em.getReference(Kwitansi.class, id); 
                kwitansi.getNomorKwitansi(); 
            } catch (EntityNotFoundException enfe) { 
                throw new Exception("The kwitansi with id " + id + " no longer exists.", enfe); 
            } 
            Faktur nomorFaktur = kwitansi.getNomorFaktur(); 
            if (nomorFaktur != null) {    
                nomorFaktur.getKwitansiCollection().remove(kwitansi); 
                nomorFaktur = em.merge(nomorFaktur); 
            } 
            em.remove(kwitansi); 
            em.getTransaction().commit(); 
        } finally { 
            if (em != null) { 
                em.close(); 
            } 
        } 
    } 
 
    public List<Kwitansi> findKwitansiEntities() { 
        return findKwitansiEntities(true, -1, -1); 
    } 
 
    public List<Kwitansi> findKwitansiEntities(int maxResults, int firstResult) { 
        return findKwitansiEntities(false, maxResults, firstResult); 
    } 
 
    private List<Kwitansi> findKwitansiEntities(boolean all, int maxResults, int firstResult) { 
        EntityManager em = getEntityManager(); 
        try { 
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); 
            cq.select(cq.from(Kwitansi.class)); 
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
 
    public Kwitansi findKwitansi(String id) { 
        EntityManager em = getEntityManager(); 
        try { 
            return em.find(Kwitansi.class, id); 
        } finally { 
            em.close(); 
        } 
    } 
 
    public int getKwitansiCount() { 
        EntityManager em = getEntityManager(); 
        try { 
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery(); 
            Root<Kwitansi> rt = cq.from(Kwitansi.class); 
            cq.select(em.getCriteriaBuilder().count(rt)); 
            Query q = em.createQuery(cq); 
            return ((Long) q.getSingleResult()).intValue(); 
        } finally { 
            em.close(); 
        } 
    } 
     
    public String createNomorKwitansi() { 
        String nomorkwitansi = "K0001"; 
        EntityManager em = null;  
        try { 
            em = getEntityManager(); 
            Query q = em.createQuery("SELECT k FROM Kwitansi k Order By k.nomorKwitansi Desc"); 
            q.setMaxResults(1); 
            Kwitansi k = (Kwitansi) q.getSingleResult(); 
            
            if (k != null){ 
                DecimalFormat nfK0000 = new DecimalFormat("K0000"); 
                String nomor =  k.getNomorKwitansi().substring(1); 
                nomorkwitansi = nfK0000.format(Double.parseDouble(nomor) + 1); 
            } 
        } catch (Exception e){
            e.printStackTrace();
        } finally { 
            em.close();
        } 
         
        return nomorkwitansi; 
    } 
    
    public boolean checkNomorFaktur(Faktur f) { 
        boolean cek = false; 
        EntityManager em = null; 
        try { 
            em = getEntityManager(); 
            Query q = em.createQuery("SELECT k FROM Kwitansi k where k.nomorFaktur = :nomorFaktur"); 
            q.setParameter("nomorFaktur", f); //jalankan
            //untuk parameter f, perlu dirubah jadi k gak Pak? nga lah itu khan dipakai di baris 174
            //oh, itu parameter in dari method ya Pak? :D yup
            //program saya saya rubah dulu aslinya .. makasih atas temuan errornya
            //sama2 Pak, terima kasih ya.. :D
            
            Kwitansi k = (Kwitansi) q.getSingleResult(); 
            
            if (k != null){ 
                cek = true; 
            } else {
                cek = false;
            }
        } catch(Exception e) { 
            //cek = false; 
            e.printStackTrace(); //cobajalankan
        } finally { 
            em.close(); 
        } 
         
        return cek; 
    } 
}