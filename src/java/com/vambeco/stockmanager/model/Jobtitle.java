/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vambeco.stockmanager.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Allen
 */
@Entity
@Table(name = "jobtitle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobtitle.findAll", query = "SELECT j FROM Jobtitle j"),
    @NamedQuery(name = "Jobtitle.findByJobtitleId", query = "SELECT j FROM Jobtitle j WHERE j.jobtitleId = :jobtitleId"),
    @NamedQuery(name = "Jobtitle.findByJobtitleName", query = "SELECT j FROM Jobtitle j WHERE j.jobtitleName = :jobtitleName")})
public class Jobtitle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobtitleId")
    private Integer jobtitleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "jobtitleName")
    private String jobtitleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobtitleId")
    private Collection<User> userCollection;

    public Jobtitle() {
    }

    public Jobtitle(Integer jobtitleId) {
        this.jobtitleId = jobtitleId;
    }

    public Jobtitle(Integer jobtitleId, String jobtitleName) {
        this.jobtitleId = jobtitleId;
        this.jobtitleName = jobtitleName;
    }

    public Integer getJobtitleId() {
        return jobtitleId;
    }

    public void setJobtitleId(Integer jobtitleId) {
        this.jobtitleId = jobtitleId;
    }

    public String getJobtitleName() {
        return jobtitleName;
    }

    public void setJobtitleName(String jobtitleName) {
        this.jobtitleName = jobtitleName;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobtitleId != null ? jobtitleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobtitle)) {
            return false;
        }
        Jobtitle other = (Jobtitle) object;
        if ((this.jobtitleId == null && other.jobtitleId != null) || (this.jobtitleId != null && !this.jobtitleId.equals(other.jobtitleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vambeco.stockmanager.model.Jobtitle[ jobtitleId=" + jobtitleId + " ]";
    }
    
}
