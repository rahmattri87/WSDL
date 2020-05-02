package apppenjualan.data;

import apppenjualan.data.Fakturdetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-02T12:18:07")
@StaticMetamodel(Barang.class)
public class Barang_ { 

    public static volatile SingularAttribute<Barang, String> namabarang;
    public static volatile SingularAttribute<Barang, Double> hargaStandard;
    public static volatile SingularAttribute<Barang, String> kodebarang;
    public static volatile CollectionAttribute<Barang, Fakturdetail> fakturdetailCollection;
    public static volatile SingularAttribute<Barang, Integer> stok;

}