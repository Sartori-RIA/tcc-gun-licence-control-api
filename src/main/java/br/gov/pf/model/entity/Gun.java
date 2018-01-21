package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gun extends AbstractEntity {

    @Column(name = "description", updatable = false, insertable = false)
    private @NotNull String description;

    @Column(name = "description")
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
