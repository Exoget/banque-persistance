
package fr.eni.mvnbook.banque.ws.client.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.eni.mvnbook.banque.ws.client.proxy package. 
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

    private final static QName _BanqueException_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "BanqueException");
    private final static QName _Virement_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "virement");
    private final static QName _Auth_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "auth");
    private final static QName _VirementResponse_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "virementResponse");
    private final static QName _Comptes_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "comptes");
    private final static QName _ComptesResponse_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "comptesResponse");
    private final static QName _AuthResponse_QNAME = new QName("http://www.eni.fr/ws/mvnbook/banque-webservice", "authResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.eni.mvnbook.banque.ws.client.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthResponse }
     * 
     */
    public AuthResponse createAuthResponse() {
        return new AuthResponse();
    }

    /**
     * Create an instance of {@link Comptes }
     * 
     */
    public Comptes createComptes() {
        return new Comptes();
    }

    /**
     * Create an instance of {@link ComptesResponse }
     * 
     */
    public ComptesResponse createComptesResponse() {
        return new ComptesResponse();
    }

    /**
     * Create an instance of {@link Auth }
     * 
     */
    public Auth createAuth() {
        return new Auth();
    }

    /**
     * Create an instance of {@link VirementResponse }
     * 
     */
    public VirementResponse createVirementResponse() {
        return new VirementResponse();
    }

    /**
     * Create an instance of {@link Virement }
     * 
     */
    public Virement createVirement() {
        return new Virement();
    }

    /**
     * Create an instance of {@link BanqueException }
     * 
     */
    public BanqueException createBanqueException() {
        return new BanqueException();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Compte }
     * 
     */
    public Compte createCompte() {
        return new Compte();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BanqueException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "BanqueException")
    public JAXBElement<BanqueException> createBanqueException(BanqueException value) {
        return new JAXBElement<BanqueException>(_BanqueException_QNAME, BanqueException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Virement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "virement")
    public JAXBElement<Virement> createVirement(Virement value) {
        return new JAXBElement<Virement>(_Virement_QNAME, Virement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Auth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "auth")
    public JAXBElement<Auth> createAuth(Auth value) {
        return new JAXBElement<Auth>(_Auth_QNAME, Auth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VirementResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "virementResponse")
    public JAXBElement<VirementResponse> createVirementResponse(VirementResponse value) {
        return new JAXBElement<VirementResponse>(_VirementResponse_QNAME, VirementResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Comptes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "comptes")
    public JAXBElement<Comptes> createComptes(Comptes value) {
        return new JAXBElement<Comptes>(_Comptes_QNAME, Comptes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComptesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "comptesResponse")
    public JAXBElement<ComptesResponse> createComptesResponse(ComptesResponse value) {
        return new JAXBElement<ComptesResponse>(_ComptesResponse_QNAME, ComptesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.eni.fr/ws/mvnbook/banque-webservice", name = "authResponse")
    public JAXBElement<AuthResponse> createAuthResponse(AuthResponse value) {
        return new JAXBElement<AuthResponse>(_AuthResponse_QNAME, AuthResponse.class, null, value);
    }

}
