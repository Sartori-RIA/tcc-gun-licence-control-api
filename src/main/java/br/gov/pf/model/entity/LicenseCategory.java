package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "licenses_categories")
public class LicenseCategory extends AbstractEntity {


    @Column(name = "description")
    private @NotNull String description;

    @Column(name = "years_to_expirate")
    private Integer yearsExpirate;

    @OneToOne
    private Requirement requirement;

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

    public Requirement getRequirement() {
        return this.requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Integer getYearsExpirate() {
        return this.yearsExpirate;
    }

    public void setYearsExpirate(Integer yearsExpirate) {
        this.yearsExpirate = yearsExpirate;
    }
}
