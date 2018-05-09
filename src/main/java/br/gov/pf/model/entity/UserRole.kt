package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users_roles")
class UserRole : AbstractEntity() {

    @Column(name = "description")
    @NotNull
    var description: String = ""

}
