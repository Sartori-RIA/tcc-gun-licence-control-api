package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "licenses_categories")
public class LicenseCategory extends AbstractEntity implements Serializable {


    @NotNull
    @Column(name = "description")
    private String description;


    public LicenseCategory(@NotNull String description) {
        this.description = description;
    }

    public LicenseCategory() {
    }

    /**
     * GETS E SETS
     */

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
