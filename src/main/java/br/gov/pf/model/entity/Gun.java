package br.gov.pf.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "guns")
public class Gun extends AbstractEntity {

    @Column(name = "description")
    private @NotNull String description;

    @Column(name = "caliber")
    private @NotNull String caliber;

    @Column(name = "serial_number")
    private @NotNull String serialNumber;

    public Gun() {
    }


    /**
     * GETS E SETS
     */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String name) {
        description = name;
    }

    public String getCaliber() {
        return this.caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
