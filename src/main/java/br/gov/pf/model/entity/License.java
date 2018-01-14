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
@Table(name = "licenses")
public class License extends AbstractEntity implements Serializable {


    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    private LicenseCategory licenseCategory;

    @NotNull
    @Column(name = "shelf_life")
    @Future
    private Date shelfLife;

    @NotNull
    @Column(name = "serial_number")
    private String serial;


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
