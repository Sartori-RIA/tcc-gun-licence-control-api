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


    @Column(name = "description")
    private @NotNull String description;

    @ManyToOne
    private @NotNull LicenseCategory category;

    @Column(name = "shelf_life")
    private @NotNull @Future Date shelfLife;

    @Column(name = "serial_number")
    private @NotNull String serial;

    @ManyToOne
    private @NotNull User user;

    public License() {
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
}
