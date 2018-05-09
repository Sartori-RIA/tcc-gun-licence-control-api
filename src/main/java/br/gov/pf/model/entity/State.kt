package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "states")
class State : AbstractEntity() {

    @NotNull
    @Column(name = "description")
    var description: String = ""

    @NotNull
    @Column(name = "Abbrev")
    var abbrev: String = ""

    @NotNull
    @ManyToOne
    var country: Country = Country()
}
