package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "licenses_categories")
class LicenseCategory : AbstractEntity() {


    @Column(name = "description")
    @NotNull
    var description: String = ""

    @Column(name = "years_to_expirate")
    var yearsExpirate: Int = 0

    @OneToOne
    var requirement: Requirement = Requirement()


}
