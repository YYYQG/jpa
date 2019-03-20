package com.xxx.jpa;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@DynamicUpdate
@Table(name = "user",catalog = "demo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid", unique = true, nullable = false)
    private Integer oid;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "account", nullable = false)
    private String account;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email_addr", nullable = false)
    private String emailAddr;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "salt")
    private String salt;
    //@Column(name = "entry_id")
    @Transient
    private Integer entryId;
    @Transient
    private Date entryDatetime;
    //@Column(name = "update_id")
    @Transient
    private Integer updateId;
    @Transient
    private Date updateDatetime;
    @Version
    private Integer h_version;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public Date getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(Date entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Integer getH_version() {
        return h_version;
    }

    public void setH_version(Integer h_version) {
        this.h_version = h_version;
    }
}
