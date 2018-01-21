package br.gov.pf.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "licenses_categories")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LicenseCategory extends AbstractEntity {


    @Column(name = "description")
    private @NotNull String description;


    public LicenseCategory(@NotNull String description) {
        this.description = description;
    }

    public LicenseCategory() {
    }

    /**
     * GETS E SETS
     */

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
