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
public class Gun  extends AbstractEntity  implements Serializable {


    @NotNull(message = "A arma deve possuir um nome")
    private String name;

    @NotNull(message = "A arma deve possuir um calibre")
    private String caliber;

    @NotNull(message = "A arma deve possuir um número de série")
    private String serialNumber;


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

}
