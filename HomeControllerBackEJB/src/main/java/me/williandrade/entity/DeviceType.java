/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.williandrade.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author william
 */
@Entity
@Table(name = "DEVICE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceType.findAll", query = "SELECT d FROM DeviceType d")
    , @NamedQuery(name = "DeviceType.findById", query = "SELECT d FROM DeviceType d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceType.findByName", query = "SELECT d FROM DeviceType d WHERE d.name = :name")
    , @NamedQuery(name = "DeviceType.findByAvailable", query = "SELECT d FROM DeviceType d WHERE d.available = :available")})
public class DeviceType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "AVAILABLE")
    private int available;
    @JoinTable(name = "DEVICE_TYPE_ACTION", joinColumns = {
        @JoinColumn(name = "DEVICE_TYPE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ACTION_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Action> actionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceType", fetch = FetchType.LAZY)
    private Set<Device> deviceSet;

    public DeviceType() {
    }

    public DeviceType(Integer id) {
        this.id = id;
    }

    public DeviceType(Integer id, String name, int available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @XmlTransient
    public Set<Action> getActionSet() {
        return actionSet;
    }

    public void setActionSet(Set<Action> actionSet) {
        this.actionSet = actionSet;
    }

    @XmlTransient
    public Set<Device> getDeviceSet() {
        return deviceSet;
    }

    public void setDeviceSet(Set<Device> deviceSet) {
        this.deviceSet = deviceSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeviceType)) {
            return false;
        }
        DeviceType other = (DeviceType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.williandrade.entity.DeviceType[ id=" + id + " ]";
    }
    
}
