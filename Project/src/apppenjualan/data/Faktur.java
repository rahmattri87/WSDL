/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gxry
 */
@Entity
@Table(name = "faktur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faktur.findAll", query = "SELECT f FROM Faktur f"),
    @NamedQuery(name = "Faktur.findByNomorFaktur", query = "SELECT f FROM Faktur f WHERE f.nomorFaktur = :nomorFaktur"),
    @NamedQuery(name = "Faktur.findByTanggalFaktur", query = "SELECT f FROM Faktur f WHERE f.tanggalFaktur = :tanggalFaktur")})
public class Faktur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomorFaktur")
    private String nomorFaktur;
    @Column(name = "TanggalFaktur")
    @Temporal(TemporalType.DATE)
    private Date tanggalFaktur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomorFaktur")
    private Collection<Fakturdetail> fakturdetailCollection;
    @OneToMany(mappedBy = "nomorFaktur")
    private Collection<Kwitansi> kwitansiCollection;
    @JoinColumn(name = "KodePelanggan", referencedColumnName = "kodepelanggan")
    @ManyToOne
    private Pelanggan kodePelanggan;

    public Faktur() {
    }

    public Faktur(String nomorFaktur) {
        this.nomorFaktur = nomorFaktur;
    }

    public String getNomorFaktur() {
        return nomorFaktur;
    }

    public void setNomorFaktur(String nomorFaktur) {
        this.nomorFaktur = nomorFaktur;
    }

    public Date getTanggalFaktur() {
        return tanggalFaktur;
    }

    public void setTanggalFaktur(Date tanggalFaktur) {
        this.tanggalFaktur = tanggalFaktur;
    }

    @XmlTransient
    public Collection<Fakturdetail> getFakturdetailCollection() {
        return fakturdetailCollection;
    }

    public void setFakturdetailCollection(Collection<Fakturdetail> fakturdetailCollection) {
        this.fakturdetailCollection = fakturdetailCollection;
    }

    @XmlTransient
    public Collection<Kwitansi> getKwitansiCollection() {
        return kwitansiCollection;
    }

    public void setKwitansiCollection(Collection<Kwitansi> kwitansiCollection) {
        this.kwitansiCollection = kwitansiCollection;
    }

    public Pelanggan getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(Pelanggan kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomorFaktur != null ? nomorFaktur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faktur)) {
            return false;
        }
        Faktur other = (Faktur) object;
        if ((this.nomorFaktur == null && other.nomorFaktur != null) || (this.nomorFaktur != null && !this.nomorFaktur.equals(other.nomorFaktur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apppenjualan.data.Faktur[ nomorFaktur=" + nomorFaktur + " ]";
    }
    
}
