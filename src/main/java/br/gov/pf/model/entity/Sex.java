package br.gov.pf.model.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sexo")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="description")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "o campo deve possuir uma descricao")
    @Column(name = "descricao")
    private String description;
    @NotNull(message = "o campo deve possuir uma abreviacao")
    @Size.List({
            @Size(min = 1, message = "minimo de 1(um) caracter"),
            @Size(max = 1, message = "maximo de 1(um) caracter")
    })
    @Column(name = "Abreviacao")
    private String abbrev;
    public Sex() {
    }

    public Sex(String description, String abbrev) {
        this.description = description;
        this.abbrev = abbrev;
    }

    /** GETS E SETS */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public Long getId() {
        return id;
    }
}
