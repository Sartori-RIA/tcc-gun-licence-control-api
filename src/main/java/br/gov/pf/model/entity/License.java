package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "licenses")
public class License extends AbstractEntity {

    @ManyToOne
    private @NotNull LicenseCategory category;

    @Column(name = "shelf_life")
    private @Future Date shelfLife;

    @Column(name = "serial_number")
    private String serial;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    private @NotNull User user;

    @ManyToOne
    private Gun gun;

    public License() {
    }

    /**
     * GETS E SETS
     */

    public LicenseCategory getCategory() {
        return this.category;
    }

    public void setCategory(LicenseCategory category) {
        this.category = category;
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Gun getGun() {
        return this.gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
