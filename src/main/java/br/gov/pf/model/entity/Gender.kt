package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

@Entity
@Table(name = "genders")
class Gender : AbstractEntity() {


    @Column(name = "description")
    @NotNull
    var description: String = ""

    @Column(name = "abbrev")
    @NotNull
    var abbrev: String = ""

}
