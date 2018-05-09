package br.gov.pf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size.List;

@Entity
@Table(name = "address")
class Address : AbstractEntity() {

    @Column(name = "cep")
    @NotNull
    var cep: String = ""

    @Column(name = "street")
    @NotNull
    var street: String = ""

    @Column(name = "neighborhood")
    @NotNull
    var neighborhood: String = ""

    @Column(name = "addressNumber")
    @NotNull
    var addressNumber: String = ""

    @Column(name = "complement")
    var complement: String = ""

    @ManyToOne
    @NotNull
    var city: City = City()


}
