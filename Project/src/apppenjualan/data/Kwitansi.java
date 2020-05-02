/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gxry
 */
@Entity
@Table(name = "kwitansi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kwitansi.findAll", query = "SELECT k FROM Kwitansi k"),
    @NamedQuery(name = "Kwitansi.findByNomorKwitansi", query = "SELECT k FROM Kwitansi k WHERE k.nomorKwitansi = :nomorKwitansi"),
    @NamedQuery(name = "Kwitansi.findByTanggalKwitansi", query = "SELECT k FROM Kwitansi k WHERE k.tanggalKwitansi = :tanggalKwitansi")})
public class Kwitansi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomorKwitansi")
    private String nomorKwitansi;
    @Column(name = "TanggalKwitansi")
    @Temporal(TemporalType.DATE)
    private Date tanggalKwitansi;
    @JoinColumn(name = "NomorFaktur", referencedColumnName = "NomorFaktur")
    @ManyToOne
    private Faktur nomorFaktur;

    public Kwitansi() {
    }

    public Kwitansi(String nomorKwitansi) {
        this.nomorKwitansi = nomorKwitansi;
    }

    public String getNomorKwitansi() {
        return nomorKwitansi;
    }

    public void setNomorKwitansi(String nomorKwitansi) {
        this.nomorKwitansi = nomorKwitansi;
    }

    public Date getTanggalKwitansi() {
        return tanggalKwitansi;
    }

    public void setTanggalKwitansi(Date tanggalKwitansi) {
        this.tanggalKwitansi = tanggalKwitansi;
    }

    public Faktur getNomorFaktur() {
        return nomorFaktur;
    }

    public void setNomorFaktur(Faktur nomorFaktur) {
        this.nomorFaktur = nomorFaktur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomorKwitansi != null ? nomorKwitansi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kwitansi)) {
            return false;
        }
        Kwitansi other = (Kwitansi) object;
        if ((this.nomorKwitansi == null && other.nomorKwitansi != null) || (this.nomorKwitansi != null && !this.nomorKwitansi.equals(other.nomorKwitansi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apppenjualan.data.Kwitansi[ nomorKwitansi=" + nomorKwitansi + " ]";
    }
    
}
