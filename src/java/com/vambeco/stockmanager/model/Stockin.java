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
@Table(name = "stockin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockin.findAll", query = "SELECT s FROM Stockin s"),
    @NamedQuery(name = "Stockin.findByStockInId", query = "SELECT s FROM Stockin s WHERE s.stockInId = :stockInId"),
    @NamedQuery(name = "Stockin.findByQuantity", query = "SELECT s FROM Stockin s WHERE s.quantity = :quantity"),
    @NamedQuery(name = "Stockin.findByRemarks", query = "SELECT s FROM Stockin s WHERE s.remarks = :remarks"),
    @NamedQuery(name = "Stockin.findByAutostamp", query = "SELECT s FROM Stockin s WHERE s.autostamp = :autostamp"),
    @NamedQuery(name = "Stockin.findByGoodsReceivedNoteNumber", query = "SELECT s FROM Stockin s WHERE s.goodsReceivedNoteNumber = :goodsReceivedNoteNumber")})
public class Stockin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stockInId")
    private Integer stockInId;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "autostamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autostamp;
    @Size(max = 45)
    @Column(name = "goodsReceivedNoteNumber")
    private String goodsReceivedNoteNumber;
    @JoinColumn(name = "receivedby_userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User receivedbyuserId;
    @JoinColumn(name = "deliveredby_userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private User deliveredbyuserId;
    @JoinColumn(name = "itemdescriptionId", referencedColumnName = "itemdescriptionId")
    @ManyToOne(optional = false)
    private Itemdescription itemdescriptionId;

    public Stockin() {
    }

    public Stockin(Integer stockInId) {
        this.stockInId = stockInId;
    }

    public Integer getStockInId() {
        return stockInId;
    }

    public void setStockInId(Integer stockInId) {
        this.stockInId = stockInId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getAutostamp() {
        return autostamp;
    }

    public void setAutostamp(Date autostamp) {
        this.autostamp = autostamp;
    }

    public String getGoodsReceivedNoteNumber() {
        return goodsReceivedNoteNumber;
    }

    public void setGoodsReceivedNoteNumber(String goodsReceivedNoteNumber) {
        this.goodsReceivedNoteNumber = goodsReceivedNoteNumber;
    }

    public User getReceivedbyuserId() {
        return receivedbyuserId;
    }

    public void setReceivedbyuserId(User receivedbyuserId) {
        this.receivedbyuserId = receivedbyuserId;
    }

    public User getDeliveredbyuserId() {
        return deliveredbyuserId;
    }

    public void setDeliveredbyuserId(User deliveredbyuserId) {
        this.deliveredbyuserId = deliveredbyuserId;
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
        hash += (stockInId != null ? stockInId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockin)) {
            return false;
        }
        Stockin other = (Stockin) object;
        if ((this.stockInId == null && other.stockInId != null) || (this.stockInId != null && !this.stockInId.equals(other.stockInId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vambeco.stockmanager.model.Stockin[ stockInId=" + stockInId + " ]";
    }
    
}
