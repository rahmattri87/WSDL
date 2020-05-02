package apppenjualan.data;

import apppenjualan.data.Barang;
import apppenjualan.data.Faktur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-02T12:18:07")
@StaticMetamodel(Fakturdetail.class)
public class Fakturdetail_ { 

    public static volatile SingularAttribute<Fakturdetail, Integer> id;
    public static volatile SingularAttribute<Fakturdetail, Faktur> nomorFaktur;
    public static volatile SingularAttribute<Fakturdetail, Barang> kodeBarang;
    public static volatile SingularAttribute<Fakturdetail, Integer> qty;
    public static volatile SingularAttribute<Fakturdetail, Double> harga;

}