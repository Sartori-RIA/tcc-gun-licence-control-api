package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "arma")
public class Gun implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A arma deve possuir um nome")
    private String name;

    @NotNull(message = "A arma deve possuir um calibre")
    private String caliber;

    @NotNull(message = "A arma deve possuir um número de série")
    private String serialNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    public Gun() {
    }

    public Gun(@NotNull(message = "A arma deve possuir um nome") String name,
               @NotNull(message = "A arma deve possuir um calibre") String caliber,
               @NotNull(message = "A arma deve possuir um número de série") String serialNumber) {
        this.name = name;
        this.caliber = caliber;
        this.serialNumber = serialNumber;
    }

    /**
     * GETS E SETS
     */
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = new Date();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }
}
