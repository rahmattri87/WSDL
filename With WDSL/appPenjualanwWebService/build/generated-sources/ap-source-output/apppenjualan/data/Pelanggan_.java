package apppenjualan.data;

import apppenjualan.data.Faktur;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-02T12:18:07")
@StaticMetamodel(Pelanggan.class)
public class Pelanggan_ { 

    public static volatile SingularAttribute<Pelanggan, String> namapelanggan;
    public static volatile SingularAttribute<Pelanggan, String> kodepelanggan;
    public static volatile SingularAttribute<Pelanggan, String> alamat;
    public static volatile CollectionAttribute<Pelanggan, Faktur> fakturCollection;

}