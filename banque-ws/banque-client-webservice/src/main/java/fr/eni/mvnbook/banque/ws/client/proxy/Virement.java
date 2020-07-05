
package fr.eni.mvnbook.banque.ws.client.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour virement complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="virement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "virement", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class Virement {

    protected long arg0;
    protected long arg1;
    protected double arg2;

    /**
     * Obtient la valeur de la propriété arg0.
     * 
     */
    public long getArg0() {
        return arg0;
    }

    /**
     * Définit la valeur de la propriété arg0.
     * 
     */
    public void setArg0(long value) {
        this.arg0 = value;
    }

    /**
     * Obtient la valeur de la propriété arg1.
     * 
     */
    public long getArg1() {
        return arg1;
    }

    /**
     * Définit la valeur de la propriété arg1.
     * 
     */
    public void setArg1(long value) {
        this.arg1 = value;
    }

    /**
     * Obtient la valeur de la propriété arg2.
     * 
     */
    public double getArg2() {
        return arg2;
    }

    /**
     * Définit la valeur de la propriété arg2.
     * 
     */
    public void setArg2(double value) {
        this.arg2 = value;
    }

}
