package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "guns")
public class Gun extends AbstractEntity implements Serializable {

    @NotNull
    @Column(name = "description", updatable = false, insertable = false)
    private String description;

    @NotNull
    @Column(name = "description")
    private String caliber;

    @NotNull
    @Column(name = "serial_number")
    private String serialNumber;


    public Gun() {
    }


    /**
     * GETS E SETS
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name;
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

}
