package br.gov.pf.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by sartori on 13/07/17.
 */
@Entity
@Table(name = "arma")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Gun implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "A arma deve possuir um nome")
    private String name;
    @NotNull(message = "A arma deve possuir um calibre")
    private String caliber;
    @NotNull(message = "A arma deve possuir um número de série")
    private String serialNumber;

    public Gun() {
    }

    public Gun(String name, String caliber, String serialNumber) {
        this.name = name;
        this.caliber = caliber;
        this.serialNumber = serialNumber;
    }

    /** GETS E SETS */
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
}