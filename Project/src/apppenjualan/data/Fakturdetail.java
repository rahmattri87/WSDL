/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apppenjualan.data;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gxry
 */
@Entity
@Table(name = "fakturdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fakturdetail.findAll", query = "SELECT f FROM Fakturdetail f"),
    @NamedQuery(name = "Fakturdetail.findById", query = "SELECT f FROM Fakturdetail f WHERE f.id = :id"),
    @NamedQuery(name = "Fakturdetail.findByQty", query = "SELECT f FROM Fakturdetail f WHERE f.qty = :qty"),
    @NamedQuery(name = "Fakturdetail.findByHarga", query = "SELECT f FROM Fakturdetail f WHERE f.harga = :harga")})
public class Fakturdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Qty")
    private Integer qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Harga")
    private Double harga;
    @JoinColumn(name = "KodeBarang", referencedColumnName = "kodebarang")
    @ManyToOne(optional = false)
    private Barang kodeBarang;
    @JoinColumn(name = "NomorFaktur", referencedColumnName = "NomorFaktur")
    @ManyToOne(optional = false)
    private Faktur nomorFaktur;

    public Fakturdetail() {
    }

    public Fakturdetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Barang getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(Barang kodeBarang) {
        this.kodeBarang = kodeBarang;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fakturdetail)) {
            return false;
        }
        Fakturdetail other = (Fakturdetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "apppenjualan.data.Fakturdetail[ id=" + id + " ]";
    }
    
}
