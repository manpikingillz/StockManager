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
@Table(name = "site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s"),
    @NamedQuery(name = "Site.findBySiteId", query = "SELECT s FROM Site s WHERE s.siteId = :siteId"),
    @NamedQuery(name = "Site.findBySiteName", query = "SELECT s FROM Site s WHERE s.siteName = :siteName"),
    @NamedQuery(name = "Site.findByAddress", query = "SELECT s FROM Site s WHERE s.address = :address"),
    @NamedQuery(name = "Site.findByOtherInfo", query = "SELECT s FROM Site s WHERE s.otherInfo = :otherInfo"),
    @NamedQuery(name = "Site.findByAutostamp", query = "SELECT s FROM Site s WHERE s.autostamp = :autostamp")})
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "siteId")
    private Integer siteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "siteName")
    private String siteName;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "otherInfo")
    private String otherInfo;
    @Column(name = "autostamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autostamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "takentositeId")
    private Collection<Stockout> stockoutCollection;

    public Site() {
    }

    public Site(Integer siteId) {
        this.siteId = siteId;
    }

    public Site(Integer siteId, String siteName) {
        this.siteId = siteId;
        this.siteName = siteName;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Date getAutostamp() {
        return autostamp;
    }

    public void setAutostamp(Date autostamp) {
        this.autostamp = autostamp;
    }

    @XmlTransient
    public Collection<Stockout> getStockoutCollection() {
        return stockoutCollection;
    }

    public void setStockoutCollection(Collection<Stockout> stockoutCollection) {
        this.stockoutCollection = stockoutCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vambeco.stockmanager.model.Site[ siteId=" + siteId + " ]";
    }
    
}
