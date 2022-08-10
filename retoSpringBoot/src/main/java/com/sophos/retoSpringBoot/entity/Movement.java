package com.sophos.retoSpringBoot.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movements")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_id", nullable = false, unique = true)
    private Long movementId;
    @Column(name = "account_id", nullable = false)
    private Long accountId;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "value", nullable = false)
    private BigDecimal value;
    @Column(name = "period", nullable = false)
    private String period;
    @Column(name = "status", nullable = false)
    private String estatus;
    @Column(name = "movement_date")
    @CreationTimestamp
    private Date movementDate;
    @Column(name = "creation_date")
    @CreationTimestamp
    private Date creationDate;
    @Column(name = "user_creation", nullable = false)
    private String userCreation;
    @Column(name = "modification_date")
    @UpdateTimestamp
    private Date modificationDate;
    @Column(name = "user_modification", nullable = false)
    private String userModification;

    //Constructors
    public Movement() {
    }

    public Movement(Long accountId, String type, BigDecimal value, String period, String estatus, Date movementDate, Date creationDate, String userCreation, Date modificationDate, String userModification) {
        this.accountId = accountId;
        this.type = type;
        this.value = value;
        this.period = period;
        this.estatus = estatus;
        this.movementDate = movementDate;
        this.creationDate = creationDate;
        this.userCreation = userCreation;
        this.modificationDate = modificationDate;
        this.userModification = userModification;
    }

    //Getter & Setters
    public Long getMovementId() {
        return movementId;
    }

    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getUserModification() {
        return userModification;
    }

    public void setUserModification(String userModification) {
        this.userModification = userModification;
    }
}
