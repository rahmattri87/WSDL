package apppenjualan.data;

import apppenjualan.data.Fakturdetail;
import apppenjualan.data.Kwitansi;
import apppenjualan.data.Pelanggan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-02-01T13:13:54")
@StaticMetamodel(Faktur.class)
public class Faktur_ { 

    public static volatile SingularAttribute<Faktur, String> nomorFaktur;
    public static volatile CollectionAttribute<Faktur, Kwitansi> kwitansiCollection;
    public static volatile SingularAttribute<Faktur, Date> tanggalFaktur;
    public static volatile CollectionAttribute<Faktur, Fakturdetail> fakturdetailCollection;
    public static volatile SingularAttribute<Faktur, Pelanggan> kodePelanggan;

}