//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.12.03 at 10:55:57 p. m. GMT-06:00 
//


package com.examenws.bm.schema;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListVoParametrosProd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListVoParametrosProd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listParProdRs" type="{http://examenws.com/bm/schema}voParametrosProdRs" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListVoParametrosProd", propOrder = {
    "listParProdRs"
})
public class ListVoParametrosProd {

    protected List<VoParametrosProdRs> listParProdRs;

    /**
     * Gets the value of the listParProdRs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listParProdRs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListParProdRs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoParametrosProdRs }
     * 
     * 
     */
    public List<VoParametrosProdRs> getListParProdRs() {
        if (listParProdRs == null) {
            listParProdRs = new ArrayList<VoParametrosProdRs>();
        }
        return this.listParProdRs;
    }

}