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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByPhone1", query = "SELECT u FROM User u WHERE u.phone1 = :phone1"),
    @NamedQuery(name = "User.findByPhone2", query = "SELECT u FROM User u WHERE u.phone2 = :phone2"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone1")
    private String phone1;
    @Size(max = 45)
    @Column(name = "phone2")
    private String phone2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<Role> roleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issuedbyuserId")
    private Collection<Stockout> stockoutCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "despatchedbyuserId")
    private Collection<Stockout> stockoutCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receivedbyuserId")
    private Collection<Stockin> stockinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveredbyuserId")
    private Collection<Stockin> stockinCollection1;
    @JoinColumn(name = "jobtitleId", referencedColumnName = "jobtitleId")
    @ManyToOne(optional = false)
    private Jobtitle jobtitleId;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    @ManyToOne(optional = false)
    private Department departmentId;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String firstName, String lastName, String phone1) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Stockout> getStockoutCollection() {
        return stockoutCollection;
    }

    public void setStockoutCollection(Collection<Stockout> stockoutCollection) {
        this.stockoutCollection = stockoutCollection;
    }

    @XmlTransient
    public Collection<Stockout> getStockoutCollection1() {
        return stockoutCollection1;
    }

    public void setStockoutCollection1(Collection<Stockout> stockoutCollection1) {
        this.stockoutCollection1 = stockoutCollection1;
    }

    @XmlTransient
    public Collection<Stockin> getStockinCollection() {
        return stockinCollection;
    }

    public void setStockinCollection(Collection<Stockin> stockinCollection) {
        this.stockinCollection = stockinCollection;
    }

    @XmlTransient
    public Collection<Stockin> getStockinCollection1() {
        return stockinCollection1;
    }

    public void setStockinCollection1(Collection<Stockin> stockinCollection1) {
        this.stockinCollection1 = stockinCollection1;
    }

    public Jobtitle getJobtitleId() {
        return jobtitleId;
    }

    public void setJobtitleId(Jobtitle jobtitleId) {
        this.jobtitleId = jobtitleId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vambeco.stockmanager.model.User[ userId=" + userId + " ]";
    }
    
}
