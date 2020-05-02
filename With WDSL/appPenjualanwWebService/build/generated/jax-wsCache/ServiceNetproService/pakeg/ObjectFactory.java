
package pakeg;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pakeg package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cari_QNAME = new QName("http://pakeg/", "cari");
    private final static QName _Coba_QNAME = new QName("http://pakeg/", "coba");
    private final static QName _Login_QNAME = new QName("http://pakeg/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://pakeg/", "loginResponse");
    private final static QName _CobaResponse_QNAME = new QName("http://pakeg/", "cobaResponse");
    private final static QName _CariResponse_QNAME = new QName("http://pakeg/", "cariResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pakeg
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Coba }
     * 
     */
    public Coba createCoba() {
        return new Coba();
    }

    /**
     * Create an instance of {@link CobaResponse }
     * 
     */
    public CobaResponse createCobaResponse() {
        return new CobaResponse();
    }

    /**
     * Create an instance of {@link CariResponse }
     * 
     */
    public CariResponse createCariResponse() {
        return new CariResponse();
    }

    /**
     * Create an instance of {@link Cari }
     * 
     */
    public Cari createCari() {
        return new Cari();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cari }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pakeg/", name = "cari")
    public JAXBElement<Cari> createCari(Cari value) {
        return new JAXBElement<Cari>(_Cari_QNAME, Cari.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Coba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pakeg/", name = "coba")
    public JAXBElement<Coba> createCoba(Coba value) {
        return new JAXBElement<Coba>(_Coba_QNAME, Coba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pakeg/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pakeg/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CobaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pakeg/", name = "cobaResponse")
    public JAXBElement<CobaResponse> createCobaResponse(CobaResponse value) {
        return new JAXBElement<CobaResponse>(_CobaResponse_QNAME, CobaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CariResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pakeg/", name = "cariResponse")
    public JAXBElement<CariResponse> createCariResponse(CariResponse value) {
        return new JAXBElement<CariResponse>(_CariResponse_QNAME, CariResponse.class, null, value);
    }

}
