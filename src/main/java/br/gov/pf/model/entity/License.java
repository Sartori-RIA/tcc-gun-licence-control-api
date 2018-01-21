package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "licenses")
@JsonIgnoreProperties(ignoreUnknown = true)
public class License extends AbstractEntity {


    @Column(name = "description")
    private @NotNull String description;

    @ManyToOne
    private @NotNull LicenseCategory licenseCategory;

    @Column(name = "shelf_life")
    private @NotNull @Future Date shelfLife;

    @Column(name = "serial_number")
    private @NotNull String serial;


    public License() {
    }

    public License(@NotNull String description,
                   @NotNull LicenseCategory licenseCategory,
                   @NotNull @Future Date shelfLife,
                   @NotNull String serial) {
        this.description = description;
        this.licenseCategory = licenseCategory;
        this.shelfLife = shelfLife;
        this.serial = serial;
    }

    /**
     * GETS E SETS
     */

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenseCategory getLicenseCategory() {
        return this.licenseCategory;
    }

    public void setLicenseCategory(LicenseCategory licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public Date getShelfLife() {
        return this.shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
