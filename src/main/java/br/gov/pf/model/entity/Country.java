package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country extends AbstractEntity {

    @Column(name = "description")
    private String description;

    public Country() {
    }

    public Country(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
