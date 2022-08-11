package com.sophos.retoSpringBoot.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false, unique = true)
    private Long accountId;
    @Column(name = "client_id", nullable = false)
    Long clientId;
    @Column(name = "product", nullable = false)
    String product;
    @Column(name = "status_account", nullable = false)
    String statusAccount;
    @Column(name = "credit_value", nullable = false)
    String creditValue;
    @Column(name = "open_date")
    @CreationTimestamp
    Date openDate;
    @Column(name = "creation_date")
    @CreationTimestamp
    Date creationDate;
    @Column(name = "user_creation", nullable = false)
    String userCreation;
    @Column(name = "modification_date")
    @UpdateTimestamp
    Date modificationDate;
    @Column(name = "user_modification", nullable = false)
    String userModification;

    //Relation with Movements
    @OneToMany(targetEntity = Movement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "am_fk", referencedColumnName = "account_id")
    private List<Movement> movements;

    //Constructors
    public Account() {
    }

    public Account(Long clientId, String product, String statusAccount, String creditValue, Date openDate, Date creationDate, String userCreation, Date modificationDate, String userModification) {
        this.clientId = clientId;
        this.product = product;
        this.statusAccount = statusAccount;
        this.creditValue = creditValue;
        this.openDate = openDate;
        this.creationDate = creationDate;
        this.userCreation = userCreation;
        this.modificationDate = modificationDate;
        this.userModification = userModification;
    }

    //Getter & Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatusAccount() {
        return statusAccount;
    }

    public void setStatusAccount(String statusAccount) {
        this.statusAccount = statusAccount;
    }

    public String getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(String creditValue) {
        this.creditValue = creditValue;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
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

    //Get & Set Movement
    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }
}
