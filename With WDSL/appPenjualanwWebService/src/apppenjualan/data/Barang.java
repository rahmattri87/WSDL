/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gxry
 */
@Entity
@Table(name = "barang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b"),
    @NamedQuery(name = "Barang.findByKodebarang", query = "SELECT b FROM Barang b WHERE b.kodebarang = :kodebarang"),
    @NamedQuery(name = "Barang.findByNamabarang", query = "SELECT b FROM Barang b WHERE b.namabarang = :namabarang"),
    @NamedQuery(name = "Barang.findByStok", query = "SELECT b FROM Barang b WHERE b.stok = :stok"),
    @NamedQuery(name = "Barang.findByHargaStandard", query = "SELECT b FROM Barang b WHERE b.hargaStandard = :hargaStandard")})
public class Barang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kodebarang")
    private String kodebarang;
    @Column(name = "namabarang")
    private String namabarang;
    @Column(name = "Stok")
    private Integer stok;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HargaStandard")
    private Double hargaStandard;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kodeBarang")
    private Collection<Fakturdetail> fakturdetailCollection;

    public Barang() {
    }

    public Barang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Double getHargaStandard() {
        return hargaStandard;
    }

    public void setHargaStandard(Double hargaStandard) {
        this.hargaStandard = hargaStandard;
    }

    @XmlTransient
    public Collection<Fakturdetail> getFakturdetailCollection() {
        return fakturdetailCollection;
    }

    public void setFakturdetailCollection(Collection<Fakturdetail> fakturdetailCollection) {
        this.fakturdetailCollection = fakturdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodebarang != null ? kodebarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.kodebarang == null && other.kodebarang != null) || (this.kodebarang != null && !this.kodebarang.equals(other.kodebarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apppenjualan.data.Barang[ kodebarang=" + kodebarang + " ]";
    }
    
}
