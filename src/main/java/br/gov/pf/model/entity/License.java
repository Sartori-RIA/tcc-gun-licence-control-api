package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "licenca")
public class License extends AbstractEntity implements Serializable {


    @NotNull(message = "a licenca deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;

    @NotNull(message = "a licenca deve possuir uma categoria")
    @ManyToOne
    @JoinColumn(name = "categoria")
    private LicenseCategory licenseCategory;

    @NotNull(message = "a licenca deve possuir uma validade")
    @Column(name = "validade")
    @Future
    private Date shelfLife;

    @NotNull(message = "a licenca deve possuir um numero de serie")
    @Column(name = "serial_number")
    private String serial;


    public License() {
    }

    public License(@NotNull(message = "a licenca deve possuir uma descricao") String description,
                   @NotNull(message = "a licenca deve possuir uma categoria") LicenseCategory licenseCategory,
                   @NotNull(message = "a licenca deve possuir uma validade") @Future Date shelfLife,
                   @NotNull(message = "a licenca deve possuir um numero de serie") String serial) {
        this.description = description;
        this.licenseCategory = licenseCategory;
        this.shelfLife = shelfLife;
        this.serial = serial;
    }

    /**
     * GETS E SETS
     */

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenseCategory getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(LicenseCategory licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
