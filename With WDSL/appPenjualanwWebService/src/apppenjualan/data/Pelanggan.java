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
@Table(name = "pelanggan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelanggan.findAll", query = "SELECT p FROM Pelanggan p"),
    @NamedQuery(name = "Pelanggan.findByKodepelanggan", query = "SELECT p FROM Pelanggan p WHERE p.kodepelanggan = :kodepelanggan"),
    @NamedQuery(name = "Pelanggan.findByNamapelanggan", query = "SELECT p FROM Pelanggan p WHERE p.namapelanggan = :namapelanggan"),
    @NamedQuery(name = "Pelanggan.findByAlamat", query = "SELECT p FROM Pelanggan p WHERE p.alamat = :alamat")})
public class Pelanggan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kodepelanggan")
    private String kodepelanggan;
    @Column(name = "namapelanggan")
    private String namapelanggan;
    @Column(name = "Alamat")
    private String alamat;
    @OneToMany(mappedBy = "kodePelanggan")
    private Collection<Faktur> fakturCollection;

    public Pelanggan() {
    }

    public Pelanggan(String kodepelanggan) {
        this.kodepelanggan = kodepelanggan;
    }

    public String getKodepelanggan() {
        return kodepelanggan;
    }

    public void setKodepelanggan(String kodepelanggan) {
        this.kodepelanggan = kodepelanggan;
    }

    public String getNamapelanggan() {
        return namapelanggan;
    }

    public void setNamapelanggan(String namapelanggan) {
        this.namapelanggan = namapelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @XmlTransient
    public Collection<Faktur> getFakturCollection() {
        return fakturCollection;
    }

    public void setFakturCollection(Collection<Faktur> fakturCollection) {
        this.fakturCollection = fakturCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodepelanggan != null ? kodepelanggan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelanggan)) {
            return false;
        }
        Pelanggan other = (Pelanggan) object;
        if ((this.kodepelanggan == null && other.kodepelanggan != null) || (this.kodepelanggan != null && !this.kodepelanggan.equals(other.kodepelanggan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apppenjualan.data.Pelanggan[ kodepelanggan=" + kodepelanggan + " ]";
    }
    
}
