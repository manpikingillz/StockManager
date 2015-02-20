/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vambeco.stockmanager.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Allen
 */
@Entity
@Table(name = "itemdescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemdescription.findAll", query = "SELECT i FROM Itemdescription i"),
    @NamedQuery(name = "Itemdescription.findByItemdescriptionId", query = "SELECT i FROM Itemdescription i WHERE i.itemdescriptionId = :itemdescriptionId"),
    @NamedQuery(name = "Itemdescription.findByItemSize", query = "SELECT i FROM Itemdescription i WHERE i.itemSize = :itemSize"),
    @NamedQuery(name = "Itemdescription.findByRemarks", query = "SELECT i FROM Itemdescription i WHERE i.remarks = :remarks"),
    @NamedQuery(name = "Itemdescription.findByBalance", query = "SELECT i FROM Itemdescription i WHERE i.balance = :balance"),
    @NamedQuery(name = "Itemdescription.findByAutostamp", query = "SELECT i FROM Itemdescription i WHERE i.autostamp = :autostamp")})
public class Itemdescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemdescriptionId")
    private Integer itemdescriptionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "itemSize")
    private String itemSize;
    @Size(max = 255)
    @Column(name = "remarks")
    private String remarks;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "autostamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autostamp;
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    @ManyToOne(optional = false)
    private Item itemId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemdescriptionId")
    private Collection<Stockout> stockoutCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemdescriptionId")
    private Collection<Stockin> stockinCollection;

    public Itemdescription() {
    }

    public Itemdescription(Integer itemdescriptionId) {
        this.itemdescriptionId = itemdescriptionId;
    }

    public Itemdescription(Integer itemdescriptionId, String itemSize) {
        this.itemdescriptionId = itemdescriptionId;
        this.itemSize = itemSize;
    }

    public Integer getItemdescriptionId() {
        return itemdescriptionId;
    }

    public void setItemdescriptionId(Integer itemdescriptionId) {
        this.itemdescriptionId = itemdescriptionId;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getAutostamp() {
        return autostamp;
    }

    public void setAutostamp(Date autostamp) {
        this.autostamp = autostamp;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @XmlTransient
    public Collection<Stockout> getStockoutCollection() {
        return stockoutCollection;
    }

    public void setStockoutCollection(Collection<Stockout> stockoutCollection) {
        this.stockoutCollection = stockoutCollection;
    }

    @XmlTransient
    public Collection<Stockin> getStockinCollection() {
        return stockinCollection;
    }

    public void setStockinCollection(Collection<Stockin> stockinCollection) {
        this.stockinCollection = stockinCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemdescriptionId != null ? itemdescriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemdescription)) {
            return false;
        }
        Itemdescription other = (Itemdescription) object;
        if ((this.itemdescriptionId == null && other.itemdescriptionId != null) || (this.itemdescriptionId != null && !this.itemdescriptionId.equals(other.itemdescriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vambeco.stockmanager.model.Itemdescription[ itemdescriptionId=" + itemdescriptionId + " ]";
    }
    
}
