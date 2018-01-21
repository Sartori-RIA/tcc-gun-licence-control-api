package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "states")
@JsonIgnoreProperties(ignoreUnknown = true)
public class State extends AbstractEntity {

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "Abbrev")
    private String abbrev;

    @NotNull
    @ManyToOne
    private Country country;


    public State() {
    }


    public State(@NotNull String description, @NotNull String abbrev, @NotNull Country country) {
        this.description = description;
        this.abbrev = abbrev;
        this.country = country;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
