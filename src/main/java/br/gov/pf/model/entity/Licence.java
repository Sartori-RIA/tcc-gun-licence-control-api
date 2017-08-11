package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="description")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Licence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "a licenca deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;
    @NotNull(message = "a licenca deve possuir uma categoria")
    @ManyToOne
    @JoinColumn(name = "categoria")
    private LicenceCategory licenceCategory;
    @NotNull(message = "a licenca deve possuir uma validade")
    @Column(name = "validade")
    @Future
    private Date shelfLife;

    public Licence() {
    }

    public Licence(String description, LicenceCategory licenceCategory, Date shelfLife) {
        this.description = description;
        this.licenceCategory = licenceCategory;
        this.shelfLife = shelfLife;
    }

    /** GETS E SETS */
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenceCategory getLicenceCategory() {
        return licenceCategory;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }
}
