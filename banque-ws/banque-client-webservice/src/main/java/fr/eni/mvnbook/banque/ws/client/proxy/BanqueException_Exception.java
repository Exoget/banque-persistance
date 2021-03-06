
package fr.eni.mvnbook.banque.ws.client.proxy;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "BanqueException", targetNamespace = "http://www.eni.fr/ws/mvnbook/banque-webservice")
public class BanqueException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private BanqueException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public BanqueException_Exception(String message, BanqueException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public BanqueException_Exception(String message, BanqueException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: fr.eni.mvnbook.banque.ws.client.proxy.BanqueException
     */
    public BanqueException getFaultInfo() {
        return faultInfo;
    }

}
