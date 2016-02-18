//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.16 at 09:22:35 PM MSK 
//


package ru.rushydro.vniig.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sensorInfoValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sensorInfoValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sensorId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sensorNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sensorParameter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sensorValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sensorInfoValue", propOrder = {
    "sensorId",
    "sensorNumber",
    "sensorParameter",
    "sensorValue"
})
public class SensorInfoValue {

    protected long sensorId;
    @XmlElement(required = true)
    protected String sensorNumber;
    @XmlElement(required = true)
    protected String sensorParameter;
    protected double sensorValue;

    /**
     * Gets the value of the sensorId property.
     * 
     */
    public long getSensorId() {
        return sensorId;
    }

    /**
     * Sets the value of the sensorId property.
     * 
     */
    public void setSensorId(long value) {
        this.sensorId = value;
    }

    /**
     * Gets the value of the sensorNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensorNumber() {
        return sensorNumber;
    }

    /**
     * Sets the value of the sensorNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensorNumber(String value) {
        this.sensorNumber = value;
    }

    /**
     * Gets the value of the sensorParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensorParameter() {
        return sensorParameter;
    }

    /**
     * Sets the value of the sensorParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensorParameter(String value) {
        this.sensorParameter = value;
    }

    /**
     * Gets the value of the sensorValue property.
     * 
     */
    public double getSensorValue() {
        return sensorValue;
    }

    /**
     * Sets the value of the sensorValue property.
     * 
     */
    public void setSensorValue(double value) {
        this.sensorValue = value;
    }

}
