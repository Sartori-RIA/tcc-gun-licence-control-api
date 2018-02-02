package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "licenses_categories")
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
