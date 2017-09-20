/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.williandrade.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author william
 */
@Entity
@Table(name = "DEVICE_ACTION_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceActionHistory.findAll", query = "SELECT d FROM DeviceActionHistory d")
    , @NamedQuery(name = "DeviceActionHistory.findById", query = "SELECT d FROM DeviceActionHistory d WHERE d.id = :id")
    , @NamedQuery(name = "DeviceActionHistory.findByActionValue", query = "SELECT d FROM DeviceActionHistory d WHERE d.actionValue = :actionValue")
    , @NamedQuery(name = "DeviceActionHistory.findByActionDate", query = "SELECT d FROM DeviceActionHistory d WHERE d.actionDate = :actionDate")})
public class DeviceActionHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ACTION_VALUE")
    private String actionValue;
    @Basic(optional = false)
    @Column(name = "ACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;
    @JoinColumn(name = "ACTION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Action actionId;
    @JoinColumn(name = "DEVICE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Device deviceId;

    public DeviceActionHistory() {
    }

    public DeviceActionHistory(Integer id) {
        this.id = id;
    }

    public DeviceActionHistory(Integer id, String actionValue, Date actionDate) {
        this.id = id;
        this.actionValue = actionValue;
        this.actionDate = actionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
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
        if (!(object instanceof DeviceActionHistory)) {
            return false;
        }
        DeviceActionHistory other = (DeviceActionHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "me.williandrade.entity.DeviceActionHistory[ id=" + id + " ]";
    }
    
}
