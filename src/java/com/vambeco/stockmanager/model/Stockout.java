/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vambeco.stockmanager.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Allen
 */
@Entity
@Table(name = "stockout")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockout.findAll", query = "SELECT s FROM Stockout s"),
    @NamedQuery(name = "Stockout.findByStockOutId", query = "SELECT s FROM Stockout s WHERE s.stockOutId = :stockOutId"),
    @NamedQuery(name = "Stockout.findByQuantity", query = "SELECT s FROM Stockout s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Stockout.findByVehicleNumber", query = "SELECT s FROM Stockout s WHERE s.vehicleNumber = :vehicleNumber"),
    @NamedQuery(name = "Stockout.findByRemarks", query = "SELECT s FROM Stockout s WHERE s.remarks = :remarks"),
    @NamedQuery(name = "Stockout.findByDeliveryNoteNumber", query = "SELECT s FROM Stockout s WHERE s.deliveryNoteNumber = :deliveryNoteNumber"),
    @NamedQuery(name = "Stockout.findByAutostamp", query = "SELECT s FROM Stockout s WHERE s.autostamp = :autostamp")})
public class Stockout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stockOutId")
    private Integer stockOutId;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 20)
    @Column(name = "vehicleNumber")
    private String vehicleNumber;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @Size(max = 45)
    @Column(name = "deliveryNoteNumber")
    private String deliveryNoteNumber;
    @Column(name = "autostamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autostamp;
    @JoinColumn(name = "issuedby_userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User issuedbyuserId;
    @JoinColumn(name = "despatchedby_userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User despatchedbyuserId;
    @JoinColumn(name = "takento_siteId", referencedColumnName = "siteId")
    @ManyToOne(optional = false)
    private Site takentositeId;
    @JoinColumn(name = "itemdescriptionId", referencedColumnName = "itemdescriptionId")
    @ManyToOne(optional = false)
    private Itemdescription itemdescriptionId;

    public Stockout() {
    }

    public Stockout(Integer stockOutId) {
        this.stockOutId = stockOutId;
    }

    public Integer getStockOutId() {
        return stockOutId;
    }

    public void setStockOutId(Integer stockOutId) {
        this.stockOutId = stockOutId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDeliveryNoteNumber() {
        return deliveryNoteNumber;
    }

    public void setDeliveryNoteNumber(String deliveryNoteNumber) {
        this.deliveryNoteNumber = deliveryNoteNumber;
    }

    public Date getAutostamp() {
        return autostamp;
    }

    public void setAutostamp(Date autostamp) {
        this.autostamp = autostamp;
    }

    public User getIssuedbyuserId() {
        return issuedbyuserId;
    }

    public void setIssuedbyuserId(User issuedbyuserId) {
        this.issuedbyuserId = issuedbyuserId;
    }

    public User getDespatchedbyuserId() {
        return despatchedbyuserId;
    }

    public void setDespatchedbyuserId(User despatchedbyuserId) {
        this.despatchedbyuserId = despatchedbyuserId;
    }

    public Site getTakentositeId() {
        return takentositeId;
    }

    public void setTakentositeId(Site takentositeId) {
        this.takentositeId = takentositeId;
    }

    public Itemdescription getItemdescriptionId() {
        return itemdescriptionId;
    }

    public void setItemdescriptionId(Itemdescription itemdescriptionId) {
        this.itemdescriptionId = itemdescriptionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockOutId != null ? stockOutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockout)) {
            return false;
        }
        Stockout other = (Stockout) object;
        if ((this.stockOutId == null && other.stockOutId != null) || (this.stockOutId != null && !this.stockOutId.equals(other.stockOutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vambeco.stockmanager.model.Stockout[ stockOutId=" + stockOutId + " ]";
    }
    
}
